/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel Campos
 */
public class Utilerias {
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
}
