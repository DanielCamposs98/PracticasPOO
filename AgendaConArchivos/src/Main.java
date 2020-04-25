
import Utilerias.Menus;
import java.io.IOException;


public class Main {
    
    public static void main(String []a) throws IOException{
        Menus m= new Menus();
        try{
        m.mostrarMenuPrincipal();
        }catch(IOException e){
            System.out.println("Error de Entrada/Salida");
        }
    }
}
