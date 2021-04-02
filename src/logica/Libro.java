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
public class Libro {
    int idLibro;
    String nombreLibro;
    int autor;
    String autortxt;
    String editorial;
    String genero;
    int stock;
    double precio;

    public Libro() {
    }

    public Libro(int idLibro, String nombreLibro, String editorial, String genero, int stock, double precio) {
        this.idLibro = idLibro;
        this.nombreLibro = nombreLibro;
        this.editorial = editorial;
        this.genero = genero;
        this.stock = stock;
        this.precio = precio;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public String getAutortxt() {
        return autortxt;
    }

    public void setAutortxt(String autortxt) {
        this.autortxt = autortxt;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", nombreLibro=" + nombreLibro + ", autor=" + autor + ", autortxt=" + autortxt + ", editorial=" + editorial + ", genero=" + genero + ", stock=" + stock + ", precio=" + precio + '}';
    }
    
    
}
