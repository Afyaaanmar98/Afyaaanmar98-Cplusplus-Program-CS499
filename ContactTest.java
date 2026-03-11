/*************************
 * Name:    Afyaa 
 * Course:  CS-320 
 * Date:    May 14, 2025
 * Description: These are the unit tests I created for the Contact class to verify field constraints and null checks.
 *************************/

package Test;

import Contact.Contact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    /*
     * In this class, I tested that all input fields for the Contact class
     * respect the expected length constraints and that none of the fields
     * accept null values. I used assertThrows for cases where I expect an
     * exception to be thrown, and assertEquals/assertNotNull for validating
     * successful object creation.
     */

    @Test
    @DisplayName("Valid contact should be created without errors")
    void testValidContactCreation() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getNumber());
        assertEquals("123 Main St", contact.getAddress());
        assertNotNull(contact.getContactID());
    }

    @Test
    @DisplayName("Should throw exception when first name is too long")
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ThisIsWayTooLong", "Doe", "1234567890", "123 Main St")
        );
    }

    @Test
    @DisplayName("Should throw exception when last name is too long")
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("John", "ThisLastNameIsTooLong", "1234567890", "123 Main St")
        );
    }

    @Test
    @DisplayName("Should throw exception when phone number is not exactly 10 digits")
    void testPhoneNumberInvalidLength() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("John", "Doe", "123456789", "123 Main St")
        );
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("John", "Doe", "12345678901", "123 Main St")
        );
    }

    @Test
    @DisplayName("Should throw exception when address is too long")
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("John", "Doe", "1234567890", "This address is way too long to be valid in this test case, exceeding 30 characters.")
        );
    }

    @Test
    @DisplayName("Should throw exception when first name is null")
    void testFirstNameIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(null, "Doe", "1234567890", "123 Main St")
        );
    }

    @Test
    @DisplayName("Should throw exception when last name is null")
    void testLastNameIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("John", null, "1234567890", "123 Main St")
        );
    }

    @Test
    @DisplayName("Should throw exception when phone number is null")
    void testPhoneNumberIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("John", "Doe", null, "123 Main St")
        );
    }

    @Test
    @DisplayName("Should throw exception when address is null")
    void testAddressIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("John", "Doe", "1234567890", null)
        );
    }
}
