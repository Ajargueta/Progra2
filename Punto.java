public class Punto {
    private double px;
    private double py;
    public Punto(){
        this.px = 0;
        this.py = 0;
    }
    public Punto(double x, double y){
        this.px = x;
        this.py = y;
    }
    public double getpx(){
        return this.px;
    }
    public double getpy(){
        return this.py;
    }
}
