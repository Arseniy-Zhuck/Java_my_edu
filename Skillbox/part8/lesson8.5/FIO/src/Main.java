import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame bigFrame = new JFrame();
        JFrame smallFrame = new JFrame();

        SmallForm smallForm = new SmallForm(smallFrame, bigFrame);
        Form form = new Form(bigFrame, smallFrame);
        smallForm.setAnotherForm(form);
        form.setAnotherForm(smallForm);


        bigFrame.setContentPane(form.getRootPanel());
        bigFrame.setTitle("Отдельно");
        bigFrame.setSize(420, 260);
        bigFrame.setLocationRelativeTo(null);
        bigFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        bigFrame.setVisible(true);

        smallFrame.setContentPane(smallForm.getRootPanel());
        smallFrame.setTitle("Вместе");
        smallFrame.setSize(520, 120);
        smallFrame.setLocationRelativeTo(null);
        smallFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        smallFrame.setVisible(true);


    }
}
