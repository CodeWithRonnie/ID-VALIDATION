package za.co.cascade;

public class ValidateSaIdWeb {
    public static boolean isIdNumberValid(String idNumber) {
        // Reuse the logic from your desktop app (can be refactored for sharing)
        if (idNumber == null || idNumber.length() != 13) return false;
        if (!idNumber.matches("\\d{13}")) return false;
        int month = Integer.parseInt(idNumber.substring(2, 4));
        int day = Integer.parseInt(idNumber.substring(4, 6));
        if (month < 1 || month > 12) return false;
        if (day < 1 || day > 31) return false;
        int genderDigits = Integer.parseInt(idNumber.substring(6, 10));
        if (genderDigits < 0 || genderDigits > 9999) return false;
        char citizenship = idNumber.charAt(10);
        if (citizenship != '0' && citizenship != '1') return false;
        int checkDigit = calculateCheckDigit(idNumber);
        return checkDigit == Integer.parseInt(idNumber.substring(12));
    }

    private static int calculateCheckDigit(String idNumber) {
        String digits = idNumber.substring(0, 12);
        int sum = 0;
        for (int i = 0; i < digits.length(); i += 2) {
            sum += Character.getNumericValue(digits.charAt(i));
        }
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
        int checkDigit = (10 - (sum % 10)) % 10;
        return checkDigit;
    }
}
