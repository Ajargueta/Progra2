import java.util.Scanner;

public class PruebaRectangulo {
    public static void main(String args[]){
        Scanner input =  new Scanner(System.in);
        Rectangulo2 rect1 = new Rectangulo2();
        System.out.println("Se creo un rectangulo con longitud 1.0 y anchura 1.0");
        System.out.printf("Su perimetro actual es: %.2f%n", rect1.perimetro());
        System.out.printf("Su area actual es: %.2f%n", rect1.area());
        System.out.print("Introduce su nueva longitud: ");
        double hp = input.nextDouble();
        rect1.cambiarlongitud(hp);
        System.out.print("Introduce su nueva anchura: ");
        hp = input.nextDouble();
        rect1.cambiaranchura(hp);
        System.out.printf("El rectangulo tiene una longitud de %.2f  y una anchura de %.2f%n", rect1.obtenerlongitud(), rect1.obteneranchura());
        System.out.printf("Su perimetro actual es: %.2f%n", rect1.perimetro());
        System.out.printf("Su area actual es: %.2f%n", rect1.area());
        input.close();
    }
}
