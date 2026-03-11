/*************************
 * Name:    Afyaa 
 * Course:  CS-320 
 * Date:    June 2, 2025
 * Description: This is the test class for AppointmentService.
 *************************/

package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;
import Appointment.AppointmentService;

class AppointmentServiceTest {

    // Helper method to generate a future date
    private Date getFutureDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    @Test
    @DisplayName("Test to update appointment date")
    void testUpdateAppointmentDate() {
        AppointmentService service = new AppointmentService();
        Date originalDate = getFutureDate(2026, Calendar.JANUARY, 1);
        Date updatedDate = getFutureDate(3022, Calendar.FEBRUARY, 2);

        service.addAppointment(originalDate, "Initial Description");
        String id = service.appointmentList.get(0).getAppointmentID();

        service.updateAppointmentDate(updatedDate, id);
        assertEquals(updatedDate, service.getAppointment(id).getAppointmentDate(), "Appointment date was not updated.");
    }

    @Test
    @DisplayName("Test to update appointment description")
    void testUpdateAppointmentDesc() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(getFutureDate(2026, Calendar.MARCH, 5), "Original Description");
        String id = service.appointmentList.get(0).getAppointmentID();

        service.updateAppointmentDesc("Updated Description", id);
        assertEquals("Updated Description", service.getAppointment(id).getAppointmentDesc(), "Appointment description was not updated.");
    }

    @Test
    @DisplayName("Test to delete an appointment")
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(getFutureDate(2026, Calendar.APRIL, 10), "Description to delete");
        String id = service.appointmentList.get(0).getAppointmentID();

        service.deleteAppointment(id);
        assertTrue(service.appointmentList.isEmpty(), "Appointment was not deleted.");
    }

    @Test
    @DisplayName("Test to add an appointment")
    void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(getFutureDate(2026, Calendar.MAY, 20), "New Appointment");

        assertEquals(1, service.appointmentList.size(), "Appointment was not added.");
        assertNotNull(service.appointmentList.get(0).getAppointmentID(), "Appointment ID was null.");
    }
}
