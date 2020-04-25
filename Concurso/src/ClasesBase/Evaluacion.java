package ClasesBase;

public class Evaluacion implements Utilerias.PuntosMaximos{

    private int claveJurado;

    protected int turno,calificacion;
    private String observaciones;
    
    public Evaluacion(int cJ ,int t ,int c ,String o){
        this.calificacion=c;
        this.claveJurado=cJ;
        this.observaciones=o;
        this.turno=t;
    }

    public int getClaveJurado() {
        return claveJurado;
    }

    public void setClaveJurado(int claveJurado) {
        this.claveJurado = claveJurado;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
public String toString(){
    return " Jurado: "+claveJurado+".\n Turno del participante: "+turno+".\n Calificación: "+calificacion+"\n Observaciones: "+ observaciones+".";
}

    
    
}
