package Chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class InServer extends JFrame implements Runnable{
    private JTextArea canvas; 
    public InServer(){
        super("Servidor");
        super.setSize(400, 600);
        canvas = new JTextArea();
        add(canvas);
        Thread hilo = new Thread(this);
        hilo.start();
    }
    @Override
    public void run() {
        try {
            ServerSocket serv = new ServerSocket(9999);
            Mensaje datos;
            while (true) {
                Socket reciver = serv.accept();
                ObjectInputStream data_in = new ObjectInputStream(reciver.getInputStream());
                datos = (Mensaje) data_in.readObject();
                Socket sender = new Socket(datos.getDirIp(), 9010);
                ObjectOutputStream data_out = new ObjectOutputStream(sender.getOutputStream());
                data_out.writeObject(datos);
                data_out.close();
                reciver.close();
                sender.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
}
