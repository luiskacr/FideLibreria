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
public class AutorBD implements CRUD {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

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
        }

        return listaAutores;
    }

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
            System.out.println(e);
            e.printStackTrace();
            return "Error";
        }
        String autor = au.getNombreAutor() + " " + au.getApellidoAutor();
        return autor;
    }

    @Override
    public int incluir(Object[] o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Object[] o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List listaPaices() {
        List<String> paices = new ArrayList<>();
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
}
