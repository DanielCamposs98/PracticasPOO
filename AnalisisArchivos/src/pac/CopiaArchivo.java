
package pac;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CopiaArchivo {
    
    public static void main(String []a) throws IOException {
        //Define los archivos que recibirá el programa para su lectura.
        File archivoEntrada= new File("entrada.txt");
        File archivoSalida= new File("salida.txt");
        
        //Define los flujos los cuales conectarán el archivo con el programa que los recibe.
        FileReader in = new FileReader (archivoEntrada);
        FileWriter out = new FileWriter(archivoSalida);
         int c;
         //Lee las lineas del archivo buscando datos
         //Escribe en archivoSalida los datos de archivoEntrada mientras no sea el final del archivo.
        while((c=in.read())!= -1){
            out.write(c);
             
         }
        //Cierra el flujo de los lectores para no generar incongruencias en el programa.
        in.close();
        out.close();
    }
}
