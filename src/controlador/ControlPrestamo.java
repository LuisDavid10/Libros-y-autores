/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import modelo.Persona;

import VariablesGlobales.GlobalVariables;
import conexion.Conexion;
import modelo.Editorial;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author luis_
 */
public class ControlPrestamo {

    // Método para buscar una persona por ID
    public Persona buscarPersonaPorId(String id) {
        Persona persona = null;
        Connection cn = Conexion.connectar(); // Conexión a la base de datos

        try {
            String query = "SELECT id_persona, nombre, apaterno, amaterno, telefono, correo, edad, id_usuario FROM persona WHERE id_persona =?";
            PreparedStatement consulta = cn.prepareStatement(query);
             // Aquí se convierte el String a un entero usando Integer.parseInt
            consulta.setInt(1, Integer.parseInt(id));  // Usar setInt para pasar el ID como entero


            ResultSet rs = consulta.executeQuery();
            if (rs.next()) {
                // Crear el objeto Persona con los datos obtenidos
                persona = new Persona();
                persona.setId_persona(rs.getInt("id_persona"));
                persona.setNombre(rs.getString("nombres"));
                persona.setaPaterno(rs.getString("aPaterno"));
                persona.setaMaterno(rs.getString("aMaterno"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setCorreo(rs.getString("correo"));
                persona.setEdad(rs.getInt("edad"));
                persona.setId_usuario(rs.getInt("id_usuario"));
                
                System.out.println("El dato regresado es id:"+ persona.getId_persona() + "el nombre es: " +persona.getNombre());
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar la persona por ID: " + e);
        }

        return persona; // Retorna el objeto Persona o null si no se encuentra
    }

    
    
    // Método para obtener los títulos de los libros
    public ArrayList<String> obtenerTitulosDeLibros() {
        ArrayList<String> titulos = new ArrayList<>();
        Connection cn = Conexion.connectar(); // Conexión a la base de datos

        try {
            String query = "SELECT titulo FROM libros";
            PreparedStatement consulta = cn.prepareStatement(query);
            ResultSet rs = consulta.executeQuery();

            while (rs.next()) {
                titulos.add(rs.getString("titulo")); // Agrega los títulos a la lista
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los títulos de los libros: " + e);
        } finally {
            try {
                if (cn != null) cn.close(); // Cerrar la conexión
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e);
            }
        }

        return titulos; // Retorna la lista de títulos
    }

    
    
    // Método main para probar la funcionalidad
    public static void main(String[] args) {
        ControlPrestamo control = new ControlPrestamo();
        
        // Llamamos al método para buscar la persona con el ID "1"
        String id = "1"; // Prueba con un ID válido
        Persona persona = control.buscarPersonaPorId(id);
        
        if (persona != null) {
            System.out.println("Persona encontrada: " + persona);
        } else {
            System.out.println("Persona no encontrada.");
        }
    }
    
    
    
    
    
    
}
