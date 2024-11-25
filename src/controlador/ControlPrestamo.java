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
import java.util.List;

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
                persona.setNombre(rs.getString("nombre"));
                persona.setaPaterno(rs.getString("apaterno"));
                persona.setaMaterno(rs.getString("amaterno"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setCorreo(rs.getString("correo"));
                persona.setEdad(rs.getInt("edad"));
                persona.setId_usuario(rs.getInt("id_usuario"));

                System.out.println("El dato regresado es id:" + persona.getId_persona() + "el nombre es: " + persona.getNombre());
                System.out.println("El toString: " + persona.toString());
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
            String query = "SELECT titulo from libro";
            PreparedStatement consulta = cn.prepareStatement(query);
            ResultSet rs = consulta.executeQuery();

            while (rs.next()) {
                titulos.add(rs.getString("titulo")); // Agrega los títulos a la lista
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los títulos de los libros: " + e);
        } finally {
            try {
                if (cn != null) {
                    cn.close(); // Cerrar la conexión
                }
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
        String id = "2"; // Prueba con un ID válido
        Persona persona = control.buscarPersonaPorId(id);

        if (persona != null) {
            System.out.println("Persona encontrada: " + persona);
        } else {
            System.out.println("Persona no encontrada.");
        }

        // Instancia de la clase que contiene el método obtenerTitulosDeLibros
        // MiClaseDeLibros claseDeLibros = new MiClaseDeLibros();
        // Llamar al método y obtener la lista de títulos
        ArrayList<String> titulos = control.obtenerTitulosDeLibros();

        // Imprimir los títulos obtenidos
        if (titulos.isEmpty()) {
            System.out.println("No se encontraron libros en la base de datos.");
        } else {
            System.out.println("Títulos de libros encontrados:");
            for (String titulo : titulos) {
                System.out.println("- " + titulo);
            }
        }
    }

    public boolean guardarPrestamo(java.sql.Date fechaPrestamo, java.sql.Date fechaDevolucion, int idPersona, List<String> titulosLibros) {
        boolean respuesta = false;
        java.sql.Connection cn = Conexion.connectar();

        try {
            // Inserción en la tabla prestamo
            String queryPrestamo = "INSERT INTO prestamo (fecha_prestamo, fecha_devolucion, id_usuario) VALUES (?, ?, ?) RETURNING id_prestamo";
            PreparedStatement stmtPrestamo = cn.prepareStatement(queryPrestamo);
            stmtPrestamo.setDate(1, fechaPrestamo);
            stmtPrestamo.setDate(2, fechaDevolucion);
            stmtPrestamo.setInt(3, GlobalVariables.idUsuario);

            ResultSet rs = stmtPrestamo.executeQuery();
            if (rs.next()) {
                int idPrestamo = rs.getInt("id_prestamo");

                // Inserción en la tabla persona_prestamo
                String queryPersonaPrestamo = "INSERT INTO persona_prestamo (id_prestamo, id_persona) VALUES (?, ?)";
                PreparedStatement stmtPersonaPrestamo = cn.prepareStatement(queryPersonaPrestamo);
                stmtPersonaPrestamo.setInt(1, idPrestamo);
                stmtPersonaPrestamo.setInt(2, idPersona);
                stmtPersonaPrestamo.executeUpdate();

                // Obtener los IDs de los libros y guardarlos en prestamo_libro
                for (String titulo : titulosLibros) {
                    int idLibro = obtenerIdLibroPorTitulo(cn, titulo);
                    if (idLibro > 0) {
                        String queryPrestamoLibro = "INSERT INTO prestamo_libro (id_prestamo, id_libro) VALUES (?, ?)";
                        PreparedStatement stmtPrestamoLibro = cn.prepareStatement(queryPrestamoLibro);
                        stmtPrestamoLibro.setInt(1, idPrestamo);
                        stmtPrestamoLibro.setInt(2, idLibro);
                        stmtPrestamoLibro.executeUpdate();
                    } else {
                        System.out.println("No se encontró el libro con título: " + titulo);
                    }
                }

                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar el préstamo: " + e);
        }

        return respuesta;
    }

    private int obtenerIdLibroPorTitulo(Connection cn, String titulo) {
        int idLibro = -1;
        try {
            String query = "SELECT id_libro FROM libro WHERE titulo = ?";
            PreparedStatement stmt = cn.prepareStatement(query);
            stmt.setString(1, titulo);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idLibro = rs.getInt("id_libro");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el ID del libro: " + e);
        }
        return idLibro;
    }

    // Método para obtener el próximo ID sin avanzar la secuencia
    public int obtenerProximoIdPrestamo() {
        int nextId = 0;
        String sql = "SELECT last_value + 1 AS next_id FROM prestamo_id_prestamo_seq";
        
        try (Connection cn = Conexion.connectar();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                nextId = rs.getInt("next_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener el próximo ID: " + e.getMessage());
        }
        
        return nextId;
    }
}
