package Administradores;

import ClasesBase.Contacto;
import Utilerias.Keyboard;
import Utilerias.Validaciones;
import java.util.Enumeration;
import java.util.Hashtable;

public class UsaContacto {

    UsaAgenda ua = new UsaAgenda();

    //Metodo para agregar contactos
    public void agregarContacto(Hashtable<String, Contacto> agenda) {
        String alias, nombre, correo;
        char tpContacto;
        long T1, T2;
        //Pide el alias y lo convierte en mayúscula

        System.out.println("Alias");
        alias = Keyboard.readString().toUpperCase();
        //Si el alias existe, retorna
        if (agenda.containsKey(alias)) {
            System.out.println("Alias ya existe...");
            return;
        }
        //Pide el nombre
        System.out.println("Nombre del contacto    ");
        nombre = Keyboard.readString().toUpperCase();

        //Pide el teléfono 1
        String aux;
        do {
            System.out.println("Telefono 1 ");
            T1 = Keyboard.readLong();
            aux = String.valueOf(T1);

        } while (Validaciones.validarTelefono(aux) == false);

        System.out.println("Teléfono 1: " + T1);

        //Pregunta al usuario si desea agregar un telefono 2
        System.out.println("Deseas agregar un telefono 2  (S para SI / Cualquier otro carácter para NO");
        String Conf = Keyboard.readString().toUpperCase();
        if (Validaciones.validaSiNo(Conf)) {
            do {
                System.out.println("Telefono 2: ");
                T2 = Keyboard.readLong();
                aux = String.valueOf(T2);
            } while (Validaciones.validarTelefono(aux) == false);
        } else {
            T2 = 0;
        }

        //Pide al usuario el tipo de contacto.
        do {
            System.out.println("Ingresa el tipo de contacto (1- Familia. 2-Trabajo. 3- Amigos. 4- Escuela");
            tpContacto = Keyboard.readChar();
        } while (Validaciones.validarTipoContacto(tpContacto) == false);

        System.out.println("Ingresa el correo");
        correo = Keyboard.readString().toUpperCase();
        Contacto con = new Contacto(nombre, T1, T2, correo, tpContacto);

        agenda.put(alias, con);

        System.out.println(con.toString());
    }

    //Método para eliminar contactos
    public void eliminarContacto(Hashtable<String, Contacto> agenda) {
        if (agenda.isEmpty()) {
            System.out.println("La agenda está vacía");
        } else {
            System.out.println("Ingresa el alias del contacto a eliminar");
            String a = Keyboard.readString().toUpperCase();
            if (agenda.containsKey(a)) {
                agenda.remove(a);
                System.out.println("Alias: " + a + ". ELIMINADO");
            } else {
                System.out.println("Alias no existente. Ingresa otro.");
                return;
            }
        }
    }

    //Método para modificar contactos
    public void modificarContactos(Hashtable<String, Contacto> agenda) {
        if (agenda.isEmpty()) {
            System.out.println("La agenda está vacía");
        } else {
            char op;
            do {
                System.out.println("----------Menú Modificar----------\n1-Modificar Nombre.\n2- Modificar Correo.\n3- Modificar Telefonos.\n4- Salir.");
                op = Keyboard.readChar();
            } while (Validaciones.validaMenuModificar(op) == false);
            String alias;
            switch (op) {
                case '1':
                    modificarContactoNombre(ua.agenda);
                    break;
                case '2':
                    modificarContactoCorreo(ua.agenda);
                    break;
                case '3':
                    modificarContactoTelefonos(ua.agenda);
                    break;
            }
        }
    }

