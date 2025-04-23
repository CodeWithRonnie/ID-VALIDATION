package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ValidateSaId class.
 *
 * Following TDD: RED step - start with a failing test for valid IDs.
 */
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
}
