import java.util.*;
public class Factura {
    private String cliente;
    private String fecha;
    ArrayList<Productos> productos = new ArrayList<Productos>();
    Scanner input = new Scanner(System.in);
    Factura(String cliente, String fecha){
        this.cliente = cliente.toUpperCase();
        this.fecha = fecha;
        addproducts();
    }
    private void addproducts(){
        System.out.print("Cuantos productos compro este cliente: ");
        int n = input.nextInt();
        for(int i = 1; i <= n; i++){
            System.out.printf("Ingrese la cantidad que compro del producto #%d: ", i);
            int cant = input.nextInt();
            System.out.printf("Ingrese el nombre del producto #%d: ", i);
            input.nextLine();
            String nombre = input.nextLine();
            System.out.printf("Ingrese el precio del producto #%d: ", i);
            double precio = input.nextDouble();
            Productos pro = new Productos(nombre, precio, cant);
            productos.add(pro);
        }
    }
    public void getformat(){
        System.out.printf("Cliente: %s%nFecha: %s%n", this.cliente, this.fecha);
        System.out.println("Cant\tNombre\t\tPrecio\tSubtotal");
        double total = 0;
        for(int i = 0 ; i < productos.size(); i++){
            productos.get(i).getformat();
            total+= productos.get(i).getsubtotal();
        }
        System.out.printf("Su factura total es L. %.2f", total);
    }
}