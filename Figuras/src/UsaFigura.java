
import java.util.Scanner;

public class UsaFigura {

    Figura[] arrFigura = new Figura[5];
    Scanner E = new Scanner(System.in);

    static int cuentaFig = 0;

    public void altaFigura() {
        if (cuentaFig == arrFigura.length) {
            System.out.println("No puedes agregar más figuras.");
        } else {
            int iMenu;
            String aux;
            do {
                System.out.println("Menu Figuras: ALTA FIGURA\n 1- Cuadrado.\n2- Circulo.\n3- Rectangulo.\n4- Poligono.\n5- Rombo.\n6- Salir");
                aux = E.next();
            } while (isNum(aux) == false);
            iMenu = Integer.parseInt(aux);
            switch (iMenu) {
                case 1:
                    arrFigura[cuentaFig] = agregaCuadrado();
                    break;
                case 2:
                    arrFigura[cuentaFig] = agregaCirculo();
                    break;
                case 3:
                    arrFigura[cuentaFig] = agregaRectangulo();
                    break;
                case 4:
                    arrFigura[cuentaFig] = agregaPoligono();
                    break;
                case 5:
                    arrFigura[cuentaFig] = agregaRombo();

                    break;

                case 6:
                    System.out.println("Cerrando Programa");
                    break;
            }
        }

    }

    public Cuadrado agregaCuadrado() {
        String l;
        do {
            System.out.println("Ingrese tamaño de lado.");
            l = E.next();
        } while (isNum(l) == false);
        Double d = Double.parseDouble(l);
        Cuadrado c = new Cuadrado("Cuadrado", d);
        cuentaFig++;
        return c;
    }

    public Circulo agregaCirculo() {
        double r;
        String aux;
        do {
            do {
                System.out.println("Ingrese el tamaño del radio.");

                aux = E.next();
            } while (isNum(aux) == false);
            r = Double.parseDouble(aux);
        } while (r <= 0);
        Circulo c = new Circulo("Circulo", r);
        cuentaFig++;
        return c;
    }

    public Rombo agregaRombo() {
        double l, dM, dm;
        String aux;

        do {
            System.out.println("Ingresa tamaño de lado");
            aux = E.next();
        } while (isNum(aux) == false);
        l = Double.parseDouble(aux);

        do {
            do {
                System.out.println("Ingrese tamaño diagonal mayor");
                aux = E.next();
            } while (isNum(aux) == false);
            dM = Double.parseDouble(aux);
        } while (dM <= 0);

        do {
            do {
                System.out.println("Ingrese tamaño diagonal menor");
                aux = E.next();
            } while (isNum(aux) == false);
            dm = Double.parseDouble(aux);
        } while (dm >= dM && dm <= 0);

        Rombo r = new Rombo("Rombo", dM, dm, l);
        cuentaFig++;
        return r;
    }

    public Poligono agregaPoligono() {
        int nLados;
        double lado, apotema;
        String aux;
        do {
            do {
                System.out.println("Ingresa N° Lados");
                aux = E.next();
            } while (isNum(aux) == false);
            nLados = Integer.parseInt(aux);
        } while (nLados < 5);
        do {
            do {
                System.out.println("Ingresa tamaño lado");
                aux = E.next();
            } while (isNum(aux) == false);
            lado = Double.parseDouble(aux);
        } while (lado <= 0);
        do {
            do {

                System.out.println("Ingresa tamaño apotema");
                aux = E.next();
            } while (isNum(aux) == false);
            apotema = Double.parseDouble(aux);
        } while (apotema <= 0);

        Poligono p = new Poligono("Poligono", apotema, nLados, lado);
        cuentaFig++;
        return p;
    }

    public Rectangulo agregaRectangulo() {
        double largo, ancho;
        String aux;
        do {
            do {
                System.out.println("Ingresa largo");
                aux = E.next();
            } while (isNum(aux) == false);
            largo = Double.parseDouble(aux);
        } while (largo <= 0);
        do {
            do {
                System.out.println("Ingresa ancho");
                aux = E.next();
            } while (isNum(aux) == false);
            ancho = Double.parseDouble(aux);
        } while (ancho <= 0 || ancho == largo);
        Rectangulo r = new Rectangulo("Rectangulo", ancho, largo);
        cuentaFig++;
        return r;
    }

    ///CÓMO UTILIZO EL MÉTODO INSTANCE OF
    public void obtenerDatos() {
        if (cuentaFig == 0) {
            System.out.println("No hay figuras");
        } else {
            System.out.println("---------------------Menu Figuras: ÁREA FIGURA-----------------------\n1- Cuadrado.\n2- Circulo.\n3- Rectangulo.\n4- Poligono.\n5- Rombo.\n6- Salir");
            int iMenu;
            String aux;
            do {
                aux = E.next();
            } while (isNum(aux) == false);
            iMenu = Integer.parseInt(aux);
            switch (iMenu) {

                case 1:
                    int c = 0;
                    for (int i = 0; i < cuentaFig; i++) {
                        if (arrFigura[i] instanceof Cuadrado) {
                            System.out.println(arrFigura[i].toString());
                            c++;
                        }
                    }
                    if (c == 0) {
                        System.out.println("No hay cuadrados agregados.");
                    }
                    break;
                case 2:
                    int c2 = 0;
                    for (int i = 0; i < cuentaFig; i++) {
                        if (arrFigura[i] instanceof Circulo) {
                            System.out.println(arrFigura[i].toString());
                            c2++;
                        }
                    }
                    if (c2 == 0) {
                        System.out.println("No hay circulos agregados.");
                    }
                    break;

                case 3:
                    int c3 = 0;
                    for (int i = 0; i < cuentaFig; i++) {
                        if (arrFigura[i] instanceof Rectangulo) {
                            System.out.println(arrFigura[i].toString());
                            c3++;
                        }
                    }
                    if (c3 == 0) {
                        System.out.println("No hay rectangulos agregados.");
                    }
                    break;
                case 4:
                    int c4 = 0;
                    for (int i = 0; i < cuentaFig; i++) {
                        if (arrFigura[i] instanceof Poligono) {
                            System.out.println(arrFigura[i].toString());
                            c4++;
                        }
                    }
                    if (c4 == 0) {
                        System.out.println("No hay poligonos agregados.");
                    }
                    break;

                case 5:
                    int c5 = 0;
                    for (int i = 0; i < cuentaFig; i++) {
                        if (arrFigura[i] instanceof Rombo) {
                            System.out.println(arrFigura[i].toString());
                            c5++;
                        }
                    }
                    if (c5 == 0) {
                        System.out.println("No hay rombos agregados.");
                    }

                    break;
                case 6:
                    break;
            }
        }
    }

    public void imprimeFiguras() {
        if (cuentaFig == 0) {
            System.out.println("No hay figuras añadidas.");
        } else {
            for (int i = 0; i < cuentaFig; i++) {
                System.out.println(arrFigura[i].toString());
            }
        }
    }

    public static boolean isNum(String c) {
        boolean est = true;
        for (int i = 0; i < c.length(); i++) {
            if (!Character.isDigit(c.charAt(i)) || c.charAt(i) == '.') {
                est = false;
                break;
            }
        }
        return est;
    }

}
