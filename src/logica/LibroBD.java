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
public class LibroBD implements CRUD {

    Notificaciones mensajes = new Notificaciones();

    PreparedStatement ps;
    ResultSet rs;

    Libro libro = new Libro();
    AutorBD autorDB = new AutorBD();

    Conexion con = new Conexion();
    Connection acceso;

    public List inventario() {
        List<Object[]> inventario = new ArrayList<>();
        String sql = "select libros.idLibro,libros.nombreLibro,autores.nombreAutor,autores.apellidoAutor,libros.editorial,\n"
                + "libros.genero,autores.pais,libros.stock,libros.precio \n"
                + "from libros\n"
                + "inner join autores on libros.autor = autores.idAutor;";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object[] rp = new Object[9];
                rp[0] = rs.getString(1);
                rp[1] = rs.getString(2);
                rp[2] = rs.getString(3);
                rp[3] = rs.getString(4);
                rp[4] = rs.getString(5);
                rp[5] = rs.getString(6);
                rp[6] = rs.getString(7);
                rp[7] = rs.getString(8);
                rp[8] = rs.getString(9);

                inventario.add(rp);
            }
        } catch (Exception e) {
            mensajes.error("Error al cargar las Ventas " + e.getMessage());
        }
        return inventario;
    }

    public Libro listarID(int idLibro) {
        String sql = "SELECT * FROM libros WHERE idLibro=?";
        Libro libro = new Libro();
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setInt(1, idLibro);
            rs = ps.executeQuery();
            while (rs.next()) {
                libro.setIdLibro(rs.getInt(1));
                libro.setNombreLibro(rs.getString(2));
                libro.setAutor(rs.getInt(3));
                libro.setAutortxt(autorDB.NombreAutor(rs.getInt(3)));
                libro.setEditorial(rs.getString(4));
                libro.setGenero(rs.getString(5));
                libro.setStock(rs.getInt(6));
                libro.setPrecio(rs.getDouble(7));
            }

        } catch (Exception e) {
            mensajes.error("Error al listar Datos " + e.getMessage());
        }

        return libro;
    }

    @Override
    public List listar() {
        List<Libro> listaLibros = new ArrayList<>();
        String sql = "SELECT * FROM libros";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setIdLibro(rs.getInt(1));
                libro.setNombreLibro(rs.getString(2));
                libro.setAutor(rs.getInt(3));
                libro.setAutortxt(autorDB.NombreAutor(rs.getInt(3)));
                libro.setEditorial(rs.getString(4));
                libro.setGenero(rs.getString(5));
                libro.setStock(rs.getInt(6));
                libro.setPrecio(rs.getDouble(7));
                listaLibros.add(libro);

            }
        } catch (Exception e) {
            mensajes.error("Error al listar Datos " + e.getMessage());
        }
        return listaLibros;
    }

    public void ActualizarStockLibro(int cantidad, int idLibro) {
        String sql = "UPDATE libros SET stock=? WHERE idLibro=?";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setInt(2, idLibro);
            ps.executeUpdate();

        } catch (Exception e) {
        }

    }

    @Override
    public int incluir(Object[] o) {
        int r = 0;
        String sql = "INSERT INTO libros(nombreLibro,autor,editorial,genero,stock,precio) VALUES(?,?,?,?,?,?)";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            mensajes.error("Error al incluir Dato " + e.getMessage());

        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE libros set nombreLibro=?,autor=?,editorial=?,genero=?,stock=?,precio=? WHERE idlibro=?";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.setObject(7, o[6]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            mensajes.error("Error al actualizar Dato " + e.getMessage());
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM libros WHERE idLibro=?";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            mensajes.error("Error al eliminar Dato " + e.getMessage());
        }
    }
}
