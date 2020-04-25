
public class Rectangulo extends Figura {

    public double largo, ancho;

    Rectangulo(String n, double a, double l) {
        super(n);
        this.ancho = a;
        this.largo = l;
    }

    public void setLargo(double l) {
        this.largo = l;
    }

    public void setAncho(double a) {
        this.ancho = a;
    }

    public double getLargo() {
        return largo;
    }

    public double getAncho() {
        return ancho;
    }

    @Override
    public double area() {
        return largo * ancho;
    }

    @Override
    public double perimetro() {
       return (largo*2)+(ancho*2);
    }

    public String toString() {
        return super.toString() + ". Area: " + area() + ". Perimetro: " + perimetro();
    }
}