    //Métodos para buscar contactos
    public void buscarContactos(Hashtable<String, Contacto> agenda) {
        if (agenda.isEmpty()) {
            System.out.println("La agenda está vacia");
        } else {
            char op2;
            do {
                System.out.println("----------Menú Buscar Contactos----------\n1- Buscar por alias.\n2- Buscar por nombre\n3- Salir.");
                op2 = Keyboard.readChar();
            } while (Validaciones.validaMenuBuscar(op2) == false);
            switch (op2) {
                case '1':
                    System.out.println("Ingresa alias");
                    String alias = Keyboard.readString().toUpperCase();
                    buscarContactoAlias(alias, ua.agenda);
                    break;
                case '2':
                    System.out.println("Ingresa nombre");
                    String nombre = Keyboard.readString().toUpperCase();
                    buscarContactoNombre(nombre, ua.agenda);
                    break;
            }
        }
    }

    public void buscarContactoAlias(String alias, Hashtable<String, Contacto> agenda) {

        if (agenda.containsKey(alias)) {
            System.out.println(agenda.get(alias).toString());
        } else {
            System.out.println("No existe.");
        }
    }

    public void buscarContactoNombre(String nombre, Hashtable<String, Contacto> agenda) {
        Enumeration<String> eAlias = agenda.keys();

        while (eAlias.hasMoreElements()) {
            String llave = eAlias.nextElement().toUpperCase();
            if (agenda.get(llave).getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Alias: " + llave + "\n" + agenda.get(llave));
            }
        }

    }

//Métodos para modificar contactos
    public void modificarContactoNombre(Hashtable<String, Contacto> agenda) {
        String alias = Validaciones.pedirAlias().toUpperCase();
        if (agenda.containsKey(alias)) {
            System.out.println("Alias: " + alias + "\nNombre anterior:" + agenda.get(alias).getNombre());
            System.out.println("Ingresa el nombre nuevo");
            String nn = Keyboard.readString().toUpperCase();
            agenda.get(alias).setNombre(nn);
            System.out.println("Alias: " + alias + "\n" + agenda.get(alias));

        } else {
            System.out.println("No existe ese alias en la agenda.");
            return;
        }
    }

    public void modificarContactoCorreo(Hashtable<String, Contacto> agenda) {
        String alias = Validaciones.pedirAlias().toUpperCase();

        if (agenda.containsKey(alias)) {
            System.out.println("Alias: " + alias + "\nCorreo anterior:" + agenda.get(alias).getCorreo());
            System.out.println("Ingresa el Correo nuevo");
            String cc = Keyboard.readString().toUpperCase();
            agenda.get(alias).setCorreo(cc);
            System.out.println("Alias: " + alias + "\n" + agenda.get(alias));

        } else {
            System.out.println("No existe ese alias en la agenda.");
            return;
        }
    }

    public void modificarContactoTelefonos(Hashtable<String, Contacto> agenda) {
        String alias = Validaciones.pedirAlias().toUpperCase();

        if (agenda.containsKey(alias)) {
            System.out.println("Alias: " + alias + "\nTelefono 1:" + agenda.get(alias).getTelefono1() + ". Telefono 2: " + agenda.get(alias).getTelefono2());
            String aux;
            long t1;
            do {
                System.out.println("Ingresa el nuevo telefono 1 ");
                t1 = Keyboard.readLong();
                aux = String.valueOf(t1);

            } while (Validaciones.validarTelefono(aux) == false);

            System.out.println("Teléfono 1: " + t1);

            System.out.println("Deseas cambiar el telefono 2  S=Si / N=no");
            String Conf = Keyboard.readString().toUpperCase();
            long T2 = agenda.get(alias).getTelefono2();
            if (Validaciones.validaSiNo(Conf)) {
                do {
                    System.out.println("Telefono 2: ");
                    T2 = Keyboard.readLong();
                    aux = String.valueOf(T2);
                } while (Validaciones.validarTelefono(aux) == false);
                System.out.println("Telefono 2: " + T2);
            }

            agenda.get(alias).setTelefono1(t1);
            agenda.get(alias).setTelefono2(T2);

            System.out.println("Alias: " + alias + "\n" + agenda.get(alias));
        }

    }
}
