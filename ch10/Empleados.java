public abstract class Empleados implements PorPagar {
    private String nombre;
    private String apellido;
    private String seguro;
    private Fecha cumple;
    public Empleados(String nombre, String apellido, String seguro, Fecha infe){
        this.nombre = nombre;
        this.apellido = apellido;
        this.seguro = seguro;
        this.cumple = infe;
    }
    public String obtenernombre(){
        return this.nombre;
    }
    public String obtenerapellido(){
        return this.apellido;
    }
    public String obtenerseguro(){
        return this.seguro;
    }
    public String obtenerfechacumple(){
        return cumple.toString();
    }
    public int obtenermes(){
        return cumple.getmonth();
    }
    public abstract double ingresos();
    @Override
    public String mostrardes(){
        return String.format("%s \t$ %,.2f", obtenernombre(), ingresos());
    }
    @Override
    public String toString(){
        return String.format("%s %s%nNumero de seguro social: %s%nCumpleanio: %s", obtenernombre(), obtenerapellido(), obtenerseguro(), obtenerfechacumple());
    }
}
