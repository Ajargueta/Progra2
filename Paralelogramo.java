public class Paralelogramo extends Cuadrilatero {
    public Paralelogramo(double[] x, double[] y){
        super(x, y);
    }
    @Override
    public double area(){
        double v1 = magnitud(getpoint(0), getpoint(2));
        double v2 = magnitud(getpoint(3), getpoint(2));
        return (v1 * v2 * Math.sin(angle(getpoint(0), getpoint(3))) );
    }
    @Override
    public String toString(){
        return String.format("El area del Paralelogramo es de %.2f", area());
    }
}
