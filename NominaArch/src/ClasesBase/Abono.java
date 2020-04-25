package ClasesBase;


public class Abono {

    protected String concepto;
    public double cantidad;
    public char tipo;
    public int idTrabajador;


    public Abono(String concepto, double cantidad, char tipo, int idTrabajador) {
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.idTrabajador = idTrabajador;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        return "Abono\nTipo: " + tipo + ".\n Trabajador: "  + ".\nConcepto: " + concepto + ".\nCantidad: " + cantidad + ".\n";

    }
}
