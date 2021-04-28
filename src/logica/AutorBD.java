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
public class AutorBD implements CRUD {

    Notificaciones mensajes = new Notificaciones();

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    List<String> paices = new ArrayList<>();

    public List ListarNombresAutores() {
        List<String> NombreAutores = new ArrayList<>();
        String sql = "SELECT * FROM autores";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Autores au = new Autores();
                au.setIdAutor(rs.getInt(1));
                au.setNombreAutor(rs.getString(2));
                au.setApellidoAutor(rs.getString(3));
                au.setPais(rs.getString(4));
                NombreAutores.add(au.getNombreAutor() + " " + au.getApellidoAutor());
            }

        } catch (Exception e) {
            mensajes.error("Error al Listar Datos " + e.getMessage());
        }

        return NombreAutores;
    }

    public String NombreAutor(int id) {
        Autores au = new Autores();
        String sql = "SELECT * FROM autores WHERE idAutor=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                au.setIdAutor(rs.getInt(1));
                au.setNombreAutor(rs.getString(2));
                au.setApellidoAutor(rs.getString(3));
                au.setPais(rs.getString(4));
            }

        } catch (Exception e) {
            mensajes.error("Error al cargar los Datos " + e.getMessage());
            return "Error";
        }
        String autor = au.getNombreAutor() + " " + au.getApellidoAutor();
        return autor;
    }

    @Override
    public List listar() {
        ArrayList<Autores> listaAutores = new ArrayList<>();
        String sql = "SELECT * FROM autores";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Autores au = new Autores();
                au.setIdAutor(rs.getInt(1));
                au.setNombreAutor(rs.getString(2));
                au.setApellidoAutor(rs.getString(3));
                au.setPais(rs.getString(4));
                listaAutores.add(au);
            }

        } catch (Exception e) {
            mensajes.error("Error al Listar Datos " + e.getMessage());
        }

        return listaAutores;
    }

    @Override
    public int incluir(Object[] o) {
        int r = 0;
        String sql = "INSERT INTO autores(nombreAutor,apellidoAutor,pais) VALUES(?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            r = ps.executeUpdate();

        } catch (Exception e) {
            mensajes.error("Error al Incluir Dato " + e.getMessage());
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE autores SET nombreAutor=?, apellidoAutor=?, pais=? WHERE idAutor=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            r = ps.executeUpdate();

        } catch (Exception e) {
            mensajes.error("Error al actualizar Dato " + e.getMessage());
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM autores WHERE idAutor=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            mensajes.error("Error al eliminar Dato " + e.getMessage());
        }
    }

    public List listaPaices() {
        paices.add("");
        paices.add("ARG");
        paices.add("BRA");
        paices.add("CAN");
        paices.add("COL");
        paices.add("CRI");
        paices.add("ESP");
        paices.add("GBR");
        paices.add("FRA");
        paices.add("ITA");
        paices.add("USA");

        return paices;
    }

    public int idPais(String nombre) {
        int cont = 0;

        for (int i = 0; i < paices.size(); i++) {

            if (nombre.equalsIgnoreCase(paices.get(i))) {
                cont = i;
            }
        }
        return cont;
    }
}
