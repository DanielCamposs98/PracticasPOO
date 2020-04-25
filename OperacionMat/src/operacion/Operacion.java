package operacion;

public abstract class Operacion implements Cloneable {

    protected abstract double mostrarResultado();

    private double numero1, numero2;
    private String nombre;

    public double getNumero1() {
        return numero1;
    }

    public Operacion(double numero1, double numero2, String nombre) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

    public String toString() {
        return "Nombre: " + nombre + ". Numero 1: " + numero1 + ". Numero 2: " + numero2 + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Operacion) {
            Operacion tmpOp = (Operacion) obj;
            if (this.nombre.equals(tmpOp.nombre) && this.numero1 == tmpOp.numero1 && this.numero2 == tmpOp.numero2) {
                return true;
            } else {
                return false;

            }
        } else {
            return false;
        }

    }

    @Override
    protected Operacion clone()  {
    
   Operacion op= new Operacion(numero1, numero2, nombre) {
       @Override
       protected double mostrarResultado() {
        
           return this.mostrarResultado();
       }
   };
           return op;
    }
    
    
}
