package ClasesBase;


public class Participante {
    
    protected String nombre, escuela;

   public  Participante(String nombre, String escuela) {
     this.nombre=nombre;
     this.escuela=escuela;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }
    
     @Override
    public String toString() {
        return "Nombre: " + nombre + ".\nEscuela: " + escuela + '.';
    }
}
