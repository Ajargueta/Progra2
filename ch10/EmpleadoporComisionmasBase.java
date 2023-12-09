public class EmpleadoporComisionmasBase extends EmpleadoporComision {
    private double sueldo;
    public EmpleadoporComisionmasBase(String nombre, String apellido, String seguro, Fecha infe, double ventas, double tarifa, double sueldo){
        super(nombre, apellido, seguro, infe, ventas, tarifa);
        if (sueldo < 0) {
            throw new IllegalArgumentException("El sueldo base no puede ser menor a 0.");
        }
        this.sueldo = sueldo;
    }
    @Override
    public double ingresos(){
        return super.ingresos() + this.sueldo;
    }
    public double obtenersueldo(){
        return this.sueldo;
    }
    @Override
    public String toString(){
        return String.format("Empleado por comision mas sueldo base: %s %s%nNumero de seguro social: %s%nCumpleanio: %s%nVentas Brutas: %,.2f%nTarifa de comision: %.2f%nSueldo base: %,.2f"
        , obtenernombre(), obtenerapellido(), obtenerseguro(), obtenerfechacumple(), obtenerventas(), obtenertarifa(), obtenersueldo());
    }
}
