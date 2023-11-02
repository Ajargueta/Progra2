import java.util.Scanner;
public class Simpletron_editor {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int[] intrucciones = new int[100];
        int n = 0, i = 0, registro = 0, acum = 0;
        System.out.println("*** Bienvenido a Simpletron! ***");
        System.out.println("*** Por favor, introduzca en su programa una instruccion ***");
        System.out.println("*** (o palabra de datos) a la vez. Yo le mostrare ***");
        System.out.println("*** el numero de ubicacion y un signo de interrogacion (?) ***");
        System.out.println("*** Entonces usted escribira la palabra para esa ubicacion. ***");
        System.out.println("*** Teclee -9999 para dejar de introducir su programa. ***");
        while (n != -9999) {
            if (i < 10) {
                System.out.print("0" + i + " ? ");
            }else{
                System.out.print(i + " ? ");
            }
            n = input.nextInt();
            intrucciones[i] = n;
            i ++;
        }
        System.out.println("*** Se completo la carga del programa ***");
        System.out.println("*** Empieza la ejecucion del programa ***");
        while (registro < 100) {
            int codigo = intrucciones[registro] / 100;
            int operando = intrucciones[registro] % 100;
            switch (codigo) {
                case 10:
                    System.out.print("Escriba un entero: ");
                    intrucciones[operando] = input.nextInt();
                    break;
                case 11:
                    System.out.println("******");
                    System.out.println("Numero: " + intrucciones[operando]);
                    break;
                case 20:
                    acum = intrucciones[operando];
                    break;
                case 21:
                    intrucciones[operando] = acum;
                    break;
                case 30:
                    acum = acum + intrucciones[operando];
                    break;
                case 31:
                    acum = acum - intrucciones[operando];
                    break;
                case 32:
                    if (intrucciones[operando] == 0) {
                        if(codigo < 10){
                            System.out.print("Error de ejecucion en palabra: 0" + codigo);
                        }else{
                            System.out.print("Error de ejecucion en palabra: " + codigo);
                        }
                        codigo = 100;
                    }else{
                        acum = acum / intrucciones[operando];
                    }
                    break;
                case 33:
                    acum = acum * intrucciones[operando];
                    break;
                case 40:
                    registro = operando - 1;
                    break;
                case 41:
                    if(acum < 0){
                        registro = operando - 1;
                    }
                    break;
                case 42:
                    if (acum == 0) {
                        registro = operando - 1;
                    }
                    break;
                case 43:
                    System.out.print("*** El programa termino exitosamente ***");
                    registro = 100;
                    break;
            }
            registro ++;
        }
        input.close();
    }
}
