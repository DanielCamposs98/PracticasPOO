/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadoras;

import ClasesBase.Trabajador;
import Trabajadores.TrabajadorTemporal;
import Utilerias.Keyboard;

/**
 *
 * @author Daniel Campos
 */
public class UsaTrabajadorTemporal {
 
    public Trabajador agregarTrabajadorTemporal() {
        String nom, app;
        char sx;
        int hrs;

        do {
            System.out.println("Nombre del empleado:");
            nom = Keyboard.readString().toUpperCase();
        } while (Utilerias.Validaciones.isLetter(nom) == false);

        do {
            System.out.println("Apellido del empleado:");
            app = Keyboard.readString().toUpperCase();
        } while (Utilerias.Validaciones.isLetter(app) == false);

        do {
            System.out.println("Sexo del empleado (F/M):");
            sx = Keyboard.readChar();
        } while (Utilerias.Validaciones.sexoCorrecto(sx) == false);

        int horas;
        do {
            System.out.println("Horas trabajadas (Quincena): ");
            hrs = Keyboard.readInt();
        } while (hrs <= 0);

        return new TrabajadorTemporal(nom, app, sx, hrs);
    }

}
