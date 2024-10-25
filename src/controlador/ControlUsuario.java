package controlador;

import VariablesGlobales.GlobalVariables;
import conexion.Conexion;
import modelo.Usuario;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author luis_
 */
public class ControlUsuario {
   

    // Método para iniciar sesión
    public boolean login(Usuario objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.connectar();
        
        // Usamos PreparedStatement para evitar inyección SQL
        String sql = "SELECT id_usuario, nombre, cuenta FROM public.usuarios WHERE cuenta = ? AND clave = ?";
        
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            // Se pasan los valores usando setString para evitar inyección SQL
            st.setString(1, objeto.getCuenta());  // Reemplaza el '?' por el valor de 'cuenta'
            st.setString(2, objeto.getClave());   // Reemplaza el '?' por el valor de 'clave'
            
            ResultSet rs = st.executeQuery();
            
            // Si encontramos el usuario, lo almacenamos en las variables globales
            if (rs.next()) {
                respuesta = true;
                
                // Asignamos los valores a las variables globales
                GlobalVariables.idUsuario = rs.getInt("id_usuario");  // Guardamos el id del usuario
                objeto.setNombre(rs.getString("nombre"));
                GlobalVariables.nombreUsuario = rs.getString("nombre"); // Guardamos el nombre del usuario
                objeto.setId_usuarios(rs.getInt("id_usuario"));
                System.out.println("Inicio sesión correctamente");
                System.out.println("Cuenta: " + rs.getString("cuenta"));
                System.out.println("Nombre: " + GlobalVariables.nombreUsuario);
                
                System.out.println("ID Usuario: " + GlobalVariables.idUsuario);
            } else {
                // Si no se encuentra, mostramos un mensaje
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión, revise sus credenciales: " + e);
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión, revise sus credenciales");
        }
        
        return respuesta;
    }


//    //metodo para iniciar secion 
//    public boolean login(Usuario objeto) {
//        boolean respuesta = false;
//        Connection cn = Conexion.connectar();
//        //String sql = "select cuenta, clave from usuarios where cuenta = '" + objeto.getCuenta()+ "' and clave = '" + objeto.getClave()+ "'";
//        // Usamos PreparedStatement para evitar inyección SQL
//        String sql = "SELECT id_usuario, nombre, cuenta FROM public.usuarios WHERE cuenta = ? AND clave = ?";
//        
//        
//        Statement st;
//
//        try {
//            st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                respuesta = true;
//            }
//        } catch (SQLException e) {
//            System.out.println("Error al iniaiar sesion, revise sus credenciales");
//            JOptionPane.showMessageDialog(null, "Error al iniaiar sesion, revise sus credenciales");
//        }
//        return respuesta;
//    }
}
