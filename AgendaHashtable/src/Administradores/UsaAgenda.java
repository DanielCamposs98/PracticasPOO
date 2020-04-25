
package Administradores;

import ClasesBase.Contacto;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import Utilerias.Keyboard;
import Utilerias.Validaciones;
public class UsaAgenda {
 
    UsaContacto uc= new UsaContacto();
    
     public static Hashtable<String, Contacto> agenda = new Hashtable<String, Contacto>();
     
     //Metodos de impresión
      public void imprimirContactosTodos() {
        if (agenda.isEmpty()) {
            System.out.println("La agenda esta vacia....");
        } else {
            Set<String> keys = agenda.keySet();
            Iterator<String> iterator = keys.iterator();
            while (iterator.hasNext()) {
                String llave = iterator.next().toUpperCase();
                System.out.println("Alias: " + llave + "\n" + agenda.get(llave));
            }
        }
    }
      
      public void imprimirContactosTC() {
        if (agenda.isEmpty()) {
            System.out.println("La agenda está vacia.");
        } else {
            char tpContacto;
            do {
                System.out.println("Ingresa el tipo de contacto (1- Familia. 2-Trabajo. 3- Amigos. 4- Escuela");
                tpContacto = Keyboard.readChar();
            } while (Utilerias.Validaciones.validarTipoContacto(tpContacto) == false);

            Set<String> keys = agenda.keySet();
            Iterator<String> iterator = keys.iterator();
            while (iterator.hasNext()) {
                String llave = iterator.next().toUpperCase();
                switch (tpContacto) {
                    case '1':

                        if (agenda.get(llave).getTpContacto() == '1') {
                            System.out.println("Tipo de Contacto FAMILIA");
                            System.out.println("Alias: " + llave + ".\n" + agenda.get(llave));
                        }
                        break;
                    case '2':

                        if (agenda.get(llave).getTpContacto() == '2') {
                            System.out.println("Tipo de Contacto TRABAJO");
                            System.out.println("Alias: " + llave + ".\n" + agenda.get(llave));
                        }
                        break;
                    case '3':

                        if (agenda.get(llave).getTpContacto() == '3') {
                            System.out.println("Tipo de Contacto AMIGOS");
                            System.out.println("Alias: " + llave + ".\n" + agenda.get(llave));
                        }
                        break;
                    case '4':

                        if (agenda.get(llave).getTpContacto() == '4') {
                            System.out.println("Tipo de Contacto ESCUELA");
                            System.out.println("Alias: " + llave + ".\n" + agenda.get(llave));
                        }
                        break;
                }
            }
        }
    }

    public void mostrarMenuPrincipal() {
      char iMenu;
        do{
           iMenu=1;
           do{
               System.out.println("----------Agenda-----------\n1-Menú Contactos.\n2-Menú Agenda.\n3-Salir.");
       iMenu=Keyboard.readChar();
           }while(Validaciones.validarMenuPrincipal(iMenu)==false);
           switch(iMenu){
               case '1':
                   uc.desplegarMenuContactos();
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
                                    imprimirContactosTC();
                                    break;
                                case '2':
                                    imprimirContactosTodos();
                                    break;
                            }
    }

    private void desplegarMenuAgenda() {
        char i;
         do {
                        System.out.println("-----------Menú Agenda---------\n1- Imprimir Contactos.\n2- Buscar contacto.\n3-Salir ");
                        i = Keyboard.readChar();
                    } while (Validaciones.validarMenuAgenda(i) == false);
         switch(i){
             case '1':
                 desplegarMenuImprimir();
                 break;
             case '2': 
                 uc.buscarContactos();
                 break;
                        
         }
        
    }
    }

