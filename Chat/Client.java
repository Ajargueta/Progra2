package Chat;

import javax.swing.JFrame;

public class Client {
    public static void main(String[] args) {
        InClient win = new InClient();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
    }
}
