import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Form extends MyForm{
    private JPanel rootPanel;
    private JTextField tFSurname;
    private JLabel lblSurname;
    private JLabel lblName;
    private JTextField tFName;
    private JLabel lblLastName;
    private JTextField tFLastName;
    private JButton btnSwitch;


    @Override
    public JPanel getRootPanel() {
        return rootPanel;
    }

    public Form(JFrame thisFrame, JFrame anotherFrame) {
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
        String s = "";
        if (tFSurname.getText().length() > 0) {
            s += tFSurname.getText() + " ";
            if (tFName.getText().length() > 0) {
                s += tFName.getText() + " " + tFLastName.getText();
            }
        }
        getThisFrame().setVisible(false);
        getAnotherForm().setTextFields(new String[]{s});
        getAnotherForm().setProgress();
        getAnotherFrame().setVisible(true);
    }

    @Override
    public void setProgress() {

    }

    @Override
    protected JTextField[] getTextFields() {
        return new JTextField[]{tFSurname, tFName, tFLastName};
    }



}
