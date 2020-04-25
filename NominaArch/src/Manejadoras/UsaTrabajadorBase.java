/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadoras;

import ClasesBase.Trabajador;
import Trabajadores.TrabajadorAuxiliar;
import Trabajadores.TrabajadorBase;
import Utilerias.Keyboard;

/**
 *
 * @author Daniel Campos
 */
public class UsaTrabajadorBase {

    public Trabajador agregarTrabajadorBase() {
        String nombre, apellido;
        char sx;
        double cant;
 

            do {
                System.out.println("Nombre del empleado:");
                nombre = Keyboard.readString().toUpperCase();
            } while (Utilerias.Validaciones.isLetter(nombre) == false);

            do {
                System.out.println("Apellido del empleado:");
                apellido = Keyboard.readString().toUpperCase();
            } while (Utilerias.Validaciones.isLetter(apellido) == false);

            do {
                System.out.println("Sexo del empleado (F/M):");
                sx = Keyboard.readChar();
            } while (Utilerias.Validaciones.sexoCorrecto(sx) == false);

            do {
                System.out.println("Sueldo base del trabajador:");
                cant = Keyboard.readDouble();
            } while (cant <= 0);

            return new TrabajadorBase(nombre, apellido, sx, cant);

        }


    }
