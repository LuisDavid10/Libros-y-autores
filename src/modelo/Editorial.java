package modelo;

/**
 *
 * @author luis_
 */
public class Editorial {
    
    private int id_editorial;
    private String nombre;
    
    public Editorial(){
        this.id_editorial = 0;
        this.nombre = "";
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

    @Override
    public String toString() {
        return "Editorial{" + "id_editorial=" + id_editorial + ", nombre=" + nombre + '}';
    }
    
}
