/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import interfaces.Notificaciones;

import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author luis_
 */
public class CrearFactura {

    Tiempo tiempo = new Tiempo();
    Notificaciones mensaje = new Notificaciones();

    /**
     * Metodos para Genera el Documento de la factura en PDF
     *
     * @param Productos Array de productos vendidos
     * @param NumFacura Numero de factura Generado
     * @param Cliente Nombre del Cliente
     * @param Correo Correo del cliente
     * @param Vendedor Vendedor que realizo la Venta
     * @param SubTotal  Sub total de la compra
     * @param Total  Total con los impuestos de la Compra 
     */
    public void CrearPDF(ArrayList Productos, String NumFacura, String Cliente, String Correo, String Vendedor, String SubTotal, String Total) {
        
       
        Document factura = new Document();

        try {
            //File Chooser para escoger la ubicacion de Donde Guardarlo
            JFileChooser guardarArchivo = new JFileChooser();
            guardarArchivo.setApproveButtonText("Guardar");
            guardarArchivo.showSaveDialog(null);

            PdfWriter.getInstance(factura, new FileOutputStream(guardarArchivo.getSelectedFile() + ".pdf"));
            //Imagence de Cabecera
            Image cabecera = Image.getInstance("src/imagenes/fact cabecera.jpg");
            cabecera.scaleToFit(600, 1200);
            cabecera.setAlignment(Chunk.ALIGN_CENTER);

            //Parrafos del archivo 
            Paragraph parrafo1 = new Paragraph();
            parrafo1.setAlignment(parrafo1.ALIGN_CENTER);
            parrafo1.setFont(FontFactory.getFont("Tahoma", 20, Font.BOLD, BaseColor.BLACK));
            parrafo1.add("\n");
            parrafo1.add("Número: " + NumFacura + "\n\n");

            Paragraph parrafo2 = new Paragraph();
            parrafo2.setAlignment(parrafo1.ALIGN_LEFT);
            parrafo2.setFont(FontFactory.getFont("Tahoma", 12, Font.NORMAL, BaseColor.BLACK));
            parrafo2.add("Fecha: " + tiempo.fechaHoy() + "\n");
            parrafo2.add("Vendedor: " + Vendedor + "\n");
            parrafo2.add("Cliente: " + Cliente + "\n");
            parrafo2.add("Correo: " + Correo + "\n");

            Paragraph parrafo3 = new Paragraph();
            parrafo3.setAlignment(parrafo1.ALIGN_CENTER);
            parrafo3.setFont(FontFactory.getFont("Tahoma", 17, Font.BOLD, BaseColor.BLACK));
            parrafo3.add("\nDetalles de la Compra\n");
            parrafo3.add("\n ");

            Paragraph parrafo4 = new Paragraph();
            parrafo4.setAlignment(parrafo1.ALIGN_RIGHT);
            parrafo4.setFont(FontFactory.getFont("Tahoma", 20, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo4.add("\nSubTotal: ₡" + SubTotal + "          ");
            parrafo4.add("\n");
            parrafo4.add("\nTotal + IVA: ₡" + Total + "           ");
            //parrafo4.add("\n\n\n");

            Paragraph parrafo5 = new Paragraph();
            parrafo5.setAlignment(parrafo1.ALIGN_CENTER);
            parrafo5.setFont(FontFactory.getFont("Tahoma", 10, Font.NORMAL, BaseColor.BLACK));
            parrafo5.add("\n\n");
            parrafo5.add("\nFactura Generada Automáticamente por el Sistema de Punto de Venta");
            parrafo5.add("\nSegún lo esblecido por la Dirección General de Tributación");
            parrafo5.add("\nVersión del Documento: 1.0 ");
            parrafo5.add("\nSi Hay un problema con el Documento enviar un correo a: facturaelectronica@fidelibros.com");

            //Linea Separatoria 
            Paragraph parrafo6 = new Paragraph();
            parrafo6.setAlignment(parrafo1.ALIGN_CENTER);
            parrafo6.setFont(FontFactory.getFont("Tahoma", 10, Font.NORMAL, BaseColor.BLACK));
            parrafo6.add("\n—————————————————————————————————————————\n");
            
            factura.open();

            factura.add(cabecera);
            factura.add(parrafo1);
            factura.add(parrafo2);
            factura.add(parrafo6);
            factura.add(parrafo3);

            //Tabla 
            PdfPTable tabla = new PdfPTable(6);
            tabla.setWidths(new float[]{10f, 10f, 40f, 10f, 20f, 20f}); //Crea el tamaño de las columnas

            tabla.addCell("ID");
            tabla.addCell("Cod.");
            tabla.addCell("Producto");
            tabla.addCell("Cant.");
            tabla.addCell("Precio");
            tabla.addCell("Total");
            for (int i = 0; i < Productos.size(); i++) {
                tabla.addCell(Productos.get(i).toString());
            }

            factura.add(tabla);
            factura.add(parrafo4);
            factura.add(parrafo6);
            factura.add(parrafo5);

            factura.close();

            mensaje.notificar("Se Crea Factura " + NumFacura);
        } catch (Exception e) {
            
            mensaje.error("Error al Crear la Factura Electronica " + e.getMessage());

        }

    }

}
