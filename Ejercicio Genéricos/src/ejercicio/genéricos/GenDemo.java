package ejercicio.genéricos;

public class GenDemo {

    public static void main(String[] a) {

        //Se crea una referencia de Gen para enteros (Integer)
        Gen<Integer> iOb;

        //Se crea un objeto Gen<Integer> y se le asigna su referecia a iOb
        iOb = new Gen<Integer>(98);
        iOb.showType();

        //Se obtiene el valor de iOb. No es necesario convertir
        int v = iOb.getOb();
        System.out.println("Value: " + v);

        //Se crea un objeto iOb para cadenas
        Gen<String> strOb = new Gen<String>("Demo");
        strOb.showType();

        //Se convierte a mayúscula
        String obMay = strOb.getOb().toUpperCase();
        System.out.println(strOb.getOb());
        System.out.println(obMay);

    }
}
