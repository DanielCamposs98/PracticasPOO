/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadoras;

import Utilerias.Menus;
import Utilerias.OpcionFueraDeRangoException;
import Utilerias.TablaTrabajadoresVaciaException;

/**
 *
 * @author Daniel Campos
 */
public class main {
    
    public static void main(String[]a) throws OpcionFueraDeRangoException, TablaTrabajadoresVaciaException{
        
        Menus m= new Menus();
       m.n.leerArchivoTrabajadores();
        m.imprimeMenuPrincipal();
    }
    
    
  
}
