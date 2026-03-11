/*************************
 * Name:    Afyaa  
 * Course:  CS-320 
 * Date:    June 2, 2025
 * Description: This is the AppointmentService class. It maintains appointments and provides 
 * functionality to add, update, and delete appointments using an in-memory list.
 *************************/

package Appointment;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {
    
    // In-memory storage for appointments
    private ArrayList<Appointment> appointmentList = new ArrayList<>();

    // Method to add a new appointment
    public void addAppointment(Date appointmentDate, String appointmentDesc) {
        Appointment appointment = new Appointment(appointmentDate, appointmentDesc);
        appointmentList.add(appointment);
    }

    // Method to retrieve an appointment by its ID
    public Appointment getAppointment(String appointmentID) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentID().equals(appointmentID)) {
                return appointment;
            }
        }
        return null; // Not found
    }

    // Method to delete an appointment by ID
    public void deleteAppointment(String appointmentID) {
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getAppointmentID().equals(appointmentID)) {
                appointmentList.remove(i);
                return;
            }
        }
        System.out.println("Appointment ID: " + appointmentID + " not found.");
    }

    // Method to update the date of an appointment by ID
    public void updateAppointmentDate(Date updatedDate, String appointmentID) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentID().equals(appointmentID)) {
                appointment.setAppointmentDate(updatedDate);
                return;
            }
        }
        System.out.println("Appointment ID: " + appointmentID + " not found.");
    }

    // Method to update the description of an appointment by ID
    public void updateAppointmentDesc(String updatedDesc, String appointmentID) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentID().equals(appointmentID)) {
                appointment.setAppointmentDesc(updatedDesc);
                return;
            }
        }
        System.out.println("Appointment ID: " + appointmentID + " not found.");
    }

    // Optional: Method to print all appointments for debugging
    public void displayAppointments() {
        for (Appointment appointment : appointmentList) {
            System.out.println("\tAppointment ID: " + appointment.getAppointmentID());
            System.out.println("\tAppointment Date: " + appointment.getAppointmentDate());
            System.out.println("\tAppointment Description: " + appointment.getAppointmentDesc());
        }
    }
}
