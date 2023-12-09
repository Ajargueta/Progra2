public class Rectangulo extends Cuadrado {
    public Rectangulo(double[] x, double[] y){
        super(x, y);
    }
    @Override
    public String toString(){
        return String.format("El area del Rectangulo es de %.2f", area());
    }
}
