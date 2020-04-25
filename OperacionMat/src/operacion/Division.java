
package operacion;


public class Division extends Operacion {

    protected double division;
    public Division(double numero1, double numero2, String nombre) {
        super(numero1, numero2, "division");
    }

    @Override
    protected double mostrarResultado() {
        if(getNumero2()==0 || getNumero1()==0){
            return 0;
        }else{
            return getNumero1()/getNumero2();
        }
    }
    
      public String toString(){
        return super.getNumero1()+" - "+super.getNumero2()+" = "+ mostrarResultado();
    }
    
     @Override
    public boolean equals(Object obj) {
        if (obj instanceof Resta) {
            Resta tmpOp = (Resta) obj;
            if (super.equals(tmpOp)&& division==tmpOp.resta) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
    
    @Override
    protected Division clone()  {
    
   Division op= new Division(getNumero1(), getNumero2(), getNombre()){
       @Override
       public double mostrarResultado() {
           return 0;
       }
   };
           return op;
    }
    
    
    
}
