/*************************
 * Name:    Afyaa  
 * Course:  CS-320 
 * Date:    June 2, 2025
 * Description: This is the Appointment class. It creates and manages appointment information,
 *              including unique ID, valid future date, and a short description.
 *************************/

package Appointment;

import java.util.concurrent.atomic.AtomicLong;
import java.util.Calendar;
import java.util.Date;

public class Appointment {
    private final String appointmentID;
    private Date appointmentDate;
    private String appointmentDesc;
    private static AtomicLong idGenerator = new AtomicLong();

    /**
     * Constructor that initializes the appointment with a unique ID, future date, and description.
     * The appointment ID is automatically generated and cannot be changed.
     * The date must not be in the past and cannot be null.
     * The description must be non-null and less than or equal to 50 characters.
     */
    @SuppressWarnings("deprecation")
    public Appointment(Date appointmentDate, String appointmentDesc) {
        // Generate a unique, final appointment ID
        this.appointmentID = String.valueOf(idGenerator.getAndIncrement());

        // Validate date
        if (appointmentDate == null) {
            this.appointmentDate = new Date(2022, Calendar.JANUARY, 1);
        } else if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be in the past.");
        } else {
            this.appointmentDate = appointmentDate;
        }

        // Validate description
        if (appointmentDesc == null || appointmentDesc.isEmpty()) {
            this.appointmentDesc = "NULL";
        } else if (appointmentDesc.length() > 50) {
            this.appointmentDesc = appointmentDesc.substring(0, 50);
        } else {
            this.appointmentDesc = appointmentDesc;
        }
    }

    // GETTERS

    /** Returns the unique appointment ID. */
    public String getAppointmentID() {
        return appointmentID;
    }

    /** Returns the appointment date. */
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    /** Returns the appointment description. */
    public String getAppointmentDesc() {
        return appointmentDesc;
    }

    // SETTERS

    /**
     * Updates the appointment date if it's not in the past and not null.
     * Throws IllegalArgumentException if invalid.
     */
    @SuppressWarnings("deprecation")
    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null) {
            this.appointmentDate = new Date(2022, Calendar.JANUARY, 1);
        } else if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be in the past.");
        } else {
            this.appointmentDate = appointmentDate;
        }
    }

    /**
     * Updates the appointment description.
     * If the description is too long, it is truncated to 50 characters.
     * If null or empty, it is replaced with "NULL".
     */
    public void setAppointmentDesc(String appointmentDesc) {
        if (appointmentDesc == null || appointmentDesc.isEmpty()) {
            this.appointmentDesc = "NULL";
        } else if (appointmentDesc.length() > 50) {
            this.appointmentDesc = appointmentDesc.substring(0, 50);
        } else {
            this.appointmentDesc = appointmentDesc;
        }
    }
}

