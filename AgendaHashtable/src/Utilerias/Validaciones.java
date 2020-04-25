
package Utilerias;

import java.util.Enumeration;
import Administradores.UsaAgenda;
import Administradores.UsaContacto;

public class Validaciones {
     public static boolean isNumDecimal(String c) {
        if (c.length() < 1) {
            return false;
        }
        if (c.charAt(0) == '-') {
            return false;
        }
        for (int i = 0; i < c.length(); i++) {
            if (Character.isDigit(c.charAt(i)) || c.charAt(i) == '.') {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumEntero(String c) {
        if (c.length() < 1) {
            System.out.println("Ingresa numeros mayores de 0");
            return false;
        }
        if (c.charAt(0) == '-') {
            System.out.println("Utiliza numeros positivos");
            return false;
        }
        for (int i = 0; i < c.length(); i++) {
            if (Character.isDigit(c.charAt(i))) {
                return true;
            }
        }
        System.out.println("Ingresa datos numéricos");
        return false;
    }

    public static boolean validarTelefono(String t) {

        if (isNumEntero(t) == true) {
            if (t.length() < 10 || t.length() > 10) {
                System.out.println("Longitud de 10 cifras. Intentalo de nuevo");
                return false;
            } else {
                Long telefono = Long.parseLong(t);
                if (telefono < 0) {
                    System.out.println("No puedes ingresar negativos");
                    return false;
                } else {
                    return true;

                }
            }
        }
        return false;
    }
    
     public static boolean validarTipoContacto(char a) {
        switch (a) {
            case '1':
                return true;
            case '2':
                return true;
            case '3':
                return true;
            case '4':
                return true;
            default:
                System.out.println("Argumento invalido. Ingresa uno existente.");
                return false;
        }

    }
     
   
    public static boolean validaSiNo(String n) {
        n = n.toUpperCase();
        if (n.length() > 1) {
            System.out.println("Ingresa sólo un carácter ( S para SI o cualquier otro para No)");
            return false;
        } else {
            if (n.equalsIgnoreCase("S")) {
                return true;
            }
        }
        return false;
    }

  

    public static boolean validaMenuBuscar(char a) {
        switch (a) {
            case '1':
                System.out.println("Has seleccionado BUSCAR POR ALIAS");
                return true;
            case '2':
                System.out.println("Has seleccionado BUSCAR POR NOMBRE");
                return true;
            case '3':
                return true;
            default:
                System.out.println("Opción invalida. Ingresa una correcta.");
                return false;
        }
    }

    public static boolean validaMenuModificar(char a) {
        switch (a) {
            case '1':
                System.out.println("Has seleccionado MODIFICAR NOMBRE");
                return true;
            case '2':
                System.out.println("Has seleccionado MODIFICAR CORREO");
                return true;
            case 3:
                System.out.println("Has selecccionado MODIFICAR TELEFONOS");
                return true;
            case 4:
                System.out.println("Has seleccionado MODIFICAR ELEMENTOS VARIOS");
                return true;
            case 5:
                return true;
            default:
                System.out.println("Opción invalida. Ingresa una correcta.");
                return false;
        }
    }

    public static boolean verificarExistenciaNombre(String n) {
        n = n.toUpperCase();
        Enumeration<String> enumK = UsaAgenda.agenda.keys();

        while (enumK.hasMoreElements()) {
            String llave = enumK.nextElement().toUpperCase();
            if (UsaAgenda.agenda.containsKey(llave)) {
                if (UsaAgenda.agenda.get(llave).getNombre().equalsIgnoreCase(n)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validarMenuPrincipal(char op) {
        switch (op) {
            case '1':
                return true;
            case '2':
                return true;
            case '3':
                System.out.println("Adios.");
                return true;
            default:
                System.out.println("Opcion inexistente. Ingresa otra.");
                return false;
        }
    }

    public static boolean validarMenuContactos(char op) {
        switch (op) {
            case '1':
                return true;
            case '2':
                return true;
            case '3':
                return true;
            case '4':
                return true;
            default:
                System.out.println("Opcion inexistente. Ingresa otra.");
                return false;
        }
    }

    public static boolean validarMenuAgenda(char op) {
        switch (op) {
            case '1':
                return true;
            case '2':
                return true;
            case '3':
              return true;
            default:
                System.out.println("Opcion inexistente. Ingresa otra.");
                return false;
        }
    }

    public static boolean validarMenuImprimir(char op) {
switch (op) {
            case '1':
                return true;
            case '2':
                return true;
            case '3':
                return true;
            default:
                System.out.println("Opcion inexistente. Ingresa otra.");
                return false;
        }        
    }
    
    public static String pedirAlias(){
        System.out.println("Ingresa alias");
        String dato= Keyboard.readString().toUpperCase();
        return dato;
    }
    
    public static String pedirNombre(){
        System.out.println("Ingresa el nombre");
        String dato=Keyboard.readString().toUpperCase();
        return dato;
    }

   

}
