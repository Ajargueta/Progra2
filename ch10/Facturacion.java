import java.util.ArrayList;

public class Facturacion {
    public static void main(String[] args) {
        Productos p1 = new Productos("Pastel", 320, 2);
        Productos p2 = new Productos("Donas", 25, 6);
        Fecha feactual = new Fecha(12, 12, 2023);
        Factura factura1 = new Factura("Pablo", feactual);
        factura1.agregarproducto(p1);
        factura1.agregarproducto(p2);
        Fecha f1 = new Fecha(15, 8, 1990);
        Fecha f2 = new Fecha(28, 3, 1986);
        EmpleadoporComision emp1 = new EmpleadoporComision("Mario", "Bonilla", "03011990", f1, 8000, .09);
        EmpleadoporComisionmasBase emp2 = new EmpleadoporComisionmasBase("Eduar", "Martinez", "12151986", f2, 5000, .05, 800);
        ArrayList<PorPagar> lista = new ArrayList<PorPagar>();
        lista.add(factura1);
        lista.add(emp1);
        lista.add(emp2);
        for (int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i).mostrardes());
        }
        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i) instanceof Factura) {
                Factura ts = (Factura) lista.get(i);
                ts.imprimirfactura();
            }else{
                System.out.println(lista.get(i) + "\n");
            }
        }
    }
}
