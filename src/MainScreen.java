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
        // Apply the modern FlatLaf Dark theme before initializing any GUI components
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            System.err.println("Nepodařilo se načíst FlatLaf motiv.");
        }

        this.frame = new JFrame("BSS Macro");
    }


    public void showMainScreen(){
        // Set basic window properties
        this.frame.setSize(700, 450);
        this.frame.setLayout(new BorderLayout());
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        // Create the main tabbed pane navigation
        JTabbedPane tabbedPane = new JTabbedPane();
        // Using GridBagLayout for precise positioning of labels and dropdowns
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel hotkeyLabel = new JLabel("Start: F4  |  Stop: F5");
        hotkeyLabel.setForeground(Color.GRAY);
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        mainPanel.add(hotkeyLabel, gbc);

        // Quest selection row
        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 2;
        mainPanel.add(new JLabel("Active quest:"), gbc);

        String[] bears = { "None", "Polar Bear", "Black Bear", "Science Bear" };
        JComboBox<String> bearComboBox = new JComboBox<>(bears);
        gbc.gridx = 1; gbc.gridy = 2;
        mainPanel.add(bearComboBox, gbc);

        // Field selection row
        gbc.gridx = 0; gbc.gridy = 3;
        mainPanel.add(new JLabel("field for farming"), gbc);

        String[] fields = { "Clover Field", "Pumpkin Patch", "Pineapple Patch", "Dandelion" };
        JComboBox<String> fieldComboBox = new JComboBox<>(fields);
        gbc.gridx = 1; gbc.gridy = 3;
        mainPanel.add(fieldComboBox, gbc);


        JPanel settingsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcSettings = new GridBagConstraints();
        gbcSettings.insets = new Insets(8, 8, 8, 8);
        gbcSettings.anchor = GridBagConstraints.WEST;

        JCheckBox convertHoneyCheck = new JCheckBox("Automatically transfer honey in the hive");
        convertHoneyCheck.setSelected(true);
        gbcSettings.gridx = 0; gbcSettings.gridy = 0;
        settingsPanel.add(convertHoneyCheck, gbcSettings);

        JCheckBox killMobsCheck = new JCheckBox("Kill monsters by the way");
        gbcSettings.gridx = 0; gbcSettings.gridy = 1;
        settingsPanel.add(killMobsCheck, gbcSettings);

        // Reset timer configuration panel
        JPanel resetTimePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        resetTimePanel.add(new JLabel("Reset character every "));
        JSpinner minutesSpinner = new JSpinner(new SpinnerNumberModel(15, 5, 60, 1));
        resetTimePanel.add(minutesSpinner);
        resetTimePanel.add(new JLabel(" minutes."));
        gbcSettings.gridx = 0; gbcSettings.gridy = 2;
        settingsPanel.add(resetTimePanel, gbcSettings);
        // Add configured tabs to the main tabbed pane
        tabbedPane.addTab("Main menu", mainPanel);
        tabbedPane.addTab("Behaviour settings", settingsPanel);
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
                SwingUtilities.updateComponentTreeUI(frame); // Dynamic UI refresh
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        southPanel.add(darkModeToggle, BorderLayout.WEST);
        southPanel.add(new JLabel("v1.0.0"), BorderLayout.EAST);
        this.frame.add(southPanel, BorderLayout.SOUTH);


        // Initialize background keyboard tracking
        GlobalKeyHandler.start(this.frame);













        this.frame.setVisible(true);

    }


}
