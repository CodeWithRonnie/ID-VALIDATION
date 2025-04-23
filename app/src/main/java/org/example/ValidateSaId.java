package org.example;

/**
 * Utility class for validating South African ID numbers.
 * This class uses static methods only.
 */
public class ValidateSaId {
    /**
     * Checks if the given South African ID number is valid.
     *
     * @param idNumber the ID number to validate
     * @return true if valid, false otherwise
     */
    public static boolean isIdNumberValid(String idNumber) {
        // First, check if the ID is exactly 13 digits long
        if (idNumber == null || idNumber.length() != 13) {
            // If not, it's definitely not a valid SA ID
            return false;
        }
        // Next, check that all characters are numeric
        if (!idNumber.matches("\\d{13}")) {
            // If any character is not a digit, it's invalid
            return false;
        }
        // This part extracts date of birth
        int year = Integer.parseInt(idNumber.substring(0, 2));
        int month = Integer.parseInt(idNumber.substring(2, 4));
        int day = Integer.parseInt(idNumber.substring(4, 6));
        // Check for valid month (01-12)
        if (month < 1 || month > 12) {
            // Invalid month
            return false;
        }
        // Check for valid day (01-31)
        if (day < 1 || day > 31) {
            // Invalid day
            return false;
        }
        // Extract gender digits (SSSS)
        int genderDigits = Integer.parseInt(idNumber.substring(6, 10));
        if (genderDigits < 0 || genderDigits > 9999) {
            // SSSS must be between 0000 and 9999
            return false;
        }
        // Extract citizenship digit (C)
        char citizenship = idNumber.charAt(10);
        if (citizenship != '0' && citizenship != '1') {
            // Citizenship digit must be 0 (citizen) or 1 (permanent resident)
            return false;
        }
        // Calculate the check digit
        int checkDigit = calculateCheckDigit(idNumber);
        // Check if the check digit matches the last digit of the ID number
        if (checkDigit != Integer.parseInt(idNumber.substring(12))) {
            return false;
        }
        return true;
    }

    private static int calculateCheckDigit(String idNumber) {
        // Implements the Luhn algorithm for the first 12 digits
        String digits = idNumber.substring(0, 12);
        int sum = 0;
        // Step 1: Add digits in odd positions (1-based)
        for (int i = 0; i < digits.length(); i += 2) {
            sum += Character.getNumericValue(digits.charAt(i));
        }
        // Step 2: Concatenate even position digits, multiply by 2, sum digits
        StringBuilder evenDigits = new StringBuilder();
        for (int i = 1; i < digits.length(); i += 2) {
            evenDigits.append(digits.charAt(i));
        }
        int evenNumber = Integer.parseInt(evenDigits.toString());
        int evenProduct = evenNumber * 2;
        int evenSum = 0;
        for (char c : String.valueOf(evenProduct).toCharArray()) {
            evenSum += Character.getNumericValue(c);
        }
        sum += evenSum;
        // Step 3: Calculate check digit
        int checkDigit = (10 - (sum % 10)) % 10;
        return checkDigit;
    }
}
