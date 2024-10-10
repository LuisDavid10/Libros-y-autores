/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author luis_
 */
public class Usuario {
    //Atributos
    private int id_usuarios;
    private String cuenta;
    private String clave;
    private String nombre;
    private String apaterno;
    private String amaterno;

    //constructor
    public Usuario() {
        this.id_usuarios = 0;
        this.cuenta = "";
        this.clave = "";
        this.nombre = "";
        this.apaterno = "";
        this.amaterno = "";
    }

    //metodos get y set

    public int getId_usuarios() {
        return id_usuarios;
    }

    public void setId_usuarios(int id_usuarios) {
        this.id_usuarios = id_usuarios;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }
    
    //toString

    @Override
    public String toString() {
        return "Usuario{" + "id_usuarios=" + id_usuarios + ", cuenta=" + cuenta + ", clave=" + clave + ", nombre=" + nombre + ", apaterno=" + apaterno + ", amaterno=" + amaterno + '}';
    }
    
}
