
import java.io.IOException;


public class UsaCopiaArchivo {
    
    public static void main(String[]a) throws IOException{
        try{
        CopiaArchivo.LeerArchivo();
        
    }catch(IOException e){
            System.out.println("Error de entrada y/o salida en el archivo.");
    }
    }
}
