package Chat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class InClient extends JFrame implements Runnable {
    private JLabel Label1;
    private JLabel nickn;
    private JLabel direc;
    private JTextArea logchat;
    private JTextField txt1;
    private JTextField nicktxt;
    private JTextField dirextxt;
    private JButton send;
    public InClient(){
        super("Chat");
        setLayout(new FlowLayout());
        super.setSize(450, 400);
        nickn = new JLabel("Nombre: ");
        add(nickn);
        nicktxt = new JTextField(10);
        add(nicktxt);
        direc = new JLabel("Direccion IP: ");
        add(direc);
        dirextxt = new JTextField(15);
        add(dirextxt);
        logchat = new JTextArea(15, 35);
        add(logchat);
        Label1 = new JLabel("Ingrese su mensaje: ");
        add(Label1);
        txt1 = new JTextField(25);
        add(txt1);
        send = new JButton("Enviar");
        add(send);
        Thread hilo = new Thread(this);
        hilo.start();
        sendtext actiontxt = new sendtext();
        send.addActionListener(actiontxt);
    }

    private class  sendtext implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Socket conex = new Socket("127.0.0.1", 9999);
                Mensaje datos = new Mensaje();
                datos.setNombre(nicktxt.getText());
                datos.setDirIp(dirextxt.getText());
                datos.setMessaj(txt1.getText());
                ObjectOutputStream data_out = new ObjectOutputStream(conex.getOutputStream());
                data_out.writeObject(datos);
                data_out.close();
                logchat.append(datos.getNombre() + " : " + datos.getMessaj() + "\n");
                conex.close();
            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                System.out.println(e1.getMessage());
            }
        }
    }

    @Override
    public void run() {
        try {
            ServerSocket clser = new ServerSocket(9010);
            Mensaje datos;
            while (true) {
                Socket clrec = clser.accept();
                ObjectInputStream data_in = new ObjectInputStream(clrec.getInputStream());
                datos = (Mensaje) data_in.readObject();
                logchat.append(datos.getNombre() + " : " + datos.getMessaj() + "\n");
                clrec.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
