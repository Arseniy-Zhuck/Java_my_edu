import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends MyForm{
    private JPanel rootPanel;
    private JTextField tFSurname;
    private JLabel lblSurname;
    private JLabel lblName;
    private JTextField tFName;
    private JLabel lblLastName;
    private JTextField tFLastName;
    private JButton btnSwitch;



    public Form(JFrame thisFrame, JFrame anotherFrame) {
        super(thisFrame, anotherFrame);
        btnSwitch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = "";
                if (tFSurname.getText().length() > 0) {
                    s += tFSurname.getText() + " ";
                    if (tFName.getText().length() > 0) {
                        s += tFName.getText() + " " + tFLastName.getText();
                    }
                }
                getThisFrame().setVisible(false);
                getAnotherForm().setTextFields(new String[]{s});
                getAnotherFrame().setVisible(true);
            }
        });
    }

    @Override
    protected JTextField[] getTextFields() {
        return new JTextField[]{tFSurname, tFName, tFLastName};
    }


    public JPanel getRootPanel() {
        return rootPanel;
    }

}
