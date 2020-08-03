import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class MyForm {
    private JFrame thisFrame;
    private JFrame anotherFrame;
    private MyForm anotherForm;


    public abstract JPanel getRootPanel();

    protected MyForm(JFrame thisFrame, JFrame anotherFrame) {
        this.thisFrame = thisFrame;
        this.anotherFrame = anotherFrame;

    }

    protected abstract void switchForm();

    public MyForm getAnotherForm() {
        return anotherForm;
    }

    public void setAnotherForm(MyForm anotherForm) {
        this.anotherForm = anotherForm;
    }

    public JFrame getThisFrame() {
        return thisFrame;
    }

    public JFrame getAnotherFrame() {
        return anotherFrame;
    }

    protected abstract JTextField[] getTextFields();

    protected void setTextFields(String[] strings) {
        int i = 0;

        for (JTextField jTextField : getTextFields()) {
            try {
                jTextField.setText(strings[i++]);
            } catch (ArrayIndexOutOfBoundsException e) {
                jTextField.setText("");
            }
        }
    }
}
