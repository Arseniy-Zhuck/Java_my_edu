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
    private JProgressBar progressBar1;
    private final int TEXT_LENGTH = 50;


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
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                setProgress();
            }
        });
    }

    @Override
    protected void switchForm() {
        String[] FIO = textField1.getText().split("\\s",3);
        getThisFrame().setVisible(false);
        getAnotherForm().setTextFields(FIO);
        getAnotherFrame().setVisible(true);
    }

    @Override
    public void setProgress() {
        progressBar1.setMaximum(TEXT_LENGTH);
        progressBar1.setMinimum(0);
        progressBar1.setValue(textField1.getText().length());
    }

    @Override
    protected JTextField[] getTextFields() {
        return new JTextField[] {textField1};
    }




}
