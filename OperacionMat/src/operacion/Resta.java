
package operacion;


public class Resta extends Operacion {

    protected double  resta;
    
    public Resta(double numero1, double numero2, String nombre) {
        super(numero1, numero2, "Resta");
    }

    @Override
    public double mostrarResultado() {
    return super.getNumero1()-super.getNumero2();
    }
    
    public String toString(){
        return super.getNumero1()+" - "+super.getNumero2()+" = "+ mostrarResultado();
    }
    
     @Override
    public boolean equals(Object obj) {
        if (obj instanceof Resta) {
            Resta tmpOp = (Resta) obj;
            if (super.equals(tmpOp)&& resta==tmpOp.resta) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
    
    @Override
    protected Resta clone()  {
    
   Resta op= new Resta(getNumero1(), getNumero2(), getNombre()){
       @Override
       public double mostrarResultado() {
         return 0;
       }
   };
           return op;
    }
    
}
