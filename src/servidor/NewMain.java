/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.util.ArrayList;
import logica.CrearFactura;

/**
 *
 * @author luis_
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CrearFactura factura = new CrearFactura();

        ArrayList lista = new ArrayList();

        lista.add("1");
        lista.add("12");
        lista.add("La Cúpula (Under The Dome)");
        lista.add("1");
        lista.add("25300.0");
        lista.add("25300.0");
        
        lista.add("1");
        lista.add("03");
        lista.add("La Cúpula (Under The Dome)");
        lista.add("1");
        lista.add("15000.0");
        lista.add("15000.0");

        factura.CrearPDF(lista, "00000023", "Luis Carlos Porras Castro", "lporras@gmail.com", "Juan Jose Alvarado", "52300.0", "59099.0");
    }

}
