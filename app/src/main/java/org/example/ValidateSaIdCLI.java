package org.example;

public class ValidateSaIdCLI {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java org.example.ValidateSaIdCLI <SA_ID_NUMBER>");
            return;
        }
        String id = args[0];
        boolean valid = ValidateSaId.isIdNumberValid(id);
        if (valid) {
            System.out.println("Result: True (Valid SA ID number)");
        } else {
            System.out.println("Result: Failed (Invalid SA ID number)");
        }
    }
}
