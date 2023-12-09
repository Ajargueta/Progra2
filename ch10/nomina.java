import java.util.ArrayList;
import java.util.Scanner;

public class nomina {
    public static Scanner input = new Scanner(System.in);
    final static int[] numberofdays ={0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String args[]){
        int[] fecha = {0 , 0, 0};
        System.out.println("** Establezca la fecha actual **");
        checkdate(fecha);
        Fecha fechactual = new Fecha(fecha[0], fecha[1], fecha[2]);
        ArrayList<Empleados> nomina = new ArrayList<Empleados>();
        Fecha f1 = new Fecha(12, 6, 1992);
        EmpleadoporComision emp1 = new EmpleadoporComision("Pedro", "Matute", "12181917", f1, 5000, 0.09);
        nomina.add(emp1);
        int opt;
        do{
            System.out.println("\n\t*** Nomina ***");
            System.out.printf("Fecha Actual: %s%n%n", fechactual);
            System.out.println("1.- Registrar Empleado");
            System.out.println("2.- Mostrar Empleados");
            System.out.println("3.- Buscar Empleado por numero de seguro social");
            System.out.println("4.- Eliminar Empleado");
            System.out.println("5.- SALIR");
            System.out.printf("Ingrese su opcion a ejecutar: ");
            opt = input.nextInt();
            switch (opt) {
                case 1:
                    System.out.println("\n\t*** Registrar Empleado ***\n");
                    createnew(fecha, nomina);
                    break;
                case 2:
                    System.out.println("\n\t*** Lista de Empleados ***\n");
                    for (int j = 0; j < nomina.size(); j++) {
                        System.out.printf("%s: %s %s\t\t",
                         nomina.get(j).getClass().getName(), nomina.get(j).obtenernombre(), nomina.get(j).obtenernombre(), nomina.get(j).ingresos());
                        if (nomina.get(j).obtenermes() == fechactual.getmonth()) {
                            System.out.printf(" Tiene una bonificacion de $100 - Salario: %,.2f%n", nomina.get(j).ingresos() + 100);
                        }else{
                            System.out.printf(" Salario: %,.2f%n", nomina.get(j).ingresos());
                        }
                    }
                    break;
                case 3:
                    System.out.println("\n\t*** Buscar Empleado ***\n");
                    int ind = encontrarempleado(nomina);
                    if (ind == -1) {
                        System.out.println("No existe empleado con ese numero de seguro social.");
                    }else{
                        System.out.println(nomina.get(ind));
                    }
                    break;
                case 4:
                    System.out.println("\n\t*** Buscar Empleado ***\n");
                    int ele = encontrarempleado(nomina);
                    if (ele == -1) {
                        System.out.println("No existe empleado con ese numero de seguro social.");
                    }else{
                        nomina.remove(ele);
                        System.out.println("Empleado eleminado exitosamente");
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Esa no es una opcion valida");
                    break;
            }
        }while(opt != 5);
    }
    public static int encontrarempleado(ArrayList<Empleados> nomina){
        System.out.print("Ingrese el numero de seguro social: ");
        input.nextLine();
        String seguro = input.nextLine();
        for(int i = 0; i < nomina.size(); i++){
            if (nomina.get(i).obtenerseguro().equals(seguro)) {
                return i;
            }
        }
        return -1;
    }
    public static void checkdate(int[] ref){
        do{
            System.out.print("Ingrese el anio: ");
            ref[2] = input.nextInt();
            if (ref[2] < 1 || ref[2] > 2023) {
                System.out.printf("Anio %d?%n", ref[2]);
                ref[2] = 0;
            }
        }while(ref[2] == 0);

        do{
            System.out.print("Ingrese el mes: ");
            ref[1] = input.nextInt();
            if (ref[1] < 1 || ref[1] > 12) {
                System.out.println("El anio solo tiene 12 meses como minimo.");
                ref[1] = 0;
            }
        }while(ref[1] == 0);
        
        int bis = numberofdays[ref[1]];
        if (ref[2] % 4 == 0 && (ref[2] % 100 != 0 || ref[2] % 400 == 0) && bis == 28) {
            bis = 29;
        }
        do{
            System.out.print("Ingrese el dia: ");
            ref[0] = input.nextInt();
            if (ref[0] < 1 || ref[0] > bis) {
                System.out.printf("Este mes solo tiene %d dias en este anio.%n", bis);
                ref[0] = 0;
            }
        }while(ref[0] == 0);
    }
    public static void createnew(int[] fecha, ArrayList<Empleados> nomina){
        int opt = 0;
        do{
            System.out.println("Que tipo de empleado desea crear?");
            System.out.println("1. - Empleado en base a comision");
            System.out.println("2. - Empleado con salario base mas comision");
            System.out.println("3. - Empleado en base a piezas terminadas");
            System.out.println("Ingrese su opcion: ");
            opt = input.nextInt();
            if (opt > 3 || opt < 1) {
                System.out.println("Tiene que ingresar una opcion valida");
                opt = 0;
            }
        }while(opt == 0);
        System.out.print("Ingrese el primer nombre: ");
        input.nextLine();
        String nombre = input.nextLine();
        System.out.print("Ingrese el primer apellido: ");
        String apellido = input.nextLine();
        System.out.print("Ingrese el numero de seguro social: ");
        String seguro = input.nextLine();
        System.out.println("Fecha de cumpleanios");
        checkdate(fecha);
        Fecha fh = new Fecha(fecha[0], fecha[1], fecha[2]);
        if (opt == 1 || opt == 2) {
            double ventas;
            do{
                System.out.print("Ingrese las ventas realizadas: ");
                ventas = input.nextDouble();
                if (ventas < 0) {
                    System.out.println("Un empleado no puede tener ventas negativas.");
                }
            }while (ventas < 0);
            double tarifa;
            do{
                System.out.print("Ingrese el porcentaje de comision: ");
                tarifa = input.nextDouble();
                if (tarifa < 0 || tarifa > 1) {
                    System.out.println("Un empleado no puede tener tarifas negativas o mayores a 1.");
                }
            }while (tarifa < 0);
            if (opt == 1) {
                EmpleadoporComision emp = new EmpleadoporComision(nombre, apellido, seguro, fh, ventas, tarifa);
                nomina.add(emp);
            }else{
                double sueldo;
                do{
                    System.out.print("Ingrese el sueldo base: ");
                    sueldo = input.nextDouble();
                    if (sueldo < 0) {
                        System.out.println("Un empleado no puede sueldo base negativo.");
                    }
                }while (sueldo < 0);
                EmpleadoporComisionmasBase emp = new EmpleadoporComisionmasBase(nombre, apellido, seguro, fh, ventas, tarifa, sueldo);
                nomina.add(emp);
            }
        }else{
            int pieza;
            do{
                System.out.print("Ingrese las piezas realizadas: ");
                pieza = input.nextInt();
                if (pieza < 0) {
                    System.out.println("Un empleado no puede tener piezas negativas.");
                }
            }while (pieza < 0);
            double tarifa;
            do{
                System.out.print("Ingrese la tarifa por pieza: ");
                tarifa = input.nextDouble();
                if (tarifa < 0) {
                    System.out.println("Un empleado no puede tener tarifas negativas");
                }
            }while (tarifa < 0);
            TrabajadorporPiezas emp = new TrabajadorporPiezas(nombre, apellido, seguro, fh, pieza, tarifa);
                nomina.add(emp);
        }
    }
}
