/*************************
 * Name:    Afyaa
 * Course:  CS-320
 * Date:    May 14, 2025
 * Description: These are the unit tests I wrote for the ContactService class. 
 * I tested the ability to add, update, and delete contacts using the service methods.
 *************************/

package Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import Contact.Contact;
import Contact.ContactService;

@TestMethodOrder(OrderAnnotation.class)
public class ContactServiceTest {

    /*
     * In this class, I tested the functionality of the ContactService.
     * I added a contact, then performed different updates (first name, last name, 
     * phone number, and address) using the service methods. I also verified that 
     * contacts can be added and deleted correctly.
     * 
     * I used the @Order annotation to ensure consistent test execution and 
     * contact indexing. In my implementation, contact IDs are assigned sequentially, 
     * starting from 0.
     */

    @Test
    @DisplayName("Should add a contact successfully")
    @Order(1)
    void testAddContact() {
        ContactService service = new ContactService();
        service.addContact("John", "Doe", "1234567890", "123 Main St");
        assertNotNull(service.getContact("0"), "Contact was not added successfully.");
    }

    @Test
    @DisplayName("Should update first name")
    @Order(2)
    void testUpdateFirstName() {
        ContactService service = new ContactService();
        service.addContact("Jane", "Doe", "1234567890", "456 Elm St");
        service.updateFirstName("Aisha", "0");
        assertEquals("Aisha", service.getContact("0").getFirstName(), "First name was not updated.");
    }

    @Test
    @DisplayName("Should update last name")
    @Order(3)
    void testUpdateLastName() {
        ContactService service = new ContactService();
        service.addContact("Ali", "Smith", "1234567890", "789 Oak St");
        service.updateLastName("Johnson", "0");
        assertEquals("Johnson", service.getContact("0").getLastName(), "Last name was not updated.");
    }

    @Test
    @DisplayName("Should update phone number")
    @Order(4)
    void testUpdatePhoneNumber() {
        ContactService service = new ContactService();
        service.addContact("Fatima", "Khan", "1111111111", "135 Pine St");
        service.updateNumber("9999999999", "0");
        assertEquals("9999999999", service.getContact("0").getNumber(), "Phone number was not updated.");
    }

    @Test
    @DisplayName("Should update address")
    @Order(5)
    void testUpdateAddress() {
        ContactService service = new ContactService();
        service.addContact("Sam", "Lee", "2222222222", "246 Cedar St");
        service.updateAddress("1010 Maple Ave", "0");
        assertEquals("1010 Maple Ave", service.getContact("0").getAddress(), "Address was not updated.");
    }

    @Test
    @DisplayName("Should delete contact")
    @Order(6)
    void testDeleteContact() {
        ContactService service = new ContactService();
        service.addContact("Zara", "Ali", "3333333333", "369 Birch St");
        service.deleteContact("0");
        assertNull(service.getContact("0"), "Contact was not deleted.");
    }
}
