package Manejadoras;

import ClasesBase.Abono;

import ClasesBase.Trabajador;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import Trabajadores.*;
import Utilerias.Keyboard;
import Utilerias.TablaTrabajadoresVaciaException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.StringTokenizer;

public class UsaNomina {

    public Hashtable<Integer, Trabajador> trabajadores = new Hashtable<>();

   public ArrayList<Abono> abonos= new ArrayList<>();
    
    File archivoN = new File("Nomina.txt");
    File archivoT = new File("Trabajadores.txt");

    public void agregarTrabajador(Trabajador b) {
        Random r = new Random();
        int id;
        do {
            id = r.nextInt();
        } while (Utilerias.Validaciones.validarId(id) == false);

        trabajadores.put(id, b);
    }
    
    

    public void imprimirTrabajadores() throws TablaTrabajadoresVaciaException {
        guardarArchivoTrabajadores();
        try {
            if (trabajadores.isEmpty()) {
                TablaTrabajadoresVaciaException e = new TablaTrabajadoresVaciaException("No hay trabajadores añadidos");
                throw e;
            } else {
                Iterator<Integer> it = retornaIteradorTrabajadores();
                while (it.hasNext()) {
                    int key = it.next();
                    System.out.println("ID: " + key + "\n" + trabajadores.get(key).toString());
                }
            }
        } catch (TablaTrabajadoresVaciaException e) {
            System.out.println(e.getMessage());
        }
    }

    public Iterator retornaIteradorTrabajadores() {
        Set<Integer> sett = trabajadores.keySet();
        return sett.iterator();
    }

    public void imprimirTrabajadores(int ind) {
        Iterator<Integer> it = retornaIteradorTrabajadores();
        switch (ind) {

            case 1:

                while (it.hasNext()) {
                    int key = it.next();
                    if (trabajadores.get(key) instanceof TrabajadorBase) {
                        System.out.println(trabajadores.get(key).toString());
                    }
                }
                break;
            case 2:
                while (it.hasNext()) {
                    int key = it.next();
                    if (trabajadores.get(key) instanceof TrabajadorAuxiliar) {
                        System.out.println(trabajadores.get(key).toString());
                    }
                }
                break;
            case 3:
                while (it.hasNext()) {
                    int key = it.next();
                    if (trabajadores.get(key) instanceof TrabajadorTemporal) {
                        System.out.println(trabajadores.get(key).toString());
                    }
                }
                break;
        }

    }

    public void guardarArchivoTrabajadores() {
        try {
            FileWriter fW = new FileWriter(archivoT);
            PrintWriter pW = new PrintWriter(fW);
            Enumeration<Integer> en = trabajadores.keys();
            while (en.hasMoreElements()) {
                int key = en.nextElement();
                pW.println(key + "-" + trabajadores.get(key).toStringCons());

            }
            fW.close();
            pW.close();

        } catch (IOException e) {
            System.out.println("Error de Entrada/Salida");
        }

    }

