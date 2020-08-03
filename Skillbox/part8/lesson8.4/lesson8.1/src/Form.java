import javax.swing.*;
import java.awt.*;

public class Form {
    private JPanel rootPanel;
    private JPanel labelPanel;
    private JPanel textFieldPanel;
    private JLabel lblSurname;
    private JLabel lblName;
    private JLabel lblLastName;
    private JLabel lblDateOfBirth;
    private JLabel lblCity;
    private JButton btnConfirm;
    private JPanel buttonPanel;
    private JPanel jPTextFieldSurname;
    private JPanel jPTextFieldName;
    private JPanel jPTextFieldLastname;
    private JPanel jPTextFieldDateOfBirth;
    private JPanel jPTextFieldCity;
    private JTextField tFSurname;
    private JTextField tFName;
    private JTextField tFLastname;
    private JTextField tFDateOfBirth;
    private JTextField tFCity;


    public Form() {

        labelPanel.setLayout(new BoxLayout(labelPanel,BoxLayout.Y_AXIS));
        textFieldPanel.setLayout(new BoxLayout(textFieldPanel,BoxLayout.Y_AXIS));

    }


    public JPanel getRootPanel() {
        return rootPanel;
    }
}
