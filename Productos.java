public class Productos {
    private String name;
    private double price;
    private int cant;
    Productos(String name, double price, int cant){
        this.name = name;
        this.price = price;
        this.cant = cant;
    }
    public double getsubtotal(){
        double sub = 0;
        sub = price * (double) cant;
        return sub;
    }
    public void getformat(){
        System.out.printf("%d\t%s\t\t%.2f\t%.2f%n", this.cant, this.name, this.price, getsubtotal());
    }
}