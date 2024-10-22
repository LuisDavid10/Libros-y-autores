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
    
    
    //metodo para registrar el ingreso de un libro
    public boolean guardar (Editorial objeto){
        boolean respuesta = false;
        java.sql.Connection cn = Conexion.connectar();
       // Connection cn = Conexion.connectar();
        
        try{
                PreparedStatement consulta = cn.prepareStatement("INSERT INTO public.editorial(nombre) VALUES (?);");
                
                //consulta.setInt(1, 0);//id
                consulta.setString(1, objeto.getNombre()); // Solo establecemos el nombre
                
            
                if(consulta.executeUpdate()>0){
                    respuesta = true;
                }
                
        }catch (SQLException e){
            System.out.println("Error al registrar el ingreso de la editorial: " + e);
        }
        return respuesta;
    }
    
}




