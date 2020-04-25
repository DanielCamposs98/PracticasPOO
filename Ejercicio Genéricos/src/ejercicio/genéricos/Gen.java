
package ejercicio.genéricos;

public class Gen<T> {

    //Se declara un parámetro tipo T.     
    T ob; 
 
     //El constructor pasa una referencia a un objeto tipo  T.
    public Gen(T o){
        ob=o;
    }
    
    public T getOb(){
        return ob;
    }
    
    //Muestra el tipo T
    public void showType(){
        System.out.println("El tipo de T es: " +  ob.getClass().getName());
                
    }
    
}
