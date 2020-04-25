package Utilerias;

import java.io.IOException;

public class UsaInventario {

    Inventario inv = new Inventario();

    public void mostrarMenuPrincipal() {
        char iMenu;
        do {
            iMenu = 1;
            do {
                System.out.println("----------------- MENU -----------------");
                System.out.println("1.- Imprimir todo.");
                System.out.println("2.- Imprimir por nombre.");
                System.out.println("3.- Salir");

                iMenu = Keyboard.readChar();
            } while (Validaciones.validarMenuPrincipal(iMenu) == false);
            switch (iMenu) {
                case '1':
                    inv.imprimirTodo();
                    break;
                case '2':
                    inv.buscarPorNombre();
                    break;
                case '3':
                    System.out.println("Cerrando...");
            }
        } while (iMenu != '3');
    }

    public void inicializarPrograma() throws IOException,NullPointerException  {
        
        try {
            inv.LeerArticulo();

            mostrarMenuPrincipal();
        } catch (IOException e) {
            System.out.println("Error de entrada y/o salida.");
            
        }catch(NullPointerException e){
            System.out.println("Error al abrir archivo.");
            return;
        }
    }
}
