import java.util.Scanner;
//import java.util.ArrayList;
public class PrincipalMatricula {
    public static void main(String[] args){
        int opt = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese el numero de cuenta del estudiante: ");
        opt = input.nextInt();
        Estudiante st = new Estudiante(opt);
        st.setmaterias();
        st.getinfo();
        /*do{
                
        }while(opt != 0);*/
        input.close();
    }
}
