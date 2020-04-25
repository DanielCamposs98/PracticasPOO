
public class Circulo extends Figura {

    private double radio;

    Circulo(String n, double r) {
        super(n);
        this.radio = r;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radio,2);
    }

    public void setRadio(double r) {
        this.radio = r;
    }

    public double getRadio() {
        return radio;
    }

    public String toString() {
        return super.toString() + ". Área:  " + area() + ". Perimetro: " + perimetro();
    }

    @Override
    public double perimetro() {
        return Math.PI * (radio*2);
    }

}
