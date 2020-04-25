/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import ClasesBase.Articulo;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Daniel Campos
 */
public class Validaciones {
    
 public static boolean validaArticulo(String nom,Hashtable<Integer,Articulo> articulos){
        Enumeration<Integer> en=articulos.keys();
        while(en.hasMoreElements()){
            int llave=en.nextElement();
            if(articulos.get(llave).getDesc().equalsIgnoreCase(nom)){
                System.out.println(articulos.get(llave));
                return true;
            }
        }
        return false;
    }

 public static void recorreIterador(Hashtable<Integer,Articulo> art){
        Set<Integer>keys=art.keySet();
        Iterator<Integer> itr= keys.iterator();
        while(itr.hasNext()){
            Integer llave=itr.next();
            System.out.println("Llave: "+llave+" Articulo"+ art.get(llave));
            System.out.println("⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥⌥ ");
        }
        
    }

    static boolean validarMenuPrincipal(char iMenu) {
     switch(iMenu){
         case '1':
             return true;
         case '2':
             return true;
         case '3':
             return true;
         default:
             System.out.println("Ingresa una opcion valida.");
             return false;
     }
    }


}