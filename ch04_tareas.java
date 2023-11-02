import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ch04_tareas {
    static Scanner input = new Scanner(System.in);
    public static void main(String args[]){
        int opt = -1;
        do{
            System.out.println("1.- Kilometros por litros");
            System.out.println("2.- Comision de ventas");
            System.out.println("3.- Calculadora de salario");
            System.out.println("4.- Numero mas grande");
            System.out.println("5.- Los dos numeros mas grandes");
            System.out.println("6.- Salida tabular");
            System.out.println("7.- Palindromo");
            System.out.println("8.- Binario a decimal");
            System.out.println("9.- Factorial");
            System.out.println("10.- Aproximacion de e a la n");
            System.out.println("0.- SALIR");
            System.out.print("Ingrese el numero de la opcion a ejecutar: ");
            opt = input.nextInt();
            switch(opt){
                case 1:
                    gasperkm();
                    break;
                case 2:
                    comiven();
                    break;
                case 3:
                    calsal();
                    break;
                case 4:
                    System.out.println("\t***Numero mas grande***");
                    comparenum(1);
                    break;
                case 5:
                    System.out.println("\t***Los dos numeros mas grandes***");
                    comparenum(2);
                    break;
                case 6:
                    tabout();
                    break;
                case 7:
                    palindr();
                    break;
                case 8:
                    bintodec();
                    break;
                case 9:
                    showfacto();
                    break;
                case 10:
                    aproxe();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Esa no es una opcion valida.");
                    break;
            }
        }while(opt != 0);
        input.close();
    }
    public static void gasperkm(){
        System.out.println("\t*** Kilometros por litros ***");
        System.out.print("Cuantos dias desea ingresar: ");
        int n = input.nextInt();
        int tk = 0, tl = 0;
        ArrayList<int[]> dd = new ArrayList<int[]>();
        for (int i = 1; i <= n ; i++){
            System.out.printf("Ingrese el numero de kilometros en el dia %d: ", i);
            int km = input.nextInt();
            System.out.printf("Ingrese la cantidad de litros consumidos en el dia %d: ",i);
            int lt = input.nextInt();
            int[] duo = {km, lt};
            dd.add(duo);
        }
        System.out.printf("%n\t Estos son los datos que ingreso:%n");
        System.out.println("Dia\tKilometros\tCombustible Consumido\t\tkm/lt");
        for(int j = 0; j < n; j++){
            System.out.printf("%d\t%d\t\t\t%d\t\t\t%.2f%n", j+1,dd.get(j)[0],
            dd.get(j)[1],(double)dd.get(j)[0]/(double)dd.get(j)[1]);
            tk += dd.get(j)[0];
            tl += dd.get(j)[1];
        }
        System.out.printf("%nSe han viajada %d kilometros en total.%nConsumido %d litros de combustible", tk, tl);
        System.out.printf("%nSe recorrio %.2f kilometros por litro.%n%n", (double)tk / (double)tl);
    }
    public static void comiven(){
        System.out.println("\t*** Comision de Ventas ***");
        double[] art = {239.99, 129.75, 99.95, 350.89};
        int[] count = {0, 0, 0, 0};
        double venta = 0;
        for(int i = 0; i < 4; i++){
            System.out.printf("Ingrese el numero de ventas relizadas para el articulo #%d: ", i + 1);
            count[i] = input.nextInt();
        }
        System.out.printf("%n\t Este es el resumen de sus ventas, comision y pago:%n");
        System.out.println("Articulo\tPrecio\t\tVentas del producto\t\tTotal de la venta\t\tComision en la venta");
        for(int j = 0; j < 4; j++){
            System.out.printf("%d\t\t%.2f\t\t\t%d\t\t\t\t%.2f\t\t\t\t%.2f%n", j+1, art[j], count[j],
                                (double)count[j] * art[j],(double)count[j] * art[j] * 0.09);
            venta += ((double)count[j] * art[j]);
        }
        System.out.printf("%nVendio $%.2f en total.%nLe corresponde una comision de $%.2f.",venta, venta * 0.09);
        System.out.printf("%nSu salario total es $%.2f.%n%n", (venta * 0.09) + 200);
    }
    public static void calsal(){
        System.out.println("\t*** Calculadora de salarios ***");
        ArrayList<double[]> dd = new ArrayList<double[]>();
        System.out.print("Cuantos empleados desea ingresar? ");
        int n = input.nextInt();
        for(int i = 1; i <= n; i++){
            System.out.printf("Ingrese la tarifa por hora del empleado #%d: ",i);
            double tf = input.nextDouble();
            System.out.printf("Ingrese las horas trabajadas por el empleado #%d: ", i);
            double hr = input.nextDouble();
            double[] data = {hr, tf};
            dd.add(data);
        }
        System.out.printf("%n\t Este es el resumen de los salarios:%n%n");
        System.out.println("#Empleado\tHoras Trabajadas\t\tTarifa por Hora\t\tSueldo Bruto");
        for(int j = 0; j < n; j++){
            System.out.printf("%d\t\t%.0f\t\t\t\t%.2f\t\t\t%.2f%n", j+1, dd.get(j)[0], dd.get(j)[1],
            (dd.get(j)[0] <= 40) ? dd.get(j)[0]*dd.get(j)[1]: ((dd.get(j)[0] - 40) * dd.get(j)[1] * 1.5) + 40 * dd.get(j)[1]);
        }
        System.out.println("\n");
    }
    public static void comparenum(int x){
        System.out.print("Cuantos numero desea ingresar: ");
        int n = input.nextInt();
        ArrayList<Integer> dd = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++){
            System.out.printf("Ingrese el #%d: ", i);
            int hp = input.nextInt();
            dd.add(hp);
        }
        Collections.sort(dd, Collections.reverseOrder());
        System.out.printf("El numero mayor es %d.%n", dd.get(0));
        if (x == 2){
            System.out.printf("El segundo numero mayor %d.%n%n",dd.get(1));
        }else{
            System.out.println();
        }
    }
    public static void tabout(){
        System.out.println("\t*** Salida Tabular ***");
        System.out.print("Ingrese un numero entero: ");
        int n = input.nextInt();
        System.out.println("N\t10*N\t100*N\t1000*N");
        for(int i = 1; i <= n; i++){
            System.out.printf("%d\t%d\t%d\t%d%n", i, i*10, i*100, i*1000);
        }
        System.out.println();
    }
    public static void palindr(){
        int ck = -1;
        String num, pal = "";
        System.out.println("\t*** Palindromo ***");
        do{
            System.out.print("Ingrese un numero que contenga 5 digitos: ");
            ck = input.nextInt();
            num = String.valueOf(ck);
            if ( num.length() != 5 ){
                System.out.println("Tiene que ingresar un numero de 5 digitos.");
                ck = -1;
            }
        }while(ck == -1);
        for (int i = 0; i < num.length(); i++){
            char ch = num.charAt(i);
            pal = ch + pal;
        }
        System.out.printf("%s%n%n", num.equals(pal) ? "Es un palindrome" : "No es un palindromo");
    }
    public static void bintodec(){
        System.out.println("\t*** Binario a decimal ***");
        System.out.print("Ingrese el numero en binario: ");
        Integer n = input.nextInt();
        String hp = String.valueOf(n);
        int dd = 0;
        for(int i = 0; i < hp.length(); i++){
            n = Integer.valueOf(Character.getNumericValue(hp.charAt(i)));
            dd = dd + (n * (int)Math.pow(2, i));
        }
        System.out.printf("El numero que ingreso en decimal es: %d%n%n", dd);
    }
    public static void showfacto(){
        System.out.println("\t*** Factorial ***");
        System.out.print("Ingrese el numero: ");
        int n = input.nextInt();
        int x = getfacto(n);
        System.out.printf("El factorial de %d es %d.%n%n", n, x);
    }
    public static void aproxe(){
        System.out.println("\t*** Aproximacion de e elevado a n ***");
        System.out.print("Ingrese el valor de n: ");
        int n = input.nextInt();
        double e = 1;
        for (int i = 1; i <= 15; i++){
            e = e + ((Math.pow(n, i)) / getfacto(i));
        }
        System.out.printf("e^%d es aproximadamente: %.10f%n%n", n, e);
    }
    public static int getfacto(int n){
        int k = 1;
        for (int i = 1; i <= n; i++){
            k = k * i;
        }
        return k;
    }
}
