
public class Cuadrado extends Figura {

    private double lado;

    Cuadrado(String n, double l) {
        super(n);
        this.lado = l;
    }

    @Override
    public double area() {
        return Math.pow(lado,2);
    }

    public void setLado(double l) {
        this.lado = l;
    }

    public double getLado() {
        return lado;
    }

    public String toString() {
        return super.toString() + ". Area: " + area() +". Perimetro: "+perimetro();
    }

    @Override
    public double perimetro() {
        return lado*4;
    }
}
