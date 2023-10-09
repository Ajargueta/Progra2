import java.util.Scanner;
import java.lang.Math;
public class PruebaFecha {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("Ingrese su primera fecha");
        Fecha f1 = new Fecha();
        System.out.println("Ingrese sus segunda fecha");
        Fecha f2 = new Fecha();
        int diferenceofdays = Math.abs((f1.countdays() - f2.countdays()));
        System.out.printf("Entre el %s y el %s hay %d dias.",f1.displaydate(), f2.displaydate(), diferenceofdays);
        input.close();
    }
}
