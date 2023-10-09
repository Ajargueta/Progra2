import java.util.Scanner;

import java.util.ArrayList;
public class Estudiante {
    private String name;
    private int cuenta;
    public ArrayList<Matriculas> materias = new ArrayList<Matriculas>();
    Scanner input = new Scanner(System.in);
    public Estudiante(int acco){
        this.name = this.setname();
        this.cuenta = acco;
    }
    private String setname(){
        String name = "";
        while(name == ""){
            System.out.print("Ingrese el primer nombre y el primer apellido: ");
            name = input.nextLine();
            if(name == ""){
                System.out.println("Ingrese un nombre.\n");
            }else{
                return name.toUpperCase();
            }
        }
        return name.toUpperCase();
    }
    public int getcuenta(){
        return this.cuenta;
    }
    public void setmaterias(){
        System.out.printf("Cuantas materias desea agregar: ");
        int n = input.nextInt();
        for (int i = 1; i <= n; i++){
            System.out.printf("Materia #%d%n", i);
            Matriculas mat = new Matriculas(this);
            materias.add(mat);
        }
    }

    public void getinfo(){
        System.out.printf("%nEstudiante: %s \tCuenta: %d %n", this.name, this.cuenta);
        for(int i = 0; i < materias.size(); i++){
            materias.get(i).displayresults();
        }
    }
}
