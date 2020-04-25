/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import ClasesBase.Articulo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class Inventario {

    public Hashtable<Integer,Articulo> articulos = new Hashtable<Integer, Articulo>();
    
    public String pideNombre() {
        String nombre = null;
        File f;
        try {
            System.out.println("Ingresa el nombre del archivo.");
            nombre = Keyboard.readString();
            f= new File(nombre);        
        } catch (NullPointerException e) {
            System.out.println("No encontrado.");
        }
        return nombre;
    }
    
    public FileReader aperturarArchivo() {

        FileReader fr = null;
        try {
            fr = new FileReader(pideNombre());
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo.");
        }
        return fr;

    }

    public Articulo LeerArticulo() throws IOException,NullPointerException {
        StringTokenizer tokenizer;
        String linea, desc;
        Articulo a = null;
        int contador=0,cant=0;
        float prec=0;
        BufferedReader aE= new BufferedReader(aperturarArchivo());
     
        linea=aE.readLine();
        while(linea!=null){
            tokenizer= new StringTokenizer(linea);
            desc=tokenizer.nextToken();
            try{
                cant=Integer.parseInt(tokenizer.nextToken());
                prec=Float.parseFloat(tokenizer.nextToken());
                a=new Articulo(desc, cant, prec);
            }catch(NumberFormatException ex ){
                System.out.println("Hay Lineas Erronea, verificar archivo.");
            }
            if(!Utilerias.Validaciones.validaArticulo(desc, articulos)){
                agregarArticulo(contador, new Articulo(desc,cant,prec));
                contador++;
                try{
                    linea=aE.readLine();
                }catch(IOException e){
                    System.out.println(e);
                }
            }else{
                  System.out.println("El articulo "+ desc+" ya está en la tabla.");
                break;
            }
        }
            aE.close();
        return a;
    }
        

    private void agregarArticulo(int contador, Articulo articulo) {
      articulos.put(contador, articulo);
    }

       public void buscarPorNombre(){
        if(articulos.isEmpty()){
            System.out.println("El inventario esta vacio, no hay registro de nada...");
        }else{
            System.out.println("Nombre: ");
            String nom=Keyboard.readString();
       Enumeration<Integer> en=articulos.keys();
        while(en.hasMoreElements()){
            int llave=en.nextElement();
            if(articulos.get(llave).getDesc().equals(nom)){
                System.out.println("El articulo existe: ");
                System.out.println(articulos.get(llave));
                return;
            }
        }
        System.out.println("El articulo no existe...");
        }
    }
    
    public void imprimirTodo(){
        if(articulos.isEmpty()){
            System.out.println("Vacio....");
        }
        else{
           Utilerias.Validaciones.recorreIterador(articulos);
        }
    }
        
}


