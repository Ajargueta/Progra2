public class Productos {
    private static int count = 1;
    private int codigo;
    private String descripcion;
    private double precio;
    private int cantidad;
    public Productos(String descripcion, double precio, int cantidad){
        this.codigo = count++;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public int getcod(){
        return this.codigo;
    }
    public String getdesc(){
        return this.descripcion;
    }
    public int getcant(){
        return this.cantidad;
    }
    public double precio(){
        return this.precio;
    }
}
