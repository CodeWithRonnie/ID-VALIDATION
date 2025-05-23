/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import java.util.Scanner;

/**
 * Simple command-line interface for testing SA ID validation.
 * Allows the user to enter an ID number and see if it's valid.
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("South African ID Number Validator");
        System.out.println("Enter 'exit' to quit.");
        while (true) {
            System.out.print("Enter SA ID number: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }
            boolean valid = ValidateSaId.isIdNumberValid(input);
            if (valid) {
                System.out.println("VALID: That is a valid South African ID number.\n");
            } else {
                System.out.println("INVALID: That is not a valid South African ID number.\n");
            }
        }
        scanner.close();
    }
}
