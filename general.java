import java.util.ArrayList;
import java.util.Scanner;


public class general {
    public static void main(String args[]) {
        int opt, n, n2;
        String name;
        double sal, hp;
        Scanner input = new Scanner(System.in);
        ArrayList<Cuenta> save = new ArrayList<Cuenta>();
        do{
            System.out.println("1 -. Ingresar una cuenta");
            System.out.println("2 -. Ingresar varias cuentas");
            System.out.println("3 -. Mostrar todas las cuentas");
            System.out.println("4 -. Deposito a Cuenta");
            System.out.println("5 -. Retiro a Cuenta");
            System.out.println("6 -. Consultar Saldo");
            System.out.println("7 .- Transferencia entre cuentas");
            System.out.println("8 -. Eliminar cuenta");
            System.out.println("0 .- SALIR");
            opt = input.nextInt();
            switch(opt){
                case 1:
                    name = "";
                    while(name == ""){
                        System.out.print("Ingrese el nombre: ");
                        input.nextLine();
                        name = input.nextLine();
                    }
                    sal = -1;
                    while(sal < 0){
                        System.out.print("Ingrese el saldo: ");
                        sal = input.nextDouble();
                        if(sal < 0){
                            System.out.println("No puede crear una cuenta con saldo negativo");
                        }else{
                            Cuenta cuen = new Cuenta(name, sal);
                            save.add(cuen);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Cuantos usuarios desea ingresar: ");
                    input.nextLine();
                    n = input.nextInt();
                    for(int i = 1; i <= n; ++i){
                        name = "";
                        while(name == ""){
                            System.out.printf("Ingrese el nombre de cuenta #%d: ",i);
                            input.nextLine();
                            name = input.nextLine();
                         }
                        sal = -1;
                        while(sal < 0){
                            System.out.printf("Ingrese el saldo de la cuenta #%d: ",i);
                            sal = input.nextDouble();
                            if(sal < 0){
                                System.out.println("No puede crear una cuenta con saldo negativo");
                            }else{
                                Cuenta cuen = new Cuenta(name, sal);
                                save.add(cuen);
                        }
                    }
                    }
                    break;
                case 3:
                    for(int j = 0; j < save.size(); j++){
                        System.out.printf("Nombre: %s - Saldo: %5.2f%n",save.get(j).getname(), save.get(j).getsaldo());;
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre de la cuenta a depositar: ");
                    input.nextLine();
                    name = input.nextLine();
                    n = -1;
                    for(int j = 0; j < save.size(); j++){
                        if (save.get(j).getname().equals(name)){
                            n = j;
                            break;
                        }
                    }
                    if(n == -1){
                        System.out.println("No existe una cuenta con ese nombre");
                    }else{
                        System.out.print("Ingrese la cantidad a depositar: ");
                        sal = input.nextDouble();
                        if (sal < 0){
                            System.out.println("No puede depositar una cantidad negativa.");
                        }else{
                            sal = sal + save.get(n).getsaldo();
                            save.get(n).changesaldo(sal);
                        }
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el nombre de la cuenta a retirar: ");
                    input.nextLine();
                    name = input.nextLine();
                    n = -1;
                    for(int j = 0; j < save.size(); j++){
                        if (save.get(j).getname().equals(name)){
                            n = j;
                            break;
                        }
                    }
                    if(n == -1){
                        System.out.println("No existe una cuenta con ese nombre");
                    }else{
                        System.out.print("Ingrese la cantidad a retirar: ");
                        sal = input.nextDouble();
                        if (sal > save.get(n).getsaldo()){
                            System.out.println("No tiene esa cantidad disponible en esa cuenta.");
                        }else{
                            sal = save.get(n).getsaldo() - sal;
                            save.get(n).changesaldo(sal);
                        }
                    }
                    break;
                case 6:
                    System.out.print("Ingrese la cuenta a buscar: ");
                    input.nextLine();
                    name = input.nextLine();
                    n = -1;
                    for(int j = 0; j < save.size(); j++){
                        if (save.get(j).getname().equals(name)){
                            n = j;
                        }
                    }
                    if(n == -1){
                        System.out.println("No existe una cuenta con ese nombre");
                    }else{
                        System.out.printf("Nombre: %s - Saldo: %5.2f%n",save.get(n).getname(), save.get(n).getsaldo());
                    }
                    break;
                case 7:
                    System.err.print("Ingrese la cuenta emisora: ");
                    input.nextLine();
                    name = input.nextLine();
                    n = -1;
                    for(int j = 0; j < save.size(); j++){
                        if (save.get(j).getname().equals(name)){
                            n = j;
                        }
                    }
                    if(n == -1){
                        System.out.println("No existe una cuenta con ese nombre");
                    }else{
                        System.err.print("Ingrese la cuenta receptora: ");
                        input.nextLine();
                        name = input.nextLine();
                        n2 = -1;
                        for(int j = 0; j < save.size(); j++){
                            if (save.get(j).getname().equals(name)){
                                n2 = j;
                            }
                        }
                        if(n2 == -1){
                            System.out.println("No existe una cuenta con ese nombre");
                        }else{
                            System.out.print("Ingrese la cantidad a transferir: ");
                            sal = input.nextDouble();
                            if (sal > save.get(n).getsaldo()){
                                System.out.println("No tiene esa cantidad disponible en esa cuenta.");
                            }else{
                                hp = save.get(n).getsaldo() - sal;
                                save.get(n).changesaldo(hp);
                                hp = save.get(n2).getsaldo() + sal;
                                save.get(n2).changesaldo(hp);
                            }
                    }
                    }
                    break;
                case 8:
                    System.out.print("Ingrese la cuenta a eliminar: ");
                    input.nextLine();
                    name = input.nextLine();
                    n = -1;
                    for(int j = 0; j < save.size(); j++){
                        if (save.get(j).getname().equals(name)){
                            n = j;
                        }
                    }
                    if(n == -1){
                        System.out.println("No existe una cuenta con ese nombre");
                    }else{
                        System.out.printf("Nombre: %s - Saldo: %5.2f%n",save.get(n).getname(), save.get(n).getsaldo());
                        System.out.print("Esta seguro que desea eliminar esta cuenta? (SI/NO): ");
                        name = input.nextLine();
                        if (name.toUpperCase() == "NO"){
                            save.remove(n);
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Esa no es una opcion valida");
            }
            System.out.println("\n");
        }while( opt != 0);
        input.close();
    }
}