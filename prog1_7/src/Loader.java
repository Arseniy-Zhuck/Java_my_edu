import javax.swing.*;
import java.awt.*;

public class Loader
{
    public static void main(String[] args)
    {
        JFrame main_window =new JFrame();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        main_window.setSize(dim);
        main_window.setTitle("Hello world:  IT MUST BE HERE");
        main_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main_window.setVisible(true);


    }
}
