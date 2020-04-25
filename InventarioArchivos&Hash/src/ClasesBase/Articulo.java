package ClasesBase;



public class Articulo {

    //Atributos:
    String desc, entrada;
    int cant, contador = 0;
    float prec;

    //Constructor
  public  Articulo(String desc, int cant, float prec) {
        this.desc = desc;
        this.cant = cant;
        this.prec = prec;
    }
    //Getters y Setters

  

    public String getDesc() {
        return desc;
    }

    public float getPrecio() {
        return prec;
    }

    public int getCant() {
        return cant;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPrec(float prec) {
        this.prec = prec;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    //Representacion String de Articulo
    public String toString() {
        return " Descripcion: " + desc + " Precio: " + prec + " Cantidad: " + cant;
    }
}
