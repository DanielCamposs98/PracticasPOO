
public class RangoNumException extends Exception {
    
    public RangoNumException(String m){
        super(m);
    }
    
    static  void validarEdadMayor(int e) throws  RangoNumException{
        
        try{
            if(e<0){
               
                throw new RangoNumException(("Numero negativo"));
            }
            if(e<18){
                throw new RangoNumException("Menor de edad");
            }
        }catch(NumberFormatException p){
            throw new NumberFormatException("Ingresa caracteres numericos");
        }
    
    }
    
}
