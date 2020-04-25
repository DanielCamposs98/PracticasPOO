/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import Manejadoras.UsaNomina;

/**
 *
 * @author Daniel Campos
 */
public class Validaciones {

    public static boolean validarId(int id) {
        if (id < 0) {
            return false;
        } else {
            
            if (Utilerias.Menus.n.trabajadores.containsKey(id)==false) {
                return false;
            }
            return true;
        }
    }

public static boolean validarIdAbono(int id) {
        if (id < 0) {
            return false;
        } else {
            UsaNomina n = new UsaNomina();
            if (!n.trabajadores.containsKey(id)) {
                System.out.println("No existe ese id.");
                return false;
            } 
            return true;
        }
    }    
   


    public static boolean sexoCorrecto(char c) {
        boolean est = true;
        if ((c != 'M') && (c != 'F') && (c != 'f') && (c != 'm')) {
            est = false;
        }
        return est;
    }
    
       public static boolean tipoAbonoCorrecto(char c) {
      
        if ((c != 'B') && (c != 'b') && (c != 'd') && (c != 'D')) {
            System.out.println("Dato incorrecto.");
            return false;
        }
        return true;
    }

    static boolean validarMenuP(int iMenu) throws OpcionFueraDeRangoException {
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
                OpcionFueraDeRangoException e = new OpcionFueraDeRangoException("Opcion inexistente.");
                System.out.println(e.getMessage());
                return false;
        }
    }

    static boolean validarMenuE(int iMenu) throws OpcionFueraDeRangoException {
        switch (iMenu) {
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return true;
            case 5:
                return true;
            default:
                OpcionFueraDeRangoException e = new OpcionFueraDeRangoException("Opcion inexistente.");
                System.out.println(e.getMessage());
                return false;
        }
    }

    static boolean validarMenuA(int iMenu) throws OpcionFueraDeRangoException {
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
                OpcionFueraDeRangoException e = new OpcionFueraDeRangoException("Opcion inexistente.");
                System.out.println(e.getMessage());
                return false;
        }
    }

    static boolean validarMenuN(int iMenu) throws OpcionFueraDeRangoException {
        switch (iMenu) {
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            default:
                OpcionFueraDeRangoException e = new OpcionFueraDeRangoException("Opcion inexistente.");
                System.out.println(e.getMessage());
                return false;
        }
    }

    static boolean validarMenuAG(int iMenu) throws OpcionFueraDeRangoException {
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
                OpcionFueraDeRangoException e = new OpcionFueraDeRangoException("Opcion inexistente.");
                System.out.println(e.getMessage());
                return false;
        }
    }

    public static boolean isLetter(String c) {
        boolean est = true;
        for (int i = 0; i < c.length(); i++) {
            if (!Character.isAlphabetic(c.charAt(i))) {
                est = false;
                break;
            }
        }
        return est;
    }

    public static boolean validarConfirmacion(char conf) {
        switch(conf){
            case 'S':
                return true;
            case 's':
                return true;
            case 'N':
                return true;
            case 'n':
                return true;
            default:
                System.out.println("Dato invalido.");
                return false;
        }
    }

}
