public class TrabajadorporPiezas extends Empleados {
    private int numero_piezas;
    private double tarifa;
    public TrabajadorporPiezas(String nombre, String apellido, String seguro, Fecha infe, int piezas, double tarifa){
        super(nombre, apellido, seguro, infe);
        this.numero_piezas = piezas;
        this.tarifa = tarifa;
    }
    public int obtenerpiezas(){
        return this.numero_piezas;
    }
    public double obtenertarifa(){
        return this.tarifa;
    }
    @Override
    public double ingresos(){
        return obtenertarifa() * obtenerpiezas();
    }
    @Override
    public String toString(){
        return String.format("%s%nPiezas Realizadas: %d%nTarifa por pieza: %,.2f", super.toString(), obtenerpiezas(), obtenertarifa());
    }
}
