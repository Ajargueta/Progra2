import java.util.Scanner;
public class ch06 {
    static Scanner input = new Scanner(System.in);
    public static void main(String arg[]){
        int opt = -1;
        do{
            System.out.println("1.- Area Ciculo");
            System.out.println("2.- Par or impar");
            System.out.println("3.- Multiplo");
            System.out.println("4.- Exponenciacion");
            System.out.println("5.- Pitagoras");
            System.out.println("0.- SALIR");
            System.out.print("Ingrese el numero de la opcion a ejecutar: ");
            opt = input.nextInt();
            switch(opt){
                case 1:
                    System.out.println("\t*** Area de un circulo ***");
                    System.out.print("Ingrese el radio del circulo: ");
                    double r = input.nextDouble();
                    System.out.printf("El area del circulo es: %.5f", cirare(r));
                    break;
                case 2:
                    System.out.println("\t*** Par o Impar ***");
                    System.out.print("Ingrese el numero a probar: ");
                    int num = input.nextInt();
                    System.out.printf("El numero %s par", pareim(num) ? "ES": "NO ES");
                    break;
                case 3:
                    System.out.println("\t*** Multiplo ***");
                    System.out.print("Ingrese el primer numero: ");
                    int n1 = input.nextInt();
                    System.out.print("Ingrese el segundo numero: ");
                    int n2 =  input.nextInt();
                    System.out.printf("%d %s multiplo de %d", n2, esMultiplo(n1, n2) ? "ES": "NO", n1);
                    break;
                case 4:
                    System.out.println("\t*** Exponenciacion ***");
                    System.out.print("Ingrese la base: ");
                    int base = input.nextInt();
                    System.out.print("Ingrese el exponente: ");
                    int exponente =  input.nextInt();
                    System.out.printf("%d elevado a la %d es igual a: %d", base, exponente, expon(base, exponente));
                    break;
                case 5:
                    System.out.println("\t*** Pitagoras ***");
                    System.out.print("Ingrese el cateto a: ");
                    double a = input.nextDouble();
                    System.out.print("Ingrese el cateto b: ");
                    double b =  input.nextDouble();
                    System.out.printf("La hipotenusa es igual a: %.4f", pitagoras(a, b));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Esa no es una opcion valida.");
                    break;
            }
            System.out.println("\n");
        }while(opt != 0);
        input.close();
    }
    public static double cirare(double r){
        return (Math.pow(r, 2.0) * Math.PI);
    }
    public static boolean pareim(int a){
        if(a % 2 == 1){
            return false;
        }else{
            return true;
        }
    }
    public static double pitagoras(double a, double b){
        double c;
        c = Math.sqrt(((a*a) + (b * b)));
        return c;
    }
    public static int expon(int base, int power){
        int result = 1;
        for(int i = 1; i <= power; i++){
            result *= base;
        }
        return result;
    }
    public static boolean esMultiplo(int a, int b){
        if(a % b == 0){
            return true;
        }else{
            return false;
        }
    }
}
