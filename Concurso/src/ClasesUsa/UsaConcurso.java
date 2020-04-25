package ClasesUsa;

import ClasesBase.Participante;
import ClasesBase.Jurado;
import ClasesBase.Evaluacion;
import Utilerias.Keyboard;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;

public class UsaConcurso {

    static final int maximoParticipantes = 10;
    public static Hashtable<Integer, Participante> participantes = new Hashtable<>();

    public static ArrayList<Jurado> jurados = new ArrayList<>();
    public static ArrayList<Evaluacion> evaluaciones = new ArrayList<>();

    public void realizarConcurso() {
        if (participantes.isEmpty()) {
            System.out.println("Debes agregar participantes primero.");
        } else if (participantes.size() < 3) {
            System.out.println("Debes agregar al menos 3 participantes");
        } else if (jurados.isEmpty()) {
            System.out.println("Debes ingresar jurados primero");
        } else {
            int contador = 1;

            do {
                if (participantes.containsKey(contador)) {
                    for (int i = 0; i < jurados.size(); i++) {
                        System.out.println("----------Evaluación----------");
                        Evaluacion e = UsaJurado.calificar(jurados.get(i), participantes, contador);
                        System.out.println(e);
                        evaluaciones.add(e);
                    }
                    contador++;
                } else {
                    contador++;
                }
            } while (contador < maximoParticipantes);
        }

    }

    public void obtenerGanador() {
        if (evaluaciones.isEmpty()) {
            System.out.println("Debes realizar el concurso primero.");
        }else{
            ArrayList<Integer> calificaciones = new ArrayList<>();

            Hashtable<Integer, Integer> sumas = new Hashtable<>();

            Set<Integer> keys = participantes.keySet();
            Iterator<Integer> it = keys.iterator();

            while (it.hasNext()) {
                int turno = it.next();
                int suma = 0;
                for (int i = 0; i < evaluaciones.size(); i++) {
                    if (turno == evaluaciones.get(i).getTurno()) {
                        suma += evaluaciones.get(i).getCalificacion();
                    }
                    sumas.put(turno, suma);
                }

            }

            Enumeration<Integer> rht = sumas.elements();

            while (rht.hasMoreElements()) {
                int elemento = rht.nextElement();
                calificaciones.add(elemento);
            }

            Comparator<Integer> comparador = Collections.reverseOrder();
            Collections.sort(calificaciones, comparador);

            for (int i = 0; i < calificaciones.size(); i++) {
                System.out.println(calificaciones.get(i));
            }

            int p1, p2, p3;
            p1 = calificaciones.get(0);
            if (calificaciones.contains(p1)) {
                for (int e = 0; e < calificaciones.size(); e++) {
                    if (calificaciones.get(e) == p1) {
                        calificaciones.remove(e);
                    }
                }
            }

            p2 = calificaciones.get(0);
            if (calificaciones.contains(p2)) {
                for (int e = 0; e < calificaciones.size(); e++) {
                    if (calificaciones.get(e) == p2) {
                        calificaciones.remove(e);
                    }
                }
            }
            p3 = calificaciones.get(0);
            if (calificaciones.contains(p3)) {
                for (int e = 0; e < calificaciones.size(); e++) {
                    if (calificaciones.get(e) == p3) {
                        calificaciones.remove(e);
                    }
                }
            }

            Enumeration<Integer> llaves = sumas.keys();

            System.out.println("----------Primer Lugar:----------");
            while (llaves.hasMoreElements()) {
                int k = llaves.nextElement();

                if (sumas.get(k) == p1) {
                    System.out.println(participantes.get(k) + "Calificacion: " + p1);
                }
            }
            Enumeration<Integer> llaves2 = sumas.keys();
            System.out.println("----------Segundo Lugar:----------");
            while (llaves2.hasMoreElements()) {
                int k = llaves2.nextElement();

                if (sumas.get(k) == p2) {
                    System.out.println(participantes.get(k) + "Calificacion: " + p2);
                }
            }
            Enumeration<Integer> llaves3 = sumas.keys();
            System.out.println("----------Tercer Lugar:----------");
            while (llaves3.hasMoreElements()) {
                int k = llaves3.nextElement();

                if (sumas.get(k) == p3) {
                    System.out.println(participantes.get(k) + "Calificacion: " + p3);
                }
            }

        }
    }


    public void imprimeMenuPrincipal() {
        int iMenu;
        do {
            do {
                System.out.println("----------Menu----------\n1- Menu Participantes.\n2- Menu Jurados.\n3-Menu Concurso.\n4-Salir");
                iMenu = Keyboard.readInt();
            } while (Utilerias.Validaciones.validaMenuPrincipal(iMenu) == false);
            switch (iMenu) {
                case 1:
                    imprimeMenuParticipantes();
                    break;
                case 2:
                    imprimeMenuJurados();
                    break;
                case 3:
                    imprimeMenuConcurso();
                    break;

                case 4:
                    System.out.println("Saliendo.");
                    break;
            }
        } while (iMenu != 4);
    }

    private void imprimeMenuParticipantes() {
        int c;
do{
        do {
            System.out.println("----------Menu Participantes----------\n1- Agregar Participantes..\n2- Mostrar Participantes.\n3-Salir");
            c = Keyboard.readInt();
        } while (Utilerias.Validaciones.validaMenuParticipantes(c) == false);
        switch (c) {
            case 1:
                UsaParticipante.asignarTurno();
                break;
            case 2:
                UsaParticipante.imprimeParticipantes();
                break;
        }
}while(c!=3);
    }

    private void imprimeMenuConcurso() {
        int c;
        do{
        do {
            System.out.println("----------Menu Concurso----------\n1- Realizar Concurso.\n2- Obtener Ganador.\n3-Salir");
            c = Keyboard.readInt();
        } while (Utilerias.Validaciones.validaMenuConcurso(c) == false);
        switch (c) {
            case 1:
                realizarConcurso();
                break;
            case 2:
                obtenerGanador();
                break;
        }
        
        }while(c!=3);
    }

    private void imprimeMenuJurados() {
        int c;
        do{
        do {
            System.out.println("----------Menu Jurados----------\n1-Agrega Jurado.\n2- Mostrar Jurados.\n3-Salir");
            c = Keyboard.readInt();
        } while (Utilerias.Validaciones.validaMenuJurados(c) == false);
        switch (c) {
            case 1:
             UsaJurado.agregarJurado();
                break;
            case 2:
              UsaJurado.imprimeJurados();
                break;
        }
        }while(c!=3);
    }
    
    
}
