package ClasesBase;


public class Persona {

    protected String nombre, apellido;
    private char sexo;

    public Persona(String nombre, String apellido, char s) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = s;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String toString() {
        return "Nombre: " + nombre + ".\nApellido: " + apellido + ".\n";
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    public String toStringCons(){
        return nombre+"-"+apellido+"-"+sexo;
    }
}
