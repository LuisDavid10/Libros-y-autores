/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author luis_
 */
public class Prestamo_has_Libro {
    
       //Atributos
    private int id_prestamo;
    private int id_libro;

    public Prestamo_has_Libro(int id_prestamo, int id_libro) {
        this.id_prestamo = id_prestamo;
        this.id_libro = id_libro;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    @Override
    public String toString() {
        return "Prestamo_has_libro{" + "id_prestamo=" + id_prestamo + ", id_libro=" + id_libro + '}';
    }
    
    
    
}
