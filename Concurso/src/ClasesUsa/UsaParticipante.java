package ClasesUsa;


import Utilerias.Keyboard;
import ClasesBase.Participante;
import java.util.Random;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class UsaParticipante {
    
    
    public static void asignarTurno(){
  
         Random r=new Random();
      int turno;
       do{
          turno=r.nextInt(UsaConcurso.maximoParticipantes);
      }while(Utilerias.Validaciones.validarTurno(turno)==false);
       
        System.out.println("-----Ingresa el nombre del participante-----");
        String nombre= Keyboard.readString().toUpperCase();
        
        System.out.println("-----Ingresa la escuela de procedencia------");
        String escuela= Keyboard.readString().toUpperCase();
        
        Participante p= new Participante(nombre,escuela);
            System.out.println("----------Participante----------\n"+p);
        
        UsaConcurso.participantes.put(turno, p);
        
    
}

   public static void imprimeParticipantes() {
    Hashtable<Integer,Participante> ht= UsaConcurso.participantes;
    
    Set<Integer> setter= ht.keySet();
    Iterator<Integer> itr= setter.iterator();
    
   if(ht.isEmpty()){
       System.out.println("No hay participantes.");
   }else{
       while(itr.hasNext()){
           int turno=itr.next();
           System.out.println("--------------------------------------------\nTurno: "+turno+".\n"+ht.get(turno));
       }
   }
    
    }
}
