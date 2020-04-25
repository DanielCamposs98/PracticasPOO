package ClasesUsa;


import Utilerias.Validaciones;
import Utilerias.Keyboard;
import ClasesBase.Jurado;
import ClasesBase.Evaluacion;
import java.util.Hashtable;


public class UsaJurado  {

    public static void agregarJurado() {
        int id;
        do {
            System.out.println("------Ingresa el id del jurado-------");
            id = Keyboard.readInt();
        } while (Validaciones.validarIdJurado(id) == false);

        System.out.println("------Ingresa el nombre del jurado-------");
        String nombre = Keyboard.readString().toUpperCase();

        ClasesBase.Jurado j = new Jurado(id, nombre);
        UsaConcurso.jurados.add(j);
    }

    public static Evaluacion calificar(Jurado j,Hashtable h, int turno) {

        System.out.println("-----Evaluacion-----\n"+h.get(turno).toString());
        System.out.println("Jurado: "+j.getClave());
       String aux;
         int cal;
         do{
        System.out.println("Ingresa Calificación ( NULA/BAJA,/REGULAR/BUENO/NOTABLE/EXCELENTE) : ");
         aux=Keyboard.readString().toUpperCase();
        cal=Validaciones.validarCalificacion(aux);
         }while(cal==-1);
         
         System.out.println("Ingresa observaciones");
         String obs= Keyboard.readString().toUpperCase();
         
         Evaluacion e= new Evaluacion(j.getClave(),turno, cal, obs);
         return e;
        
    }

   public  static void imprimeJurados() {
       if(UsaConcurso.jurados.isEmpty()){
           System.out.println("No hay jurados.");
       }else{
          for(int i=0;i<UsaConcurso.jurados.size();i++){
              System.out.println(UsaConcurso.jurados.get(i));
          }
       }
           }
}
