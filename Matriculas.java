import java.util.Scanner;

public class Matriculas {
    private String codigo;
    private int nota;
    Scanner input = new Scanner(System.in);
    public Matriculas(Estudiante p1){
        this.codigo = confirmclass(p1);
        this.nota = confirmnota();
    }
    private String confirmclass(Estudiante est){
        String codigo = "";
        int ch = -1;
        while (codigo == ""){
            System.out.print("Ingrese el nombre de la materia: ");
            codigo = input.nextLine();
            for(int i = 0; i < est.materias.size(); i++){
                if(est.materias.get(i).codigo.equals(codigo.toUpperCase())){
                    ch = 1;
                    break;
                }
            }
            if(ch == 1){
                System.out.printf("%s ya esta ingresada.%n", codigo);
                codigo = "";
            }else{
                return codigo.toUpperCase();
            }
        }
        return codigo.toUpperCase();
    }

    private int confirmnota(){
        int nt = -1;
        while(nt < 0 || nt > 100){
            System.out.printf("Ingrese la nota de %s: ", this.codigo);
            nt = input.nextInt();
            if(nt < 0 || nt > 100){
                System.out.println("La nota tiene que ser un minimo de 0 y un maximo de 100.");
            }else{
                return nt;
            }
        }
        return nt;
    }
    public void displayresults(){
        System.out.printf("%n- %s \t %d \t %s",this.codigo, this.nota, (this.nota > 64) ? "Aprobado" : "Reprobado");
    }
}
