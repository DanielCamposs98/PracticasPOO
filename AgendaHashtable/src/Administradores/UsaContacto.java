/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administradores;

import ClasesBase.Contacto;
import Utilerias.Validaciones;
import Utilerias.Keyboard;
import java.util.Enumeration;

/**
 *
 * @author Daniel Campos
 */
public class UsaContacto {

    //Metodo para agregar contactos
    public void agregarContacto() {
        String alias, nombre, correo;
        char tpContacto;
        long T1, T2;
        //Pide el alias y lo convierte en mayúscula

        System.out.println("Alias");
        alias = Keyboard.readString().toUpperCase();
        //Si el alias existe, retorna
        if (UsaAgenda.agenda.containsKey(alias)) {
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
        UsaAgenda.agenda.put(alias, con);
        
        System.out.println(con.toString());
    }

    //Método para eliminar contactos
    public void eliminarContacto() {
        if (UsaAgenda.agenda.isEmpty()) {
            System.out.println("La agenda está vacía");
        } else {
            System.out.println("Ingresa el alias del contacto a eliminar");
            String a = Keyboard.readString().toUpperCase();
            if (UsaAgenda.agenda.containsKey(a)) {
                UsaAgenda.agenda.remove(a);
                System.out.println("Alias: " + a + ". ELIMINADO");
            } else {
                System.out.println("Alias no existente. Ingresa otro.");
                return;
            }
        }
    }

    //Método para modificar contactos
    public void modificarContactos() {
        if (UsaAgenda.agenda.isEmpty()) {
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
                    modificarContactoNombre();
                    break;
                case '2':
                    modificarContactoCorreo();
                    break;
                case '3':
                    modificarContactoTelefonos();
                    break;
            }
        }
    }

    //Métodos para buscar contactos
    public void buscarContactos() {
     if(UsaAgenda.agenda.isEmpty()){
         System.out.println("La agenda está vacia");
     }else{
        char op2;
        do {
            System.out.println("----------Menú Buscar Contactos----------\n1- Buscar por alias.\n2- Buscar por nombre\n3- Salir.");
            op2 = Keyboard.readChar();
        } while (Validaciones.validaMenuBuscar(op2) == false);
        switch (op2) {
            case '1':
                System.out.println("Ingresa alias");
                String alias = Keyboard.readString().toUpperCase();
                buscarContactoAlias(alias);
                break;
            case '2':
                System.out.println("Ingresa nombre");
                String nombre = Keyboard.readString().toUpperCase();
                buscarContactoNombre(nombre);
                break;
        }
     }
    }

    public void buscarContactoAlias(String alias) {

        if (UsaAgenda.agenda.containsKey(alias)) {
            System.out.println(UsaAgenda.agenda.get(alias).toString());
        } else {
            System.out.println("No existe.");
        }
    }

    public void buscarContactoNombre(String nombre) {
        Enumeration<String> eAlias = UsaAgenda.agenda.keys();

        while (eAlias.hasMoreElements()) {
            String llave = eAlias.nextElement().toUpperCase();
            if (UsaAgenda.agenda.get(llave).getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Alias: " + llave + "\n" + UsaAgenda.agenda.get(llave));
            }
        }

    }

//Métodos para modificar contactos
    public void modificarContactoNombre() {
        String alias = Validaciones.pedirAlias().toUpperCase();
        if (UsaAgenda.agenda.containsKey(alias)) {
            System.out.println("Alias: " + alias + "\nNombre anterior:" + UsaAgenda.agenda.get(alias).getNombre());
            System.out.println("Ingresa el nombre nuevo");
            String nn = Keyboard.readString().toUpperCase();
            UsaAgenda.agenda.get(alias).setNombre(nn);
            System.out.println("Alias: " + alias + "\n" + UsaAgenda.agenda.get(alias));

        } else {
            System.out.println("No existe ese alias en la agenda.");
            return;
        }
    }

    public void modificarContactoCorreo() {
        String alias = Validaciones.pedirAlias().toUpperCase();

        if (UsaAgenda.agenda.containsKey(alias)) {
            System.out.println("Alias: " + alias + "\nCorreo anterior:" + UsaAgenda.agenda.get(alias).getCorreo());
            System.out.println("Ingresa el Correo nuevo");
            String cc = Keyboard.readString().toUpperCase();
            UsaAgenda.agenda.get(alias).setCorreo(cc);
            System.out.println("Alias: " + alias + "\n" + UsaAgenda.agenda.get(alias));

        } else {
            System.out.println("No existe ese alias en la agenda.");
            return;
        }
    }

    public void modificarContactoTelefonos() {
        String alias = Validaciones.pedirAlias().toUpperCase();

        if (UsaAgenda.agenda.containsKey(alias)) {
            System.out.println("Alias: " + alias + "\nTelefono 1:" + UsaAgenda.agenda.get(alias).getTelefono1() + ". Telefono 2: " + UsaAgenda.agenda.get(alias).getTelefono2());
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
            long T2 = UsaAgenda.agenda.get(alias).getTelefono2();
            if (Validaciones.validaSiNo(Conf)) {
                do {
                    System.out.println("Telefono 2: ");
                    T2 = Keyboard.readLong();
                    aux = String.valueOf(T2);
                } while (Validaciones.validarTelefono(aux) == false);
                System.out.println("Telefono 2: " + T2);
            }

            UsaAgenda.agenda.get(alias).setTelefono1(t1);
            UsaAgenda.agenda.get(alias).setTelefono2(T2);

            System.out.println("Alias: " + alias + "\n" + UsaAgenda.agenda.get(alias));
        }

    }

//Métodos para desplegar menu Contactos
    public void desplegarMenuContactos() {

        char i;
        do {
            System.out.println("----------Menu Contactos----------\n1- Agregar contacto.\n2- Eliminar contacto.\n3- Modificar contacto.\n4- Salir.");
            i = Keyboard.readChar();
        } while (Validaciones.validarMenuContactos(i) == false);

        switch (i) {
            case '1':
                agregarContacto();
                break;
            case '2':
                eliminarContacto();
                break;
            case '3':
                modificarContactos();
                break;

        }
    }
}
