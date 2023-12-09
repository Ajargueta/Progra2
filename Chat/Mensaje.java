package Chat;

import java.io.Serializable;

public class Mensaje implements Serializable{
    private String nombre;
    private String dirIp;
    private String messaj;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDirIp() {
        return dirIp;
    }
    public void setDirIp(String dirIp) {
        this.dirIp = dirIp;
    }
    public String getMessaj() {
        return messaj;
    }
    public void setMessaj(String messaj) {
        this.messaj = messaj;
    }
    
}
