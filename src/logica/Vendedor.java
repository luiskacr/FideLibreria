
package logica;

/**
 * Crea el objeto Vendedor con los datos Necesarios de la Tabla Vendedores
 * @author luis_
 */
public class Vendedor {
    int idVendedor;
    int cedVendedor;
    String NombreVendedor;
    String ApellidoVendedor;
    boolean estado;
    String userVendedor;
    String passVendedor;


    public Vendedor() {
        
    }
    /**
     * 
     * @param idVendedor  ID delVendedor
     * @param cedVendedor La Ced del Vendedor
     * @param NombreVendedor El nombre del Vendedor
     * @param ApellidoVendedor El apellido del Vendedor
     * @param estado El estado si el vendedor se encuentra activos o Inactivo
     * @param userVendedor El usuario del Vendedor
     * @param passVendedor La Contraseña del usuario
     */
    public Vendedor(int idVendedor, int cedVendedor, String NombreVendedor, String ApellidoVendedor, boolean estado, String userVendedor, String passVendedor) {
        this.idVendedor = idVendedor;
        this.cedVendedor = cedVendedor;
        this.NombreVendedor = NombreVendedor;
        this.ApellidoVendedor = ApellidoVendedor;
        this.estado = estado;
        this.userVendedor = userVendedor;
        this.passVendedor = passVendedor;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getCedVendedor() {
        return cedVendedor;
    }

    public void setCedVendedor(int cedVendedor) {
        this.cedVendedor = cedVendedor;
    }

    public String getNombreVendedor() {
        return NombreVendedor;
    }

    public void setNombreVendedor(String NombreVendedor) {
        this.NombreVendedor = NombreVendedor;
    }

    public String getApellidoVendedor() {
        return ApellidoVendedor;
    }

    public void setApellidoVendedor(String ApellidoVendedor) {
        this.ApellidoVendedor = ApellidoVendedor;
    }

    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getUserVendedor() {
        return userVendedor;
    }

    public void setUserVendedor(String userVendedor) {
        this.userVendedor = userVendedor;
    }

    public String getPassVendedor() {
        return passVendedor;
    }

    public void setPassVendedor(String passVendedor) {
        this.passVendedor = passVendedor;
    }

    
    
    
}
