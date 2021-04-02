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
public class Autores {
    int idAutor;
    String nombreAutor;
    String apellidoAutor;
    String pais;

    public Autores() {
    }

    public Autores(int idAutor, String nombreAutor, String apellidoAutor, String pais) {
        this.idAutor = idAutor;
        this.nombreAutor = nombreAutor;
        this.apellidoAutor = apellidoAutor;
        this.pais = pais;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getApellidoAutor() {
        return apellidoAutor;
    }

    public void setApellidoAutor(String apellidoAutor) {
        this.apellidoAutor = apellidoAutor;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Autores{" + "idAutor=" + idAutor + ", nombreAutor=" + nombreAutor + ", apellidoAutor=" + apellidoAutor + ", pais=" + pais + '}';
    }
    
    
}
