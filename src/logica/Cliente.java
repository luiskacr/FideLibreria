/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author luis_
 */
public class Cliente {
    
    int id;
    int cedCliente;
    String nombreCliente;
    String apellidoCliente;
    String correoCliente;
    String direccionCliente;
    String usuario;
    String password;

    public Cliente() {
    }

    public Cliente(int id, int cedCliente, String nombreCliente, String apellidoCliente, String correoCliente, String direccionCliente, String usuario, String password) {
        this.id = id;
        this.cedCliente = cedCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.correoCliente = correoCliente;
        this.direccionCliente = direccionCliente;
        this.usuario = usuario;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCedCliente() {
        return cedCliente;
    }

    public void setCedCliente(int cedCliente) {
        this.cedCliente = cedCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", cedCliente=" + cedCliente + ", nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente + ", correoCliente=" + correoCliente + ", direccionCliente=" + direccionCliente + ", usuario=" + usuario + ", password=" + password + '}';
    }
    
    
    
}
