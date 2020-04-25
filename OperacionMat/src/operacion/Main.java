
package operacion;


public class Main {
    
    public static void main(String []a){
        
        Resta r1= new Resta(1, -9,"resta");
        Resta r2= new Resta(0, 9, "Resta");
        Resta r3= r1.clone();
        
        Suma s1= new Suma(3,-5,"suma");
        Suma s2= new Suma(-4,-5,"suma");
        Suma s3= s1.clone();
        
        Division d1= new Division(4, 2, "division");
        Division d2= new Division(4,2,"division");
        Division d3= d1.clone();
        
        Multiplicacion m1=new Multiplicacion(3, -1, "multiplicacion");
        Multiplicacion m2= new Multiplicacion(2,6, "multiplicacion");
        Multiplicacion m3= m1.clone();
        
        System.out.println(m1.equals(m2));
        System.out.println(m1.equals(m3));
        
        System.out.println(r1.equals(r2));
        System.out.println(r1.equals(r3));
        
        System.out.println(d1.equals(d2));
        System.out.println(d1.equals(d3));
        
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);

        System.out.println(d1); 
        System.out.println(d2);
        System.out.println(d3);
        
        
    }
}
