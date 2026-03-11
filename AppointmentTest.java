/*************************
 * Name:    Afyaa 
 * Course:  CS-320 
 * Date:    June 2, 2025
 * Description: This is the test class for Appointment. It validates the Appointment class 
 * functionality including ID length, date validity, and description constraints.
 *************************/

package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Calendar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;

class AppointmentTest {

    // Helper method to create future date for testing
    private Date getFutureDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 5); // 5 days in the future
        return cal.getTime();
    }

    @Test
    @DisplayName("Appointment ID should not exceed 10 characters")
    void testAppointmentIDMaxLength() {
        Appointment appointment = new Appointment(getFutureDate(), "Test Description");
        assertTrue(appointment.getAppointmentID().length() <= 10, "Appointment ID has more than 10 characters.");
    }

    @Test
    @DisplayName("Appointment Description should be truncated to 50 characters")
    void testAppointmentDescMaxLength() {
        String longDescription = "123456789-123456789-123456789-123456789-123456789-EXTRA";
        Appointment appointment = new Appointment(getFutureDate(), longDescription);
        assertTrue(appointment.getAppointmentDesc().length() <= 50, "Appointment description exceeds 50 characters.");
    }

    @Test
    @DisplayName("Appointment Date must not be in the past")
    void testAppointmentDateInPast() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -5); // 5 days in the past
        Date pastDate = cal.getTime();
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(pastDate, "Description");
        }, "Allowed appointment date to be in the past.");
    }

    @Test
    @DisplayName("Appointment Date must not be null")
    void testAppointmentDateNotNull() {
        Appointment appointment = new Appointment(null, "Valid Description");
        assertNotNull(appointment.getAppointmentDate(), "Appointment date is null.");
    }

    @Test
    @DisplayName("Appointment Description must not be null")
    void testAppointmentDescNotNull() {
        Appointment appointment = new Appointment(getFutureDate(), null);
        assertNotNull(appointment.getAppointmentDesc(), "Appointment description is null.");
    }
}
