package modelo;

/**
 *
 * @author luis_
 */
public class Editorial {
    
    private int id_editorial;
    private String nombre;
    private int id_usuario;
    
    public Editorial(){
        this.id_editorial = 0;
        this.nombre = "";
        this.id_usuario = 0;
    }

    public int getId_editorial() {
        return id_editorial;
    }

    public void setId_editorial(int id_editorial) {
        this.id_editorial = id_editorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Editorial{" + "id_editorial=" + id_editorial + ", nombre=" + nombre + ", id_usuario=" + id_usuario + '}';
    }
    

    
    
}
