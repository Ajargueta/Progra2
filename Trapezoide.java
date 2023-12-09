public class Trapezoide extends Cuadrilatero {
    public Trapezoide(double[] x, double[] y){
        super(x, y);
    }
    @Override
    public double area(){
        double a = magnitud(getpoint(0), getpoint(1));
        double b = magnitud(getpoint(2), getpoint(3));
        double h = magnitud(getpoint(0), getpoint(2)) * Math.sin(angle(getpoint(0), getpoint(3)));
        return ((a + b) * h) / 2;
    }
    @Override
    public String toString(){
        return String.format("El area del Trapezoide es de %.2f", area());
    }
}
