/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author luis_
 */
public class Persona {
    //Atributos
    private int id_persona;
    private String nombres;
    private String aPaterno;
    private String aMaterno;
    private String telefono;
    private String Correo;
    private int edad;

    
    public Persona(int id_persona, String nombres, String aPaterno, String aMaterno, String Telefono, String Correo, int edad) {
        this.id_persona = id_persona;
        this.nombres = nombres;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.telefono = Telefono;
        this.Correo = Correo;
        this.edad = edad;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String Telefono) {
        this.telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "id_persona=" + id_persona + ", nombres=" + nombres + ", aPaterno=" + aPaterno + ", aMaterno=" + aMaterno + ", Telefono=" + telefono + ", Correo=" + Correo + ", edad=" + edad + '}';
    }
    
    
}
