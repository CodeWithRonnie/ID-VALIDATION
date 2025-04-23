package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ValidateSaIdTest {
    // Test with valid South African ID numbers (should return true)
    @Test
    void testValidIdNumbers() {
        // These are valid sample IDs from the specification
        assertTrue(ValidateSaId.isIdNumberValid("2001014800086"), "ID 2001014800086 should be valid");
        assertTrue(ValidateSaId.isIdNumberValid("2909035800085"), "ID 2909035800085 should be valid");
    }

    @Test
    void testIdTooShort() {
        // Test with an ID that's too short (less than 13 digits)
        // Should return false because a valid SA ID must be exactly 13 digits
        assertFalse(ValidateSaId.isIdNumberValid("123456789012"), "ID with 12 digits should be invalid");
        assertFalse(ValidateSaId.isIdNumberValid("123"), "ID with 3 digits should be invalid");
    }

    @Test
    void testIdTooLong() {
        // Test with an ID that's too long (more than 13 digits)
        // Should return false because a valid SA ID must be exactly 13 digits
        assertFalse(ValidateSaId.isIdNumberValid("20010148000867"), "ID with 14 digits should be invalid");
        assertFalse(ValidateSaId.isIdNumberValid("200101480008600"), "ID with 15 digits should be invalid");
    }

    @Test
    void testIdWithNonNumericCharacters() {
        // Test with IDs that contain non-numeric characters
        // Should return false because all characters must be digits
        assertFalse(ValidateSaId.isIdNumberValid("20010A4800086"), "ID with a letter should be invalid");
        assertFalse(ValidateSaId.isIdNumberValid("29090358@0085"), "ID with a symbol should be invalid");
    }

    @Test
    void testInvalidDateOfBirth() {
        // Test with impossible month (e.g., 13)
        assertFalse(ValidateSaId.isIdNumberValid("9913994800086"), "ID with month 13 should be invalid");
        // Test with impossible day (e.g., 32)
        assertFalse(ValidateSaId.isIdNumberValid("9902324800086"), "ID with day 32 should be invalid");
        // Test with month 00 (invalid)
        assertFalse(ValidateSaId.isIdNumberValid("9900004800086"), "ID with month 00 should be invalid");
        // Test with day 00 (invalid)
        assertFalse(ValidateSaId.isIdNumberValid("9902004800086"), "ID with day 00 should be invalid");
    }

    @Test
    void testInvalidGenderDigits() {
        // Gender digits (SSSS): 0000-4999 = female, 5000-9999 = male
        // Test with SSSS out of range (e.g., 10000)
        assertFalse(ValidateSaId.isIdNumberValid("9001011000086"), "ID with SSSS=10000 should be invalid");
        assertFalse(ValidateSaId.isIdNumberValid("90010199998A6"), "ID with SSSS=99998 (too long) should be invalid");
    }

    @Test
    void testInvalidCitizenshipDigit() {
        // Citizenship digit should be  (C): 0 = SA citizen, 1 = permanent resident
        // Test with C not 0 or 1
        assertFalse(ValidateSaId.isIdNumberValid("9001014800286"), "ID with citizenship digit 2 should be invalid");
        assertFalse(ValidateSaId.isIdNumberValid("9001014800986"), "ID with citizenship digit 9 should be invalid");
    }
}
