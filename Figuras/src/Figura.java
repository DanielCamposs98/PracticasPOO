
public abstract class Figura {

    private String nombre;

    Figura(String nombre) {
        this.nombre = nombre;
    }

    public abstract double area();

    public abstract double perimetro();

    public void setNombre(String n) {
        this.nombre = n;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return "Nombre: " + nombre;
    }

}
