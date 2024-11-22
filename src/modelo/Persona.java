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
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String telefono;
    private String correo;
    private int edad;
    private int id_usuario;

    
    public Persona() {
}

    
    public Persona(int id_persona, String nombres, String aPaterno, String aMaterno, String Telefono, String Correo, int edad, int id_ususario) {
        this.id_persona = id_persona;
        this.nombre = nombres;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.telefono = Telefono;
        this.correo = Correo;
        this.edad = edad;
        this.id_usuario = id_ususario;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return correo;
    }

    public void setCorreo(String Correo) {
        this.correo = Correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Persona{" + "id_persona=" + id_persona + ", nombre=" + nombre + ", aPaterno=" + aPaterno + ", aMaterno=" + aMaterno + ", telefono=" + telefono + ", correo=" + correo + ", edad=" + edad + ", id_usuario=" + id_usuario + '}';
    }
    
    

    
    
}
