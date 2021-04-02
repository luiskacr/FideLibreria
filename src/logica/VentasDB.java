/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author luis_
 */
public class VentasDB {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int respusta = 0;
    

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
            ps.setFloat(3,(float)v.getTotalVenta());

            respusta= ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al Guardar la venta");
            e.printStackTrace();
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
            ps.setFloat(4, (float)dv.getPrecioVenta());
            
            respusta = ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al Guardar el detalle de venta");
            e.printStackTrace();
        }
        return respusta;
    }
}
