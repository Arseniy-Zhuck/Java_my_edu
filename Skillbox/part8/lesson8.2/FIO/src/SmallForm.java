import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmallForm extends MyForm{
    private JPanel rootPanel;
    private JLabel lblFIO;
    private JTextField textField1;
    private JButton btnSwitch;

    protected SmallForm(JFrame thisFrame, JFrame anotherFrame) {
        super(thisFrame, anotherFrame);
        btnSwitch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] FIO = textField1.getText().split("\\s");
                getThisFrame().setVisible(false);
                getAnotherForm().setTextFields(FIO);
                getAnotherFrame().setVisible(true);
            }
        });
    }

    @Override
    protected JTextField[] getTextFields() {
        return new JTextField[] {textField1};
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JLabel getLblFIO() {
        return lblFIO;
    }
}
