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
public class Ventas {
    int idVentas;
    int idCliente;
    int idVendedor;
    String fechaVenta;
    double totalVenta;

    public Ventas() {
    }

    public Ventas(int idVentas, int idCliente, int idVendedor, double totalVenta) {
        this.idVentas = idVentas;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.totalVenta = totalVenta;
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }
    
    
    
    
    
}
