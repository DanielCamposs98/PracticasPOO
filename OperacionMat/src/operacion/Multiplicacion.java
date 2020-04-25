package operacion;


public class Multiplicacion extends Operacion{

    protected double multiplicacion;
    
    public Multiplicacion(double numero1, double numero2, String nombre) {
        super(numero1, numero2, "multiplicacion");
    }

    @Override
    protected double mostrarResultado() {
      return getNumero1()*getNumero2();
    }

   public String toString(){
       return getNumero1()+" x "+getNumero2()+" = "+mostrarResultado();
   }
   
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Multiplicacion) {
            Multiplicacion tmpOp = (Multiplicacion) obj;
            if (super.equals(tmpOp)&&multiplicacion==tmpOp.multiplicacion) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    
       @Override
    protected Multiplicacion clone()  {
    
   Multiplicacion op= new Multiplicacion(getNumero1(), getNumero2(),getNombre()){
       @Override
       public double mostrarResultado() {
           return 0;
       }
   };
           return op;
    }
    
    
}
