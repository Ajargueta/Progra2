public class Empleados {
    private String nombre;
    private String apellido;
    private String seguro;
    public Empleados(){
        this("", "", "");
    }
    public Empleados(String nombre, String apellido, String seguro){
        this.nombre = nombre;
        this.apellido = apellido;
        this.seguro = seguro;
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
    @Override
    public String toString(){
        return String.format("%s %s%n Numero de seguro social: %s", obtenernombre(), obtenerapellido(), obtenerseguro());
    }
}
