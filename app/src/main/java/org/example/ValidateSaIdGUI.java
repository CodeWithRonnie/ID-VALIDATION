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
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Enter SA ID number: "));
        idInputField = new JTextField(18);
        inputPanel.add(idInputField);
        JButton validateButton = new JButton("Validate");
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
        // Start the GUI
        SwingUtilities.invokeLater(() -> {
            new ValidateSaIdGUI().setVisible(true);
        });
    }
}
