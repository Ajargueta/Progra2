public class Tiempo2 {
    private int hora; // 0 - 23
    private int minuto; // 0 - 59
    private int segundo; // 0 - 59
    public Tiempo2(){
        this(0, 0, 0);
    }
    public Tiempo2(int hora){
        this(hora, 0, 0);
    }
    public Tiempo2(int hora, int minuto){
        this(hora, minuto, 0);
    }
    public Tiempo2(int hora, int minuto, int segundo){
        if (hora < 0 || hora >= 24)
            throw new IllegalArgumentException("hora debe estar entre 0 y 23");
        if (minuto < 0 || minuto >= 60)
            throw new IllegalArgumentException("minuto debe estar entre 0 y 59");
        if (segundo < 0 || segundo >= 60)
            throw new IllegalArgumentException("segundo debe estar entre 0 y 59");
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
    public Tiempo2(Tiempo2 tiempo){
        this(tiempo.obtenerHora(), tiempo.obtenerMinuto(), tiempo.obtenerSegundo());
    }
    public void establecerTiempo(int hora, int minuto, int segundo){
        if (hora < 0 || hora >= 24)
            throw new IllegalArgumentException ("hora debe estar entre 0 y 23");
        if (minuto < 0 || minuto >= 60)
            throw new IllegalArgumentException("minuto debe estar entre 0 y 59");
        if (segundo < 0 || segundo >= 60)
            throw new IllegalArgumentException("segundo debe estar entre 0 y 59");
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
    public void establecerHora(int hora){
        if (hora < 0 || hora >= 24)
            throw new IllegalArgumentException ("hora debe estar entre 0 y 23");
        this.hora = hora;
    }
    public void establecerMinuto(int minuto){
        if (minuto < 0 && minuto >= 60)
            throw new IllegalArgumentException("minuto debe estar entre 0 y 59");
        this.minuto = minuto;
    }
    public void establecerSegundo(int segundo){
        if (segundo >= 0 && segundo < 60)
            throw new IllegalArgumentException("segundo debe estar entre 0 y 59");
        this.segundo = segundo;
    }public int obtenerHora(){
        return this.hora;
    }
    public int obtenerMinuto(){
        return this.minuto;
    }
    public int obtenerSegundo(){
        return this.segundo;
    }
    public String aStringUniversal(){
        return String.format("%02d:%02d:%02d", obtenerHora(), obtenerMinuto(), obtenerSegundo());
    }
    public String toString(){
        return String.format("%d:%02d:%02d %s",((obtenerHora() == 0 || obtenerHora() == 12) ? 12 : obtenerHora() % 12),
            obtenerMinuto(), obtenerSegundo(), (obtenerHora() < 12 ? "AM" : "PM"));
    }
}
