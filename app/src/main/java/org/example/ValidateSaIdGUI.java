package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple GUI for validating South African ID numbers using Swing.
 * Enter an ID number and click Validate to see if it's valid.
 */
public class ValidateSaIdGUI extends JFrame {
    private JTextField idInputField;
    private JLabel resultLabel;

    public ValidateSaIdGUI() {
        setTitle("South African ID Validator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 180);
        setLocationRelativeTo(null); // Center window
        setLayout(new BorderLayout(10, 10));

        // Create input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputPanel.add(new JLabel("Enter SA ID number: "));
        idInputField = new JTextField(18);
        inputPanel.add(idInputField);
        JButton validateButton = new JButton("Check"); // Make button more visible and clear
        validateButton.setPreferredSize(new Dimension(80, 30));
        inputPanel.add(validateButton);

        // Result label
        resultLabel = new JLabel(" ");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setFont(resultLabel.getFont().deriveFont(Font.BOLD, 14f));

        add(inputPanel, BorderLayout.NORTH);
        add(resultLabel, BorderLayout.CENTER);

        // Button action
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idInputField.getText().trim();
                boolean valid = ValidateSaId.isIdNumberValid(id);
                if (valid) {
                    resultLabel.setForeground(new Color(0, 128, 0)); // Green
                    resultLabel.setText("VALID: That is a valid South African ID number.");
                } else {
                    resultLabel.setForeground(Color.RED);
                    resultLabel.setText("INVALID: That is not a valid South African ID number.");
                }
            }
        });
    }

    public static void main(String[] args) {
        // Set Nimbus look and feel for modern appearance
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, fall back to default
        }
        // Start the GUI
        SwingUtilities.invokeLater(() -> {
            ValidateSaIdGUI frame = new ValidateSaIdGUI();
            frame.pack(); // Size window to fit all components
            frame.setMinimumSize(new Dimension(420, 220)); // Ensure enough height
            frame.setVisible(true);
        });
    }
}
