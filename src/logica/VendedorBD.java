package logica;

import interfaces.Notificaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Conecta en la base de Datos, en la Tabla Vendores
 *
 * @author luis_
 */
public class VendedorBD implements CRUD {

    Notificaciones mensajes = new Notificaciones();

    PreparedStatement ps;
    ResultSet rs;

    Vendedor vendedor = new Vendedor();

    Conexion con = new Conexion();
    Connection acceso;

    /**
     * Metodo para Validar si el usuario y contraseña existen y Coinciden en la
     * Base de datos
     *
     * @param usuario Usuario a Validar
     * @param pass Contraseña del usuario a validar
     * @return Devuelve el objeto Vendedor que extrae de la Base de datos
     */
    public Vendedor validarVendedor(String usuario, String pass) {

        Vendedor vendedor = new Vendedor();

        String sql = "SELECT * from vendedor WHERE usuario=? and contrasena=?";

        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                vendedor.setIdVendedor(rs.getInt(1));
                vendedor.setCedVendedor(rs.getInt(2));
                vendedor.setNombreVendedor(rs.getString(3));
                vendedor.setApellidoVendedor(rs.getString(4));
                if (rs.getInt(5) == 1) {
                    vendedor.setEstado(true);
                } else {
                    vendedor.setEstado(false);
                }
                if (rs.getInt(6) == 1) {
                    vendedor.setPermisos(true);
                } else {
                    vendedor.setPermisos(false);
                }

                vendedor.setUserVendedor(rs.getString(7));
                vendedor.setPassVendedor(rs.getString(8));
            }
        } catch (Exception e) {
            mensajes.error("Error al buscar Dato " + e.getMessage());
        }

        return vendedor;
    }

    @Override
    public List listar() {
        List<Vendedor> listaVendedores = new ArrayList<>();
        String sql = "SELECT * from vendedor";
        try {
            acceso = con.Conectar();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Vendedor v = new Vendedor();
                v.setIdVendedor(rs.getInt(1));
                v.setCedVendedor(rs.getInt(2));
                v.setNombreVendedor(rs.getString(3));
                v.setApellidoVendedor(rs.getString(4));
                if (rs.getInt(5) == 1) {
                    v.setEstado(true);
                } else {
                    v.setEstado(false);
                }
                if (rs.getInt(6) == 1) {
                    v.setPermisos(true);
                } else {
                    v.setPermisos(false);
                }
                v.setUserVendedor(rs.getString(7));
                v.setPassVendedor(rs.getString(8));
                listaVendedores.add(v);
            }

        } catch (Exception e) {
            mensajes.error("Error al listar Datos " + e.getMessage());
        }
        return listaVendedores;
    }

    @Override
    public int incluir(Object[] o) {
        int r = 0;
        String sql = "INSERT INTO vendedor(cedVendedor,nombreVendedor,apellidoVendedor,estado,permisos,usuario,contrasena) VALUES (?,?,?,?,?,?,?)";

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
            mensajes.error("Error al incluir Dato " + e.getMessage());
        }

        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE vendedor SET cedVendedor=?,nombreVendedor=?,apellidoVendedor=?,estado=?,permisos=?,usuario=?,contrasena=?  WHERE idVendedor=?";

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
            ps.setObject(8, o[7]);
            r = ps.executeUpdate();

        } catch (Exception e) {
            mensajes.error("Error al listar Datos " + e.getMessage());
        }

        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM vendedor WHERE idVendedor=?";
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
