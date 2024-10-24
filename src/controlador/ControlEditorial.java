package controlador;

import conexion.Conexion;
import modelo.Editorial;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author luis_
 */
public class ControlEditorial {

    //metodo para registrar el ingreso de un libro
    public boolean guardar(Editorial objeto) {
        boolean respuesta = false;
        java.sql.Connection cn = Conexion.connectar();
        // Connection cn = Conexion.connectar();

        try {
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO public.editorial(nombre) VALUES (?);");

            //consulta.setInt(1, 0);//id
            consulta.setString(1, objeto.getNombre()); // Solo establecemos el nombre

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al registrar el ingreso de la editorial: " + e);
        }
        return respuesta;
    }

    // Método para consultar o buscar editoriales
    public ArrayList<Editorial> listaEditoriales = new ArrayList<>();

    public ArrayList<Editorial> buscarEditorialytodo(int id, String nombre) {
        String sql = "SELECT * FROM editorial WHERE 1=1"; // Base de la consulta
        if (id != 0) { // id no puede estar vacío, ya que es un entero
            sql += " AND id_editorial = " + id;
        }
        if (!nombre.isEmpty()) { // Si el nombre no está vacío, añade la condición
            sql += " AND nombre LIKE '%" + nombre + "%'";
        }

        Statement st;
        try {
            Connection cn = Conexion.connectar(); // Conexión a la base de datos
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql); // Ejecutar la consulta

            Editorial editorial;
            while (rs.next()) {
                editorial = new Editorial();
                editorial.setId_editorial(rs.getInt("id_editorial"));
                editorial.setNombre(rs.getString("nombre"));

                listaEditoriales.add(editorial); // Agregar a la lista
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar editoriales: " + e);
        }
        return listaEditoriales;
    }

    public boolean eliminarEditorial(int id, String nombre) {
        boolean respuesta = false;
        Connection cn = Conexion.connectar();
        String sql = "";

        try {
            // Construir la consulta SQL según los parámetros
            if (id > 0 && !nombre.isEmpty()) {
                sql = "DELETE FROM public.editorial WHERE id_editorial = ? OR nombre = ?;";
            } else if (id > 0) {
                sql = "DELETE FROM public.editorial WHERE id_editorial = ?;";
            } else if (!nombre.isEmpty()) {
                sql = "DELETE FROM public.editorial WHERE nombre = ?;";
            } else {
                // Si no se proporciona ni ID ni nombre, no hay nada que eliminar
                System.out.println("No se proporcionó ID ni nombre para eliminar.");
                return false;
            }

            PreparedStatement consulta = cn.prepareStatement(sql);

            // Establecer los parámetros en la consulta SQL
            if (id > 0 && !nombre.isEmpty()) {
                consulta.setInt(1, id);
                consulta.setString(2, nombre);
            } else if (id > 0) {
                consulta.setInt(1, id);
            } else {
                consulta.setString(1, nombre);
            }

            // Ejecutar la consulta de eliminación
            if (consulta.executeUpdate() > 0) {
                respuesta = true; // Si la operación fue exitosa
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar la editorial: " + e);
        }
        return respuesta;
    }
    
    public boolean actualizarEditorial(int id, String nuevoNombre) {
    boolean respuesta = false;
    Connection cn = Conexion.connectar();
    
    try {
        // Crear la consulta para actualizar el nombre de la editorial
        String sql = "UPDATE public.editorial SET nombre = ? WHERE id_editorial = ?;";
        PreparedStatement consulta = cn.prepareStatement(sql);
        
        // Establecer los parámetros (nuevo nombre y id)
        consulta.setString(1, nuevoNombre);
        consulta.setInt(2, id);
        
        // Ejecutar la consulta de actualización
        if (consulta.executeUpdate() > 0) {
            respuesta = true; // Si la operación fue exitosa
        }

    } catch (SQLException e) {
        System.out.println("Error al actualizar la editorial: " + e);
    }
    
    return respuesta;
}


}
