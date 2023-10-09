public class Cuenta {
    private String name;
    private double saldo;
    Cuenta(String name, double saldo){
        this.name = name;
        this.saldo =  saldo;
    }
    String getname(){
        return this.name;
    }
    double getsaldo(){
        return this.saldo;
    }
    void changesaldo(double saldo){
        this.saldo = saldo;
    }
}
