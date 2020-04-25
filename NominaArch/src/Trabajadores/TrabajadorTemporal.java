package Trabajadores;

import ClasesBase.Trabajador;


public class TrabajadorTemporal extends Trabajador {

    protected int horasSemanales;
    protected final int horasLimite = 240, pagoHora = 15, pagoHoraEx = 20;

    public TrabajadorTemporal(String nombre, String apellido, char s, int hs) {
        super(nombre, apellido, s);
        this.horasSemanales = hs;
    }


    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    @Override
    public double sueldo() {
        double sueldo = 0;
        int aux;
        if (horasSemanales > horasLimite) {
            aux = horasSemanales - horasLimite;
            sueldo += pagoHora * horasLimite;
            sueldo += aux * pagoHoraEx;
        } else {
            sueldo += horasSemanales * pagoHora;
        }
        return sueldo;
    }

    public String toString() {
        return super.toString() +"Tipo: TEMPORAL. "+ "Horas trabajadas: " + horasSemanales + ".\nSueldo: " + sueldo() + ".\n";
    }
    
    public String toStringCons(){
        return"Temporal-"+ super.toStringCons()+"-"+horasSemanales;
    }
}
