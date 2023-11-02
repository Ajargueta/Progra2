public class Rectangulo {
    private double longitud;
    private double anchura;
    public Rectangulo(){
        this.longitud = 1;
        this.anchura = 1;
    }
    public double perimetro(){
        double perimetro = (this.anchura * 2) + (this.longitud * 2);
        return perimetro;
    }
    public double area(){
        double area = this.anchura * this.longitud;
        return area;
    }
    public double obteneranchura(){
        return this.anchura;
    }
    public double obtenerlongitud(){
        return this.longitud;
    }
    public void cambiaranchura(double Anchura){
        if (Anchura < 0 || Anchura > 20) {
            System.out.println("Solo puede cambiar a numeros mayores a 0 y menores a 20.");
        }else{
            this.anchura = Anchura;
        }
    }
    public void cambiarlongitud(double Longitud){
        if (Longitud < 0 || Longitud > 20) {
            System.out.println("Solo puede cambiar a numeros mayores a 0 y menores a 20.");
        }else{
            this.longitud = Longitud;
        }
    }
}