    public void leerArchivoTrabajadores() {
        StringTokenizer tokenizer;
        int key;
        String linea, tipo, nombre, apellido;
        char sexo;
        try {
            FileReader fr = new FileReader(archivoT);
            BufferedReader br = new BufferedReader(fr);
            linea = br.readLine();
            for (int k = 0; linea != null; k++) {
                try {
                    tokenizer = new StringTokenizer(linea, "-");
                    key = Integer.parseInt(tokenizer.nextToken());
                    tipo = tokenizer.nextToken();
                    nombre = tokenizer.nextToken();
                    apellido = tokenizer.nextToken();
                    sexo = tokenizer.nextToken().charAt(0);
                    switch (tipo) {
                        case "Base":
                            double base = Double.parseDouble(tokenizer.nextToken());
                            TrabajadorBase t = new TrabajadorBase(nombre, apellido, sexo, base);
                            trabajadores.put(key, t);
                            break;
                        case "Auxiliar":
                            int cC = Integer.parseInt(tokenizer.nextToken());
                            int cN = Integer.parseInt(tokenizer.nextToken());
                            int cG = Integer.parseInt(tokenizer.nextToken());
                            int cL = Integer.parseInt(tokenizer.nextToken());
                            TrabajadorAuxiliar ta = new TrabajadorAuxiliar(nombre, apellido, sexo, cC, cN, cG, cL);
                            trabajadores.put(key, ta);
                            break;
                        case "Temporal":
                            int hrs = Integer.parseInt(tokenizer.nextToken());
                            TrabajadorTemporal tt = new TrabajadorTemporal(nombre, apellido, sexo, hrs);
                            trabajadores.put(key, tt);
                            break;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Linea ignorada\r" + linea);
                }

                linea = br.readLine();
            }

            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void eliminarTrabajador() {
        int id;
        System.out.println("Ingresa el id del trabajador a eliminar");
        id = Keyboard.readInt();
        if (trabajadores.containsKey(id)) {
            trabajadores.remove(id);
            guardarArchivoTrabajadores();
        } else {
            System.out.println("El id " + id + " no existe");
        }
    }

    public void imprimirNomina() {
        guardarArchivoTrabajadores();
        double total = 0, bonos = 0, descuentos = 0, salarioBase = 0;
        String f;
        try {
            if (trabajadores.isEmpty()) {
                TablaTrabajadoresVaciaException e = new TablaTrabajadoresVaciaException("No hay trabajadores añadidos");
                throw e;
            } else {
                Iterator<Integer> it = retornaIteradorTrabajadores();
                while (it.hasNext()) {
                    int key = it.next();
                    imprimirSueldo(key);
                    salarioBase += trabajadores.get(key).sueldo();
                    total += calcularSalarioTotal(key);
                 descuentos += calcularAbonoResta(key);
                   bonos += calcularAbonoSuma(key);

                }
                System.out.println("----------TOTALES----------");
                System.out.println("Salarios: " + salarioBase);
             System.out.println("Bonos: " + bonos);
             System.out.println("Descuentos: " + descuentos);
                System.out.println("Totales: " + (salarioBase + bonos - descuentos));
            }
        } catch (TablaTrabajadoresVaciaException e) {
            System.out.println(e.getMessage());
        }

        guardarArchivoNomina();
    }

    public void imprimirSueldo(int id) {
        System.out.println("\n-----------------------------------\n"
                + trabajadores.get(id).toString());
        System.out.println("Sueldo: " + trabajadores.get(id).sueldo());
        // System.out.println("Bonos: " + calcularAbonoSuma(id));
        // System.out.println("Descuentos: " + calcularAbonoResta(id));
        System.out.println("Sueldo total: " + calcularSalarioTotal(id));

    }

    
     public double calcularAbonoResta(int id) {
        double resta = 0;
        for (int i = 0; i < abonos.size(); i++) {
            if (abonos.get(i).idTrabajador == id) {
                if (abonos.get(i).tipo == 'D' || abonos.get(i).tipo == 'd') {
                    resta += abonos.get(i).cantidad;
                }
            }
        }
        return resta;
    }

    public double calcularAbonoSuma(int id) {
        double suma = 0;
        for (int i = 0; i < abonos.size(); i++) {
            if (abonos.get(i).idTrabajador == id) {
                if (abonos.get(i).tipo == 'B' || abonos.get(i).tipo == 'b') {
                    suma += abonos.get(i).cantidad;
                }
            }
        }
        return suma;
    }
     
    public double calcularSalarioTotal(int id) {
        double sa = 0;
        sa += trabajadores.get(id).sueldo();
         sa += calcularAbonoSuma(id);
        sa -= calcularAbonoResta(id);
        return sa;
    }

    public void eliminarNomina() {
        char conf;
        do {
            System.out.println("Se eliminarán todos los trabajadores y la nomina.\nQuieres continuar? S/SI N/NO.");
            conf = Keyboard.readChar();
        } while (Utilerias.Validaciones.validarConfirmacion(conf) == false);

        if ((conf == 'S') || (conf == 's')) {
            archivoN.delete();
            archivoT.delete();
        }
        trabajadores.clear();
    }

    public void guardarArchivoNomina() {
        try {
            FileWriter fW = new FileWriter(archivoN);
            PrintWriter pW = new PrintWriter(fW);
            Enumeration<Integer> en = trabajadores.keys();
            while (en.hasMoreElements()) {
                int key = en.nextElement();
                pW.println(key + "-" + trabajadores.get(key).toStringCons() + "-" + calcularSalarioTotal(key));
            }
            fW.close();
            pW.close();

        } catch (IOException e) {
            System.out.println("Error de Entrada/Salida");
        }

    }

    public void añadeAbono(Abono a) {
      abonos.add(a);
    }

    public void imprimeAbonos() {
      if(abonos.isEmpty()){
          System.out.println("No hay abonos.");
      }else{
          for(int i=0;i<abonos.size();i++){
              System.out.println(abonos.get(i).toString()+"\n");
          }
      }
    }
}
