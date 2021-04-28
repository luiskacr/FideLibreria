/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import interfaces.Notificaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis_
 */
public class VentasDB {

    Notificaciones mensajes = new Notificaciones();

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int respusta = 0;

    public List reporteVentas(String fecha1, String fecha2) {
        List<Object[]> reporte = new ArrayList<>();

        String sql = "SELECT factura.idDetalle, factura.ventaId ,libros.nombreLibro,factura.cantidad,factura.precioVenta,\n"
                + "cliente.nombreCliente,vendedor.nombreVendedor,ventas.fechaVenta\n"
                + "FROM factura \n"
                + "INNER JOIN ventas on factura.ventaId = ventas.idVentas\n"
                + "INNER JOIN cliente on ventas.idCliente = cliente.idcliente\n"
                + "INNER JOIN vendedor on ventas.idVendedor = vendedor.idVendedor\n"
                + "INNER JOIN libros on factura.producto = libros.idLibro\n"
                + "where fechaVenta BETWEEN ? AND ?";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, fecha1);
            ps.setString(2, fecha2);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object[] rp = new Object[8];
                rp[0] = rs.getString(1);
                rp[1] = rs.getString(2);
                rp[2] = rs.getString(3);
                rp[3] = rs.getString(4);
                rp[4] = rs.getString(5);
                rp[5] = rs.getString(6);
                rp[6] = rs.getString(7);
                rp[7] = rs.getString(8);
                
                reporte.add(rp);
            }
        } catch (Exception e) {
            mensajes.error("Error al cargar las Ventas " + e.getMessage());
        }

        return reporte;
    }

    public String cantidadVentasPorVendedor(int idVendedor, String fecha1, String fecha2) {
        String cantidadVentas = "";
        String sql = "SELECT COUNT(idventas) from ventas WHERE idVendedor=? and fechaVenta BETWEEN ? AND ?";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idVendedor);
            ps.setString(2, fecha1);
            ps.setString(3, fecha2);
            rs = ps.executeQuery();
            while (rs.next()) {
                cantidadVentas = rs.getString(1);
            }
        } catch (Exception e) {
            mensajes.error("Error al cargar las Ventas " + e.getMessage());
        }

        return cantidadVentas;
    }

    public String cantidadTotalVentas(String fecha1, String fecha2) {
        String cantidadVentas = "";
        String sql = "SELECT COUNT(idventas) from ventas WHERE fechaVenta BETWEEN ? AND ?";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, fecha1);
            ps.setString(2, fecha2);
            rs = ps.executeQuery();
            while (rs.next()) {
                cantidadVentas = rs.getString(1);
            }
        } catch (Exception e) {
            mensajes.error("Error al cargar las Ventas " + e.getMessage());
        }

        return cantidadVentas;
    }

    public String totalVentaPorVendedor(int idVendedor, String fecha1, String fecha2) {
        String ventasTotal = "";
        String sql = "SELECT SUM(montoVenta) from ventas WHERE idVendedor=? and fechaVenta BETWEEN ? AND ?";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idVendedor);
            ps.setString(2, fecha1);
            ps.setString(3, fecha2);
            rs = ps.executeQuery();
            while (rs.next()) {
                ventasTotal = rs.getString(1);
            }
        } catch (Exception e) {
            mensajes.error("Error al cargar las Ventas " + e.getMessage());
        }

        return ventasTotal;
    }

    public String totalVentas(String fecha1, String fecha2) {
        String ventasTotal = "";
        String sql = "SELECT SUM(montoVenta) from ventas WHERE fechaVenta BETWEEN ? AND ?";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, fecha1);
            ps.setString(2, fecha2);
            rs = ps.executeQuery();
            while (rs.next()) {
                ventasTotal = rs.getString(1);
            }
        } catch (Exception e) {
            mensajes.error("Error al cargar las Ventas " + e.getMessage());
        }

        return ventasTotal;
    }

    public String idVentas() {
        String idv = "";
        String sql = "SELECT max(idVentas) FROM ventas";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idv = rs.getString(1);
            }

        } catch (Exception e) {
            mensajes.error("Error al buscar Dato " + e.getMessage());
        }
        return idv;
    }

    public int GuardarVentas(Ventas v) {
        String sql = "INSERT INTO ventas(idCliente,idVendedor,montoVenta) VALUES(?,?,?)";
        //Ventas ventas = new Ventas();
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);

            ps.setInt(1, v.getIdCliente());
            ps.setInt(2, v.getIdVendedor());
            ps.setFloat(3, (float) v.getTotalVenta());

            respusta = ps.executeUpdate();
        } catch (Exception e) {
            mensajes.error("Error al almacenar Dato " + e.getMessage());
        }
        return respusta;
    }

    public int GuardarDetalleVentas(DetalleVentas dv) {
        String sql = "INSERT INTO factura (ventaId,producto,cantidad,precioVenta) VALUES(?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dv.getVentaId());
            ps.setInt(2, dv.getLibroProducto());
            ps.setInt(3, dv.getCantidad());
            ps.setFloat(4, (float) dv.getPrecioVenta());

            respusta = ps.executeUpdate();
        } catch (Exception e) {
            mensajes.error("Error al almacenar Dato " + e.getMessage());
        }
        return respusta;
    }
}
