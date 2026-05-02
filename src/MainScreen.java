import javax.swing.*;
import java.awt.*;

public class MainScreen {

    private JFrame frame;

    public MainScreen() {
        this.frame = new JFrame("MainScreen");
    }


    public void showMainScreen(){
        this.frame.setSize(500,500);
        this.frame.setLayout(new BorderLayout());
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        this.frame.setVisible(true);

    }


}
