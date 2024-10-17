package controlador;

import com.sun.jdi.connect.spi.Connection;
import conexion.Conexion;
import modelo.Editorial;
import java.sql.*;

/**
 *
 * @author luis_
 */
public class ControlEditorial {
    
    public boolean guardar (Editorial objeto){
        boolean respuesta = false;
        java.sql.Connection cn = Conexion.connectar();
       // Connection cn = Conexion.connectar();
        
        try{
                PreparedStatement consulta = cn.prepareStatement("INSERT INTO public.editorial(" +"id_editorial, nombre)" +"VALUES (?, ?);");
                consulta.setInt(1, 0);//id
                consulta.setString(2, objeto.getNombre());//nombre
            
        }catch (SQLException e){
            System.out.println("Error al registrar el ingreso de la editorial " + e);
        }
        return false;
    }
    
}
