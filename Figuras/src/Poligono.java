
public class Poligono extends Figura {

    private double  apotema, lado;
    private int nLados;

    public Poligono(String nombre, double a,int n,double l) {
        super(nombre);
        this.apotema=a;
        this.nLados=n;
        this.lado=l;
    }
    
    public void setApotema(double a){
        this.apotema=a;
    }
   public void setNLados(int nLados){
       this.nLados=nLados;
   }
   
   public void setLado(double l){
       this.lado=l;
   }
   
   public int getNLados() {
       return nLados;
   }
   
   public double getApotema(){
       return apotema;
   }
   public double getLado(){
       return lado;
   }
    @Override
    public double area() {
      return (perimetro()*apotema)/2;
    }

    @Override
    public double perimetro() {
       return nLados*lado;
    }
    
    public String toString() {
        return super.toString() + ". Area: " + area() + ". Perimetro: " + perimetro();
    }
}
