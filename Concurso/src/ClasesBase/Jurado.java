package ClasesBase;


public class Jurado {
    
    private int clave;
    private String nombre;
    
   public  Jurado(int c,String n){
        this.clave=c;
        this.nombre=n;
    }
    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }
    
    public String toString(){
        return "Nombre: "+nombre+".\nClave: "+clave;
    }
    
}
