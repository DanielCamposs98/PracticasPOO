package Utilerias;

import ClasesUsa.UsaConcurso;

public class Validaciones implements PuntosMaximos {

    public static boolean validarTurno(int turno) {
        if (turno < 1) {
            return false;
        }
        if (UsaConcurso.participantes.containsKey(turno)) {
            return false;
        }
        return true;
    }

    public static boolean validarIdJurado(int n) {
        if (n < 1) {
            System.out.println("Claves negativas no permitidas");
            return false;
        }
        for (int i = 0; i < UsaConcurso.jurados.size(); i++) {
            if (UsaConcurso.jurados.get(i).getClave() == n) {
                System.out.println("Esa clave ya existe.");
                return false;

            }
        }
        System.out.println("Clave: " + n);
        return true;
    }

    public static int validarCalificacion(String cal) {
        switch (cal) {
            case "BAJA":
                return PuntosMaximos.BAJA;
            case "REGULAR":
                return PuntosMaximos.REGULAR;
            case "BUENO":
                return PuntosMaximos.BUENO;
            case "NOTABLE":
                return PuntosMaximos.NOTABLE;
            case "EXCELENTE":
                return PuntosMaximos.EXCELENTE;
            case "NULA":
                return 0;
            default:
                System.out.println("Calificacion no existente.");
                return -1;
        }
    }

    public static boolean validaMenuPrincipal(int iMenu) {
        switch (iMenu) {
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return true;
                
            default:
                System.out.println("Opcion invalida.");
                return false;
        }
    }

    public static boolean validaMenuParticipantes(int c) {
        switch(c){
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            default :
                System.out.println("Opcion invalida.");
                return false;
        }
    }

    

    public static boolean validaMenuConcurso(int c) {
         switch(c){
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            default :
                System.out.println("Opcion invalida.");
                return false;
        }
    }
    public static boolean validaMenuJurados(int c) {
     switch(c){
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            default :
                System.out.println("Opcion invalida.");
                return false;
        }
    }
}
