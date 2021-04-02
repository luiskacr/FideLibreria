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
public class DetalleVentas {
    int idDetalle;
    int ventaId;
    int libroProducto;
    int cantidad;
    double precioVenta;

    public DetalleVentas() {
    }

    public DetalleVentas(int idDetalle, int ventaId, int libroProducto, int cantidad, double precioVenta) {
        this.idDetalle = idDetalle;
        this.ventaId = ventaId;
        this.libroProducto = libroProducto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public int getLibroProducto() {
        return libroProducto;
    }

    public void setLibroProducto(int libroProducto) {
        this.libroProducto = libroProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    
}
