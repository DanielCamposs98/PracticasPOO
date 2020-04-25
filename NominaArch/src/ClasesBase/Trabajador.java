package ClasesBase;

import ClasesBase.Persona;

public abstract class Trabajador extends Persona {

    public Trabajador(String nombre, String apellido, char s) {
        super(nombre, apellido, s);

    }

    public abstract double sueldo();

    public String toString() {
        return super.toString();
    }

}
