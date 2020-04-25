
public class Main {

    public static void main(String[] a) {
        //Utilice la clase RangoNumException para validar la edad
        boolean est = true;
        String c;
        do {
            System.out.println("Ingrese la edad del solicitante.");
            int edad = Keyboard.readInt();
            try {
                RangoNumException.validarEdadMayor(edad);
            } catch (RangoNumException e) {
                System.out.println("Edad incorrecta");
                System.out.println(e);
            }
            System.out.println("Quieres intentar de nuevo? (S para si. Cualquier otra tecla para no)");
            c = Keyboard.readString();
        } while (Utilerias.validaSiNo(c) == true);
    }
}

