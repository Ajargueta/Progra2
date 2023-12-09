package Chat;

import javax.swing.JFrame;

public class Server {
    public static void main(String[] args) {
        InServer winser = new InServer();
        winser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winser.setVisible(true);
    }
}
