package operacion;

public class Suma extends Operacion {

    protected double suma ;

    public Suma(double numero1, double numero2, String nombre) {
        super(numero1, numero2, "Suma");
    }

    protected double mostrarResultado() {
        if (getNumero2() < 0) {
            return super.getNumero1() - super.getNumero2();
        } else {
            return getNumero1() + getNumero2();
        }
    }

    public String toString() {

        if(getNumero2()<0){
            return getNumero1()+" +("+getNumero2()+") = "+mostrarResultado();
        }else{
             return getNumero1()+" +"+getNumero2()+" = "+mostrarResultado();
        }
    }
    
     @Override
    public boolean equals(Object obj) {
        if (obj instanceof Suma) {
            Suma tmpOp = (Suma) obj;
            if (super.equals(tmpOp)&&suma==tmpOp.suma) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
    
        @Override
    protected Suma clone()  {
    
   Suma op= new Suma(getNumero1(), getNumero2(), getNombre()){
       @Override
       public double mostrarResultado() {
           return 0;
       }
   };
           return op;
    }

}
