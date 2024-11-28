/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author luis_
 */
public class Prestamo {
    
    
    //Atributos
    private int id_prestamo;
    private Date fecha_prestamo;
    private Date fecha_devolucion;

    public Prestamo(int id_prestamo, Date fecha_prestamo, Date fecha_devolucion) {
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

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    

    @Override
    public String toString() {
        return "Prestamo{" + "id_prestamo=" + id_prestamo + ", fecha_prestamo=" + fecha_prestamo + ", fecha_devolucion=" + fecha_devolucion + '}';
    }
    
    
    
}
