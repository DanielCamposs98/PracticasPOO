/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import java.io.IOException;

/**
 *
 * @author Daniel Campos
 */
public class NewClass {

    public static void main(String[] a) throws IOException {
        UsaInventario ui = new UsaInventario();
        try {
            ui.inicializarPrograma();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
