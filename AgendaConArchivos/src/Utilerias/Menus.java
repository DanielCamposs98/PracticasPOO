
package Utilerias;

import Administradores.UsaAgenda;
import Administradores.UsaContacto;
import java.io.IOException;




public class Menus {
    UsaContacto uc= new  UsaContacto();
    UsaAgenda ua= new UsaAgenda();
     public void mostrarMenuPrincipal() throws IOException {
      char iMenu;
        do{
           iMenu=1;
           do{
               System.out.println("----------Agenda-----------\n1-Menú Contactos.\n2-Menú Agenda.\n3-Salir.");
       iMenu=Keyboard.readChar();
           }while(Validaciones.validarMenuPrincipal(iMenu)==false);
           switch(iMenu){
               case '1':
                   desplegarMenuContactos();
                   break;
               case '2':
                   desplegarMenuAgenda();
                   break;
           }
       }while(iMenu!='3');
}
    
    public void desplegarMenuImprimir(){
        char i;
           do {
                                System.out.println("--------------------------\n 1-Imprimir por tipo de contacto.\n2- Imprimir todos.\n3-Salir");
                               i = Keyboard.readChar();
                                
                            } while (Validaciones.validarMenuImprimir(i) == false);
                            
                            switch (i) {
                                case '1':
                                    ua.imprimirContactosTC();
                                    break;
                                case '2':
                                   ua. imprimirContactosTodos();
                                    break;
                            }
    }

    private void desplegarMenuAgenda() throws IOException {
        char i;
         do {
                        System.out.println("-----------Menú Agenda---------\n1- Imprimir Contactos.\n2- Buscar contacto.\n3- Guardar en archivo.\n4.Guardar archivo en bytes.\n5-Salir ");
                        i = Keyboard.readChar();
                    } while (Validaciones.validarMenuAgenda(i) == false);
         switch(i){
             case '1':
                 desplegarMenuImprimir();
                 break;
             case '2': 
                 uc.buscarContactos(ua.agenda);
                 break;
                 case'3':
                     ua.guardarArchivo();
                     ua.leerArchivo();
                     break;
                 case '4':
                     ua.guardarBytes();
                     break;
         }
        
    }
    public void desplegarMenuContactos() {
 
        char i;
        do {
            System.out.println("----------Menu Contactos----------\n1- Agregar contacto.\n2- Eliminar contacto.\n3- Modificar contacto.\n4- Salir.");
            i = Keyboard.readChar();
        } while (Validaciones.validarMenuContactos(i) == false);

        switch (i) {
            case '1':
                uc.agregarContacto(ua.agenda);
                break;
            case '2':
                uc.eliminarContacto(ua.agenda);
                break;
            case '3':
                uc.modificarContactos(ua.agenda);
                break;

        }
    }
}
