/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadoras;

import ClasesBase.Trabajador;
import Trabajadores.TrabajadorAuxiliar;
import Utilerias.Keyboard;

/**
 *
 * @author Daniel Campos
 */
public class UsaTrabajadorAuxiliar {

    public Trabajador agregarTrabajadorAuxiliar() {
        int c3;
        String nombre,apellido;
        char sx;
        int cC,cN,cG,cL;

            do {
                System.out.println("Nombre del empleado:");
                nombre=Keyboard.readString().toUpperCase();
            } while (Utilerias.Validaciones.isLetter(nombre) == false);
           
            do {
                System.out.println("Apellido del empleado:");
               apellido=Keyboard.readString().toUpperCase();
             } while (Utilerias.Validaciones.isLetter(nombre) == false);
        
        
            do {
                System.out.println("Sexo del empleado (F/M):");
              sx=Keyboard.readChar();
            } while (Utilerias.Validaciones.sexoCorrecto(sx) == false);

            do {
                System.out.println("Cajas de Ciruela recogidas (Quincena):");
                cC=Keyboard.readInt();
            } while (cC<0);
         

            do {
                System.out.println("Cajas de Naranja recogidas (Quincena):");
                cN=Keyboard.readInt();
            } while (cN<0);
           
            do {
                System.out.println("Cajas de Guanabana recogidas (Quincena):");
                cG=Keyboard.readInt();
            } while (cG<0);
            
            do {
                System.out.println("Cajas de Limon recogidas (Quincena):");
                cL=Keyboard.readInt();
            } while (cL<0);
         

            return new TrabajadorAuxiliar(nombre, apellido, sx, cC, cN, cG, cL);

        }
    

    }
