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
}
