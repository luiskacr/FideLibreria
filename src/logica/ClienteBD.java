/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis_
 */
public class ClienteBD implements CRUD {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public Cliente buscarCliente(int cedCliente) {
        Cliente c = new Cliente();
        String sql = "SELECT idcliente FROM cliente WHERE cedCliente=?;";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cedCliente);
            rs = ps.executeQuery();
            while (rs.next()) {

                c.setId(rs.getInt(1));
                c.setCedCliente(rs.getInt(2));
                c.setNombreCliente(rs.getString(3));
                c.setApellidoCliente(rs.getString(4));
                c.setCorreoCliente(rs.getString(5));
                c.setDireccionCliente(rs.getString(6));
                c.setUsuario(rs.getString(7));
            }
        } catch (Exception e) {

        }

        return c;
    }

    public Cliente ListarId(String id) {
        Cliente c = new Cliente();
        String sql = "SELECT * FROM cliente WHERE cedCliente=?";

        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {

                c.setId(rs.getInt(1));
                c.setCedCliente(rs.getInt(2));
                c.setNombreCliente(rs.getString(3));
                c.setApellidoCliente(rs.getString(4));
                c.setCorreoCliente(rs.getString(5));
                c.setDireccionCliente(rs.getString(6));
                c.setUsuario(rs.getString(7));
            }
        } catch (Exception e) {

        }

        return c;
    }

    @Override
    public List listar() {
        List<Cliente> listaCliente = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                c.setCedCliente(rs.getInt(2));
                c.setNombreCliente(rs.getString(3));
                c.setApellidoCliente(rs.getString(4));
                c.setCorreoCliente(rs.getString(5));
                c.setDireccionCliente(rs.getString(6));
                c.setUsuario(rs.getString(7));
                listaCliente.add(c);
            }
        } catch (Exception e) {
        }

        return listaCliente;
    }

    @Override
    public int incluir(Object[] o) {
        int r = 0;
        String sql = "INSERT INTO cliente(cedCliente,nombreCliente,apellidoCliente,correoCliente,direccion,usuario) VALUES(?,?,?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al incluir los Datos");
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE cliente set cedCliente=?, nombreCliente=?,apellidoCliente=?,correoCliente=?,direccion=?,usuario=? WHERE idcliente=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[5]);
            ps.setObject(6, o[4]);
            ps.setObject(7, o[6]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error query");
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM cliente WHERE idcliente=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

}
