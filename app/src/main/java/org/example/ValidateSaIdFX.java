package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ValidateSaIdFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SA ID Validator");

        Label instructionLabel = new Label("Enter South African ID Number:");
        TextField idInput = new TextField();
        Button validateButton = new Button("Validate");
        Label resultLabel = new Label();

        validateButton.setOnAction(e -> {
            String id = idInput.getText();
            boolean isValid = ValidateSaId.isIdNumberValid(id);
            if (isValid) {
                resultLabel.setText("Valid SA ID Number!");
            } else {
                resultLabel.setText("Invalid SA ID Number.");
            }
        });

        VBox vbox = new VBox(10, instructionLabel, idInput, validateButton, resultLabel);
        vbox.setPadding(new Insets(20));
        Scene scene = new Scene(vbox, 350, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
