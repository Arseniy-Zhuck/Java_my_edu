import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();

        Form form = new Form();
        jFrame.setContentPane(form.getRootPanel());

        jFrame.setTitle("First experiments");
        jFrame.setSize(420, 360);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
