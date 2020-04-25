package ClasesBase;

public class Contacto {
//Atributos

    private String nombre, correo;
    private long telefono1, telefono2;
    private char tpContacto;

//Constructor
    public Contacto(String nombre, long telefono1, long telefono2, String correo, char tpContacto) {
        this.nombre = nombre;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.correo = correo;
        this.tpContacto = tpContacto;
    }
//Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public char getTpContacto() {
        return tpContacto;
    }

    public void setTpContacto(char tpContacto) {
        this.tpContacto = tpContacto;
    }

    public long getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(long telefono1) {
        this.telefono1 = telefono1;
    }

    public long getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(long telefono2) {
        this.telefono2 = telefono2;
    }

    //Sobrescritura metodo toString
    @Override
    public String toString() {
        return "Nombre: " + nombre + ".\nTelefono1: " + telefono1 + ".\nTelefono2: " + telefono2 + ".\nCorreo: " + correo + ".\nTipo de Contacto: " + tpContacto + ".";
    }
}
