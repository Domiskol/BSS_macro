import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class ChangeBackround {

    private JFrame frame;

    public ChangeBackround(JFrame frame) {
        this.frame = frame;
    }

    public void updateAllTextColors(Container container, Color textColor) {
        for (Component c : container.getComponents()) {

            c.setForeground(textColor);


            if (c instanceof JCheckBox || c instanceof JLabel || c instanceof JPanel) {
                ((JComponent) c).setOpaque(false);
            }

            if (c instanceof Container) {
                updateAllTextColors((Container) c, textColor);
            }
        }
    }


    public void change(JCheckBox checkb){
        checkb.addItemListener(e -> {
            Container cp = this.frame.getContentPane();

            if(e.getStateChange() == ItemEvent.SELECTED){

                cp.setBackground(Color.DARK_GRAY);
                updateAllTextColors(this.frame.getContentPane(),Color.WHITE);

            }else{
                cp.setBackground(Color.WHITE);
                updateAllTextColors(this.frame.getContentPane(), Color.BLACK);

            }

            cp.revalidate();
            cp.repaint();
        });
    }

}
