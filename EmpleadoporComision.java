public class EmpleadoporComision extends Empleados {
    private double ventas;
    private double tarifa;
    public EmpleadoporComision(){
        this("", "" ,"", 0, 0);
    }
    public EmpleadoporComision(String nombre, String apellido, String seguro, double ventas, double tarifa){
        super(nombre, apellido, seguro);
        if (ventas < 0.0) {
            throw new IllegalArgumentException("Un Empleado no puede tener ventas negativas");
        }
        if (tarifa <= 0.0 || tarifa > 1.0) {
            throw new IllegalArgumentException("Tarifa solo puede tener valore mayores a 0.0 y menores a 1.0");
        }
        this.ventas = ventas;
        this.tarifa = tarifa;
    }
    public double obtenerventas(){
        return this.ventas;
    }
    public double obtenertarifa(){
        return this.tarifa;
    }
    public double ingresos(){
        return obtenertarifa() * obtenerventas();
    }
    @Override
    public String toString(){
        return String.format("%nEmpleado por comision: %s%nVentas Brutas: %.2f%nTarifa de comision: %.2f"
        , super.toString(), obtenerventas(), obtenertarifa());
    }
}
