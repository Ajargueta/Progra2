import java.util.Scanner;

public class ch05_tareas {
    static Scanner input = new Scanner(System.in);
    public static void main(String args[]){
        int opt = -1;
        do{
            System.out.println("1.- El menor numero");
            System.out.println("2.- Producto de numeros impares de 1 al 15");
            System.out.println("3.- Triangulo de asteriscos");
            System.out.println("4.- Grafico de barra");
            System.out.println("5.- Aproximacion de PI");
            System.out.print("Ingrese el numero de la opcion a ejecutar: ");
            opt = input.nextInt();
            switch(opt){
                case 1:
                    minum();
                    break;
                case 2:
                    prodimp();
                    break;
                case 3:
                    trianast();
                    break;
                case 4:
                    barast();                 
                    break;
                case 5:
                    piaprox();
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
    public static void minum(){
        System.out.println("\t*** Numero menor ***");
        System.out.print("Cuantos numeros desea ingresar: ");
        int n = input.nextInt();
        int x, hp;
        System.out.print("Ingrese #1: ");
        x = input.nextInt();
        hp = x;
        for(int i = 2; i <= n; i++){
            System.out.printf("Ingrese #%d: ", i);
            x = input.nextInt();
            hp = Math.min(hp, x);
        }
        System.out.printf("El numero menor de todos los numeros que ingreso es: %d%n%n", hp);
    }
    public static void prodimp(){
        System.out.println("\t*** Producto de numeros impares de 1 al 15 ***");
        int x = 1;
        for(int i = 3; i <= 15; i+=2){
            x *= i;
        }
        System.out.printf("El producto total es: %d%n%n", x);
    }
    public static void trianast(){
        System.out.println("\t*** Triangulo de asteriscos ***");
        System.out.print("Ingrese la altura del triangulo: ");
        int n = input.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = i; j <= n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void barast(){
        int[] num = {0, 0, 0, 0, 0};
        System.out.println("\t*** Grafico de barra ***");
        for(int i = 0; i < 5; i++){
            System.out.printf("Introduzca el #%d: ", i + 1);
            num[i] = input.nextInt();
        }
        for (int val : num) {
            System.out.printf("%d: ", val);
            for(int j = 1; j <= val; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void piaprox(){
        double pi = 1;
        int n = 1;
        System.out.println("\t*** Aproximacion de PI ***");
        for(int i = 3; i <= 15; i++){
            pi = pi + (Math.pow(-1, n)/ i);
            System.out.printf("%d, ", n);
            n++;
        }
        System.out.printf("%nPi es aproximadamente: %.10f%n%n", pi * 4);
    }
}
