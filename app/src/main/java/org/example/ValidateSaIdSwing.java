package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValidateSaIdSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("SA ID Validator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 180);
        frame.setLocationRelativeTo(null);

        JLabel instructionLabel = new JLabel("Enter South African ID Number:");
        JTextField idInput = new JTextField(15);
        JButton validateButton = new JButton("Validate");
        JLabel resultLabel = new JLabel("");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.add(instructionLabel);
        panel.add(idInput);
        panel.add(validateButton);
        panel.add(resultLabel);

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idInput.getText();
                boolean isValid = ValidateSaId.isIdNumberValid(id);
                if (isValid) {
                    resultLabel.setText("Valid SA ID Number!");
                    resultLabel.setForeground(new Color(0, 128, 0));
                } else {
                    resultLabel.setText("Invalid SA ID Number.");
                    resultLabel.setForeground(Color.RED);
                }
            }
        });

        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
