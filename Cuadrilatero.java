public class Cuadrilatero {
    private Punto[] puntos = new Punto[4];
    public Cuadrilatero(double[] x, double[] y){
        for(int i = 0; i < 4; i++){
            puntos[i] = new Punto(x[i], y[i]);
        }
    }

    public double magnitud(Punto p1, Punto p2){
        double a = p2.getpx() - p1.getpx();
        double b = p2.getpy() - p1.getpy();
        double c = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)));
        return c;
    }

    public double angle(Punto p1, Punto p2){
        double dotp = (p1.getpx()* p2.getpx()) + (p1.getpy() * p2.getpy());
        double magns = magnitud(p1, getpoint(2)) * magnitud(p2, getpoint(2));
        return Math.acos(dotp/magns);
    }

    public boolean perpendicular(Punto p1, Punto p2){
        double ang = (p1.getpx()* p2.getpx()) + (p1.getpy() * p2.getpy());
        if (ang == 0) {
            return true;
        }else{
            return false;
        }
    }
    
    public Punto getpoint(int n){
        return puntos[n];
    }

    public double area(){
        double base = magnitud(getpoint(0), getpoint(1));
        double altura = magnitud(getpoint(0), getpoint(3));
        return base * altura;
    }

    @Override
    public String toString(){
        return String.format("El area del %s es de %.5f", getClass(), area());
    }

    public void showpoints(){
        for(int j = 0; j < 4; j++){
            System.out.printf("%d - (x: %.2f, y: %.2f)%n", j, getpoint(j).getpx(), getpoint(j).getpy());
        }
    }
}
