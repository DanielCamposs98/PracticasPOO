package Utilerias;

import ClasesBase.Abono;
import Manejadoras.UsaNomina;
import Manejadoras.UsaTrabajadorAuxiliar;
import Manejadoras.UsaTrabajadorBase;
import Manejadoras.UsaTrabajadorTemporal;

public class Menus {

    public static UsaNomina n = new UsaNomina();

    public void imprimeMenuPrincipal() throws OpcionFueraDeRangoException, TablaTrabajadoresVaciaException {
        int iMenu = 0;
        do {
              try {
            do {
                System.out.println("---------- Agricola Bernal----------");
                System.out.println("1- Menu Empleados.");
                System.out.println("2- Menu Abonos.");
                System.out.println("3- Menu Nomina");
                System.out.println("4- Salir.");
                iMenu = Keyboard.readInt();
            } while (Utilerias.Validaciones.validarMenuP(iMenu) == false);
               } catch (OpcionFueraDeRangoException e) {
                  System.out.println(e.getMessage());
       }

            switch (iMenu) {
                case 1:
                    imprimirMenuEmpleados();
                    break;
                case 2:
                   System.out.println("No sirve por el momento.");
                //    imprimirMenuAbonos();
                    break;
                case 3:
                    imprimirMenuNomina();
                    break;
                case 4:
                    System.out.println("Cerrando programa...");
                    break;
            }
        } while (iMenu != 4);
    }

    private void imprimirMenuEmpleados() throws TablaTrabajadoresVaciaException {
        int iMenu = 0;
        do {
            try {
                do {
                    System.out.println("----------Menu Empleados----------");
                    System.out.println("1- Agregar trabajador.");
                    System.out.println("2- Imprimir trabajadores");
                    System.out.println("3- Eliminar trabajador.");
                    System.out.println("4- Modificar trabajador.");
                    System.out.println("5- Salir.");
                    iMenu = Keyboard.readInt();
                } while (Utilerias.Validaciones.validarMenuE(iMenu) == false);
            } catch (OpcionFueraDeRangoException e) {
                System.out.println(e.getMessage());
            }

            switch (iMenu) {
                case 1:

                    imprimirMenuAgregar();
                    break;
                case 2:
                    n.imprimirTrabajadores();
                    break;
                case 3:
                    n.eliminarTrabajador();
                    break;
                case 4:
                    System.out.println("No sirve por el momento.");
                    //n.modificarT();
                    break;
            }
        } while (iMenu != 5);
    }

    private void imprimirMenuAbonos() {
        int iMenu = 0;
        do {
            try {
                do {
                    System.out.println("----------Menu Abonos----------");
                    System.out.println("1- Añadir un abono.");
                    System.out.println("2- Imprimir abonos");
                    System.out.println("3- Modificar abonos.");
                    System.out.println("4- Salir.");
                    iMenu = Keyboard.readInt();
                } while (Utilerias.Validaciones.validarMenuA(iMenu) == false);
            } catch (OpcionFueraDeRangoException e) {
                System.out.println(e.getMessage());
            }

            switch (iMenu) {
                case 1:
                    int id;
                    do {
                        System.out.println("Ingresa id del trabajador.");
                        id = Keyboard.readInt();
                    } while (Utilerias.Validaciones.validarIdAbono(id) == false);

                    System.out.println("Ingrese concepto.");
                    String concepto = Keyboard.readString();
                    char tipo;
                    do {
                        System.out.println("Ingrese tipo: B/Bono D/Descuento.");
                        tipo = Keyboard.readChar();
                    } while (Utilerias.Validaciones.tipoAbonoCorrecto(tipo) == false);
                    double cantidad;
                    do {
                        System.out.println("Ingresa cantidad");
                        cantidad = Keyboard.readDouble();
                    } while (cantidad <= 0);
                    Abono a = new Abono(concepto, cantidad, tipo, id);
                    n.añadeAbono(a);
                    break;
                case 2:
                    n.imprimeAbonos();
                    break;
                case 3:
                    System.out.println("No sirve por el momento.");
                  //  n.modificaAbono();
                    break;
                
            }
        } while (iMenu != 4);
    }

    private void imprimirMenuNomina() {
        int iMenu = 0;
        do {
            try {
                do {
                    System.out.println("----------Menu Nomina----------");
                    System.out.println("1- Imprimir nomina..");
                    System.out.println("2- Eliminar nomina");
                    System.out.println("3-  Salir.");
                    iMenu = Keyboard.readInt();
                } while (Utilerias.Validaciones.validarMenuN(iMenu) == false);
            } catch (OpcionFueraDeRangoException e) {
                System.out.println(e.getMessage());
            }

            switch (iMenu) {
                case 1:
                    n.imprimirNomina();
                    break;
                case 2:
                    n.eliminarNomina();
                    break;

            }
        } while (iMenu != 3);
    }

    private void imprimirMenuAgregar() {
        int iMenu = 0;
        do {
            try {
                do {
                    System.out.println("----------Menu Agregar----------");
                    System.out.println("1- Agregar empleado Base");
                    System.out.println("2- Agregar empleado Temporal");
                    System.out.println("3- Agregar empleado Destajo");
                    System.out.println("4- Salir.");
                    iMenu = Keyboard.readInt();
                } while (Utilerias.Validaciones.validarMenuAG(iMenu) == false);
            } catch (OpcionFueraDeRangoException e) {
                System.out.println(e.getMessage());
            }

            switch (iMenu) {
                case 1:
                    UsaTrabajadorBase m = new UsaTrabajadorBase();
                    int c;
                    do {
                        System.out.println("Cantidad de empleados a procesar (Base):");
                        c = Keyboard.readInt();
                    } while (c <= 0);
                    int i = 0;
                    do {
                        n.agregarTrabajador(m.agregarTrabajadorBase());
                        i++;
                    } while (i < c);
                    break;
                case 2:
                    UsaTrabajadorTemporal t = new UsaTrabajadorTemporal();
                    int q;
                    do {
                        System.out.println("Cantidad de empleados a procesar (Temporal):");
                        q = Keyboard.readInt();
                    } while (q <= 0);
                    int e = 0;
                    do {
                        n.agregarTrabajador(t.agregarTrabajadorTemporal());
                        e++;
                    } while (e < q);
                    break;
                case 3:

                    UsaTrabajadorAuxiliar tw = new UsaTrabajadorAuxiliar();
                    int u;
                    do {
                        System.out.println("Cantidad de empleados a procesar (Auxiliar):");
                        u = Keyboard.readInt();
                    } while (u <= 0);
                    int iq = 0;
                    do {
                        n.agregarTrabajador(tw.agregarTrabajadorAuxiliar());
                        iq++;
                    } while (iq < u);
                    break;
            }

        } while (iMenu != 4);
    }
}
