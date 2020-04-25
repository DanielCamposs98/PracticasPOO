
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopiaArchivo {

    public static void LeerArchivo() throws IOException {
        File archivoEntrada = new File("entrada.txt");
        File archivoSalida = new File("salida.txt");
        try {
            FileReader in = new FileReader(archivoEntrada);
            FileWriter out = new FileWriter(archivoSalida);
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            in.close();
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado.");
        } catch (IOException e) {
            System.out.println("Hubo un error de entrada y/o salida del archivo");
        }catch(NullPointerException e){
            System.out.println("El argumento del archivo es nulo");
    /*  }catch(IllegalArgumentException e){
      System.out.println("Las condiciones previas en el parametro no se mantienen");
      }catch(SecurityException e){
            System.out.println("El metodo rechaza el acceso de redaccion del archivo.");
  */
}
    }
}
