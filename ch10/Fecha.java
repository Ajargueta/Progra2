public class Fecha {
    private int dd;
    private int mm;
    private int yy;
    final String[] month = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public Fecha(int dia, int mes, int ano){
        this.dd = dia;
        this.mm = mes;
        this.yy = ano;
    }
    public int getday(){
        return this.dd;
    }
    public int getmonth(){
        return this.mm;
    }
    public int getyear(){
        return this.yy;
    }
    @Override
    public String toString(){
        return String.format("%d de %s del %d.", getday(), month[getmonth() - 1], getyear());
    }
}
