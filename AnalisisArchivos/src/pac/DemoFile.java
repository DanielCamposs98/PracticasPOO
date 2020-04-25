package pac;

import java.io.File;
import java.util.Scanner;

public class DemoFile {

    public static void main(String[] a) {
        Scanner E = new Scanner(System.in);
        System.out.println("Escriba aqui el nombre del archivo o directorio");
        analizarRuta(Keyboard.readString());
    }

    private static void analizarRuta(String ruta) {
        File nombre = new File(ruta);
        if (nombre.exists()) {
            System.out.println("---------------------------------");
            System.out.println("Existe " + nombre.getName());
            System.out.println("Es un archivo? " + nombre.isFile());
            System.out.println("Es un directorio? " + nombre.isDirectory());
            System.out.println("Es la ruta absoluta? " + nombre.isAbsolute());
            System.out.println("Ultima modificación fue: " + nombre.lastModified());
            System.out.println("Tamaño: " + nombre.length() + ". Ruta: " + nombre.getPath());
            System.out.println("Ruta absoluta: " + nombre.getAbsolutePath());
            System.out.println("Padre: " + nombre.getParent());
            if (nombre.isDirectory()) {
                String[] directorio = nombre.list();
                System.out.println("\n\nContenido del directorio\n\n");

                for (String nombreD : directorio) {
                    System.out.printf("%s\n", nombreD);
                }
            }
        } else {
            System.out.printf("\n%s", ruta, " no existe.");
        }

    }
}
