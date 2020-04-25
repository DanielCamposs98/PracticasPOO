package Administradores;

import ClasesBase.Contacto;
import Utilerias.Keyboard;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class UsaAgenda {

    public Hashtable<String, Contacto> agenda = new Hashtable<String, Contacto>();

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

    public void guardarArchivo() {

        System.out.println("Ingresa el nombre del archivo.");
        String nombre = Keyboard.readString();

        try {
            FileWriter fW = new FileWriter(nombre);
            PrintWriter pW = new PrintWriter(fW);
            Enumeration<String> en = agenda.keys();
            while (en.hasMoreElements()) {
                String key = en.nextElement();
                pW.println(key + " " + " " + agenda.get(key).toStringCons());

            }
            fW.close();
            pW.close();
            System.out.println("Se exporto la lista");

        } catch (IOException e) {
            System.out.println("Error de Entrada/Salida");
        }

    }
    
    
    public void leerArchivo(){
        StringTokenizer tokenizer;
        String linea,alias, nombre, correo;
        char tpContacto;
        long T1, T2;
        
        try{
            FileReader fr= new FileReader("Agenda.txt");
            BufferedReader br= new BufferedReader(fr);
            linea=br.readLine();
            for(int k=0;linea!=null;k++){
                int c=0;
                try{
                    tokenizer= new StringTokenizer(linea);
                    nombre=tokenizer.nextToken();
                    T1=Long.parseLong(tokenizer.nextToken());
                    T2=Long.parseLong(tokenizer.nextToken());
                   correo=tokenizer.nextToken();
                    tpContacto=tokenizer.nextToken().charAt(0);
                    Contacto con= new Contacto(nombre, T1, T2, correo, tpContacto);
                   agenda.put(linea, con);
                 
                }catch(NumberFormatException e){
                    System.out.println("Linea ignorada\r"+linea);
                }
                 linea=br.readLine();
            }
             
            br.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    public void guardarBytes() {
      Enumeration<Contacto> en= agenda.elements();
      try{
          while(en.hasMoreElements()){
              Contacto elem= en.nextElement();
              ObjectOutputStream file= new ObjectOutputStream(new FileOutputStream("bytex.dat"));
              file.writeObject(elem);
          }
          }catch(IOException e){
                  System.out.println(e);
                  }
      }

    }


