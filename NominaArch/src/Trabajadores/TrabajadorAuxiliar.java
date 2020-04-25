package Trabajadores;

import ClasesBase.Trabajador;


public class TrabajadorAuxiliar extends Trabajador {

    protected final int cajaCiruela = 10, cajaNaranja = 15, cajaLimon = 20, cajaGuanabana = 30;
    protected int cjCir, cjNar, cjLim, cjGuan;

    public TrabajadorAuxiliar(String nombre, String apellido, char s, int cjC, int cjN, int cjG, int cjL) {
        super(nombre, apellido, s);
        this.cjCir = cjC;
        this.cjNar = cjN;
        this.cjGuan = cjG;
        this.cjLim = cjL;
    }

    public int getCjCir() {
        return cjCir;
    }

    public void setCjCir(int cjCir) {
        this.cjCir = cjCir;
    }

    public int getCjNar() {
        return cjNar;
    }

    public void setCjNar(int cjNar) {
        this.cjNar = cjNar;
    }

    public int getCjLim() {
        return cjLim;
    }

    public void setCjLim(int cjLim) {
        this.cjLim = cjLim;
    }

    public int getCjGuan() {
        return cjGuan;
    }

    public void setCjGuan(int cjGuan) {
        this.cjGuan = cjGuan;
    }

    @Override
    public double sueldo() {
        double sueldo = 0;
        sueldo += cjCir * cajaCiruela;
        sueldo += cjNar * cajaNaranja;
        sueldo += cjLim * cajaLimon;
        sueldo += cjGuan * cajaGuanabana;
        return sueldo;
    }

    public String toString() {
        return super.toString() + "Tipo: AUXILIAR.\nCajas Ciruela:  " + cjCir + ".\nCajas Naranja: " + cjNar + ".\nCaja Guanabana: " + cjGuan + ".\nCaja Limon: " + cjLim + ".\nSueldo: " + sueldo() + ".\n";
    }
    
    public String toStringCons(){
        return "Auxiliar-"+super.toStringCons()+"-"+cjCir+"-"+cjNar+"-"+cjGuan+"-"+cjLim;
    }
}
