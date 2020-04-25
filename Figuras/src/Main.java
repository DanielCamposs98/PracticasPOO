
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner E = new Scanner(System.in);
        UsaFigura uf = new UsaFigura();
        int iMenu;
        String aux;
        do {
            do {
                System.out.println("-----------------------MENU FIGURAS------------------------\n1- Agregar Figuras.\n2- Mostrar Figuras.\n3- Mostrar Areas\n4.- Salir");
                aux = E.next();
            } while (UsaFigura.isNum(aux) == false);
            iMenu = Integer.parseInt(aux);
            switch (iMenu) {
                case 1:
                    uf.altaFigura();
                    break;
                case 2:
                    uf.imprimeFiguras();
                    break;
                case 3:
                    uf.obtenerDatos();
                    break;
                case 4:
                    System.out.println("Cerrando Programa");
                    break;
            }

        } while (iMenu != 4);
    }

}
