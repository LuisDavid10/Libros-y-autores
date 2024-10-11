package controlador;

import conexion.Conexion;
import modelo.Usuario;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author luis_
 */
public class ControlUsuario {

    //metodo para iniciar secion 
    public boolean login(Usuario objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.connectar();
        String sql = "select cuenta, clave from usuarios where cuenta = '" + objeto.getCuenta()+ "' and clave = '" + objeto.getClave()+ "'";

        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al iniaiar sesion, revise sus credenciales");
            JOptionPane.showMessageDialog(null, "Error al iniaiar sesion, revise sus credenciales");
        }
        return respuesta;
    }
}
