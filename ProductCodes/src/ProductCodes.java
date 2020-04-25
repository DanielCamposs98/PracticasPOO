
public class ProductCodes {
    
    public static void main (String []a){
        String code;
        char zone;
        int  district,valid=0,banned=0;
        
        System.out.println("Código de producto (XXX para salir");
        code=Keyboard.readString();
        
        while(!code.equalsIgnoreCase("XXX")){
            try{
                zone=code.charAt(9);
                district=Integer.parseInt(code.substring(3,7));
                valid++;
                if(zone=='R'&&district>2000){
                    banned++;
                }
                
            }catch(StringIndexOutOfBoundsException e){
                System.out.println("Longitud inválida: "+code);
            }catch(NumberFormatException e){
                System.out.println("El distrito no es numérico: "+code);
            }finally{
            code=Keyboard.readString();
                System.out.println("Total de códigos validos: "+valid);
                System.out.println("Total de codigos baneados: "+banned);
        }
        
    }
}
}
