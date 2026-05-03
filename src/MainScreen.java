import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainScreen {

    private JFrame frame;

    public MainScreen() {
        this.frame = new JFrame("BSS Macro");
    }


    public void showMainScreen(){
        this.frame.setSize(750,500);
        this.frame.setLayout(new BorderLayout());
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);



        JPanel panelWest = new JPanel();



        panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));

        JCheckBox Darkmode = new JCheckBox("DarkMode");

        this.frame.add(Darkmode, BorderLayout.SOUTH);

        JCheckBox checkbox2 = new JCheckBox("dd");

        panelWest.add(checkbox2);

        JCheckBox checkbox3 = new JCheckBox("ss");

        panelWest.add(checkbox3);


        this.frame.add(panelWest, BorderLayout.WEST);




        // inicializace dark mode
        ChangeBackround backround = new ChangeBackround(this.frame);
        backround.change(Darkmode);


        // F4, F5
        GlobalKeyHandler.start(this.frame);













        this.frame.setVisible(true);

    }


}
