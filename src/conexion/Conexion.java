/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.*;

/**
 *
 * @author User
 */
public class Conexion {
    
    public static Connection connectar(){
        try {
            Connection cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/My_LibrosAutores", "postgres", "Hinojosa");
            System.out.println("Conexión exitosa");
            return cn;
        }catch(SQLException e) {
            System.out.println("Error de conexión local");
        }
        return null;
    }
    
    
     public static void main(String[] args) {
        // Intentar conectar a la base de datos
        Connection cn = Conexion.connectar();
        
        // Verificar si la conexión fue exitosa
        if (cn != null) {
            System.out.println("La conexión a la base de datos postgres se realizó correctamente.");
        } else {
            System.out.println("No se pudo conectar a la base de datos postgres.");
        }
    }
}
