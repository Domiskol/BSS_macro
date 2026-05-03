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

        JCheckBox Darkmode = new JCheckBox("IDK");

        panelWest.add(Darkmode);

        JCheckBox checkbox2 = new JCheckBox("dd");

        panelWest.add(checkbox2);

        JCheckBox checkbox3 = new JCheckBox("ss");

        panelWest.add(checkbox3);


        this.frame.add(panelWest, BorderLayout.WEST);


        ChangeBackround backround = new ChangeBackround(this.frame);
        backround.change(Darkmode);




        Action hideAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        };

        panelWest.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F5"), "hideFrame");

        panelWest.getActionMap().put("hideFrame", hideAction);










        this.frame.setVisible(true);

    }


}
