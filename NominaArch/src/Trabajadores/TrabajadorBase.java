package Trabajadores;

import ClasesBase.Trabajador;

public class TrabajadorBase extends Trabajador {

    private double base;

    public TrabajadorBase(String nombre, String apellido, char sexo, double b) {
        super(nombre, apellido, sexo);
        this.base = b;
    }


    @Override
    public double sueldo() {
        return base;
    }

    public double getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return super.toString()+"Tipo: BASE. \nSueldo: " + sueldo() + ".\n";
    }
    public String toStringCons(){
        return"Base-"+ super.toStringCons()+"-"+base;
    }

}
