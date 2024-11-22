/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author luis_
 */
public class Libro {
 
    //Atributos
    private int id_libro;
    private int id_editorial;
    private int id_idioma;
    private String titulo;
    private int numero_Paginas;
    private int año_publicacion;
    private float precio;

    public Libro(int id_libro, int id_editorial, int id_idioma, String titulo, int numero_Paginas, int año_publicacion, float precio) {
        this.id_libro = id_libro;
        this.id_editorial = id_editorial;
        this.id_idioma = id_idioma;
        this.titulo = titulo;
        this.numero_Paginas = numero_Paginas;
        this.año_publicacion = año_publicacion;
        this.precio = precio;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getId_editorial() {
        return id_editorial;
    }

    public void setId_editorial(int id_editorial) {
        this.id_editorial = id_editorial;
    }

    public int getId_idioma() {
        return id_idioma;
    }

    public void setId_idioma(int id_idioma) {
        this.id_idioma = id_idioma;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumero_Paginas() {
        return numero_Paginas;
    }

    public void setNumero_Paginas(int numero_Paginas) {
        this.numero_Paginas = numero_Paginas;
    }

    public int getAño_publicacion() {
        return año_publicacion;
    }

    public void setAño_publicacion(int año_publicacion) {
        this.año_publicacion = año_publicacion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Libro{" + "id_libro=" + id_libro + ", id_editorial=" + id_editorial + ", id_idioma=" + id_idioma + ", titulo=" + titulo + ", numero_Paginas=" + numero_Paginas + ", a\u00f1o_publicacion=" + año_publicacion + ", precio=" + precio + '}';
    }
    
    
    
    
    
}
