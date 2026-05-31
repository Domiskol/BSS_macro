import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainScreen {

    private JFrame frame;

    public MainScreen() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            System.err.println("Nepodařilo se načíst FlatLaf motiv.");
        }

        this.frame = new JFrame("BSS Macro");
    }


    public void showMainScreen(){
        this.frame.setSize(700, 450);
        this.frame.setLayout(new BorderLayout());
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel hotkeyLabel = new JLabel("Start: F4  |  Stop: F5");
        hotkeyLabel.setForeground(Color.GRAY);
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        mainPanel.add(hotkeyLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 2;
        mainPanel.add(new JLabel("Aktivní úkol:"), gbc);

        String[] bears = { "Žádný", "Polar Bear", "Black Bear", "Science Bear" };
        JComboBox<String> bearComboBox = new JComboBox<>(bears);
        gbc.gridx = 1; gbc.gridy = 2;
        mainPanel.add(bearComboBox, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        mainPanel.add(new JLabel("Pole na farmení:"), gbc);

        String[] fields = { "Clover Field", "Pumpkin Patch", "Pineapple Patch", "Dandelion" };
        JComboBox<String> fieldComboBox = new JComboBox<>(fields);
        gbc.gridx = 1; gbc.gridy = 3;
        mainPanel.add(fieldComboBox, gbc);


        JPanel settingsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcSettings = new GridBagConstraints();
        gbcSettings.insets = new Insets(8, 8, 8, 8);
        gbcSettings.anchor = GridBagConstraints.WEST;

        JCheckBox convertHoneyCheck = new JCheckBox("Automaticky převádět med u úlu");
        convertHoneyCheck.setSelected(true);
        gbcSettings.gridx = 0; gbcSettings.gridy = 0;
        settingsPanel.add(convertHoneyCheck, gbcSettings);

        JCheckBox killMobsCheck = new JCheckBox("Zabíjet brouky po cestě (Werewolf/Spider)");
        gbcSettings.gridx = 0; gbcSettings.gridy = 1;
        settingsPanel.add(killMobsCheck, gbcSettings);


        JPanel resetTimePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        resetTimePanel.add(new JLabel("Resetovat postavu každých "));
        JSpinner minutesSpinner = new JSpinner(new SpinnerNumberModel(15, 5, 60, 1));
        resetTimePanel.add(minutesSpinner);
        resetTimePanel.add(new JLabel(" minut."));
        gbcSettings.gridx = 0; gbcSettings.gridy = 2;
        settingsPanel.add(resetTimePanel, gbcSettings);
        tabbedPane.addTab("Hlavní menu", mainPanel);
        tabbedPane.addTab("Nastavení chování", settingsPanel);
        this.frame.add(tabbedPane, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JCheckBox darkModeToggle = new JCheckBox("Dark Mode Theme", true);
        darkModeToggle.addActionListener(e -> {
            try {
                if (darkModeToggle.isSelected()) {
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                } else {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                }
                SwingUtilities.updateComponentTreeUI(frame);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        southPanel.add(darkModeToggle, BorderLayout.WEST);
        southPanel.add(new JLabel("v1.0.0"), BorderLayout.EAST);
        this.frame.add(southPanel, BorderLayout.SOUTH);


        // F4, F5
        GlobalKeyHandler.start(this.frame);













        this.frame.setVisible(true);

    }


}
