
public class Rombo extends Figura {

    private double dMr, dMn, lado;

    Rombo(String n, double dM, double dm, double l) {
        super(n);
        this.dMn = dm;
        this.dMr = dM;
        this.lado = l;
    }

    @Override
    public double area() {
        return (dMr * dMn) / 2;
    }

    @Override
    public double perimetro() {
        return lado * 4;
    }

    public String toString() {
        return super.toString() + ". Area: " + area() + ". Perimetro: " + perimetro();
    }
}
