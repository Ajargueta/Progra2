import java.util.ArrayList;

public class Factura implements PorPagar{
    private String cliente;
    private Fecha fechacompra;
    private ArrayList<Productos> compra = new ArrayList<Productos>();
    public Factura(String cliente, Fecha fechacompra){
        this.cliente = cliente;
        this.fechacompra = fechacompra;
    }
    public void agregarproducto(Productos prod){
        compra.add(prod);
    }
    @Override
    public double ingresos(){
        double total = 0;
        for(int i = 0; i < compra.size(); i++){
            total += getsubtotal(i);
        }
        return total;
    }
    @Override
    public String mostrardes(){
        return String.format("%s \t$ %,.2f", this.cliente, ingresos());
    }
    public double getsubtotal(int ind){
        return compra.get(ind).precio()* compra.get(ind).getcant();
    }
    public void imprimirfactura(){
        System.out.printf("Cliente: %s\t Fecha: %s%n", this.cliente, this.fechacompra.toString());
        System.out.println("Codigo\tDescripcion\tPrecio Uni.\tCantidad\tSubtotal");
        for(int i = 0; i < this.compra.size(); i++){
            System.out.printf("%d\t%s\t\t%,.2f\t\t%d\t\t%,.2f%n"
            , compra.get(i).getcod(), compra.get(i).getdesc(), compra.get(i).precio(), compra.get(i).getcant(), getsubtotal(i));
        }
    }
}
