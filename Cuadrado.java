public class Cuadrado extends Cuadrilatero {
    public Cuadrado(double[] x, double[] y){
        super(x, y);
    }
    @Override
    public double area(){
        double l1 = magnitud(getpoint(0), getpoint(1));
        double l2 = magnitud(getpoint(0), getpoint(2));
        return l1 * l2;
    }
    @Override
    public String toString(){
        return String.format("El area del Cuadrado es de %.2f", area());
    }
}
