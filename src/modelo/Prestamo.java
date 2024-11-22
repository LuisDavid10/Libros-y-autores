/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import java.time.LocalDate;

/**
 *
 * @author luis_
 */
public class Prestamo {
    
    
    //Atributos
    private int id_prestamo;
    private LocalDate fecha_prestamo;
    private LocalDate fecha_devolucion;

    public Prestamo(int id_prestamo, LocalDate fecha_prestamo, LocalDate fecha_devolucion) {
        this.id_prestamo = id_prestamo;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
    }
    
    

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public LocalDate getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(LocalDate fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public LocalDate getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(LocalDate fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id_prestamo=" + id_prestamo + ", fecha_prestamo=" + fecha_prestamo + ", fecha_devolucion=" + fecha_devolucion + '}';
    }
    
    
    
}
