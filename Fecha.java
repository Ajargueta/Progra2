import java.util.Scanner;

public class Fecha {
    private int dd;
    private int mm;
    private int yy;
    Scanner input = new Scanner(System.in);
    public Fecha(){
        this.yy = checkyear();
        this.mm = checkmonth();
        this.dd = checkday();
    }
    public int checkyear(){
        int year = 0;
        while(year <= 2000){
            System.out.print("Ingrese el ano: ");
            year = input.nextInt();
            if (year >= 2000){
                return year;
            }else{
                System.out.println("Tiene que ingresar un ano mayor o igual a 2000.");
            }
        }
        return year;
    }
    public int checkmonth(){
        int month = -1;
        while(month < 0 || month > 12){
            System.out.print("Ingrese el numero de mes: ");
            month = input.nextInt();
            if (month < 13 && month > 0){
                return month;
            }else{
                System.out.println("Solo existen 12 meses.");
            }
        }
        return month;
    }
    public int checkday(){
        int day = -1, feb = 28;
        if ((this.yy % 4) == 0){
            feb = 29;
        }
        int[] numberofdays ={31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        while(day < 0 || day > numberofdays[this.mm - 1]){
            System.out.print("Ingrese el dia: ");
            day = input.nextInt();
            if (day <= numberofdays[this.mm - 1] && day > 0){
                return day;
            }else{
                System.out.printf("%s solo tiene %d dias.%n", getmonth(), numberofdays[this.mm - 1]);
            }
        }
        return day;
    }
    public int countdays(){
        int totaldays = 0, hp = 0;
        int feb = 28;
        if ((this.yy % 4) == 0){
            feb = 29;
        }
        int[] numberofdays ={31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i <= (this.mm - 2); i++){
            totaldays = totaldays + numberofdays[i];
        }
        totaldays = totaldays + this.dd;
        hp = (this.yy - 2000) * 365;
        totaldays = totaldays + hp;
        hp = (this.yy - 2000);
        hp = ((hp - (hp % 4)) / 4) + 1;
        if ((this.yy % 4) == 0){
            hp = hp - 1;
        }
        totaldays = totaldays + hp;
        return totaldays;
    }
    public String getmonth(){
        String[] month = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        return month[this.mm - 1];
    }
    public String displaydate(){
        String hp = String.valueOf(this.dd), fecha;
        fecha = hp + " de " + this.getmonth();
        hp = String.valueOf(this.yy);
        fecha = fecha + " del " + hp;
        return fecha;
    }
}
