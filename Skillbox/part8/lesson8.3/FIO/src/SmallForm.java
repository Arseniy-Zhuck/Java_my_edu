import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SmallForm extends MyForm{
    private JPanel rootPanel;
    private JLabel lblFIO;
    private JTextField textField1;
    private JButton btnSwitch;

    @Override
    public JPanel getRootPanel() {
        return rootPanel;
    }

    protected SmallForm(JFrame thisFrame, JFrame anotherFrame) {
        super(thisFrame, anotherFrame);
        btnSwitch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               switchForm();
            }
        });
        btnSwitch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ENTER) {
                    switchForm();
                }
            }
        });
    }

    @Override
    protected void switchForm() {
        String[] FIO = textField1.getText().split("\\s");
        getThisFrame().setVisible(false);
        getAnotherForm().setTextFields(FIO);
        getAnotherFrame().setVisible(true);
    }

    @Override
    protected JTextField[] getTextFields() {
        return new JTextField[] {textField1};
    }



    public JLabel getLblFIO() {
        return lblFIO;
    }
}
