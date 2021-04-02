
package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Conecta en la base de Datos, en la Tabla Vendores
 * @author luis_
 */
public class VendedorBD {
    
    PreparedStatement ps;
    ResultSet rs;
    
    Vendedor vendedor = new Vendedor();
    
    Conexion con = new Conexion();
    Connection acceso;
    /**
     * Metodo para Validar si el usuario y contraseña existen y Coinciden en la Base de datos
     * @param usuario  Usuario a Validar
     * @param pass Contraseña del usuario a validar
     * @return Devuelve el objeto Vendedor que extrae de la Base de datos
     */
    public Vendedor validarVendedor(String usuario, String pass){
        Vendedor vendedor = new Vendedor();

        String sql="SELECT * from vendedor WHERE usuario=? and contrasena=?";
        
        try {
            acceso=con.Conectar();
            ps=acceso.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            while(rs.next()){
                vendedor.setIdVendedor(rs.getInt(1));   
                vendedor.setCedVendedor(rs.getInt(2));
                vendedor.setNombreVendedor(rs.getString(3));
                vendedor.setApellidoVendedor(rs.getString(4));
                if(rs.getInt(5)==1){
                    vendedor.setEstado(true);
                }else{
                   vendedor.setEstado(false); 
                }

                vendedor.setUserVendedor(rs.getString(6));
                vendedor.setPassVendedor(rs.getString(7));
            }
        } catch (Exception e) {
            
            
        }
        
        return vendedor;
    }
}
