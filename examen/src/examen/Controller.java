package examen;

import javax.swing.*;

public class Controller {

    private RoomReservationGUI view;

    public void setView(RoomReservationGUI view) {
        this.view = view;
    }

    public void login(String username, String password, String role) {
        // You can implement your login logic here
        // For now, let's just display a message in the GUI

        if (username.equals("admin") && password.equals("admin") && role.equals("admin")) {
            view.updateTextArea("Login successful as admin.");
        } else if (username.equals("client") && password.equals("client") && role.equals("client")) {
            view.updateTextArea("Login successful as client.");
        } else {
            view.updateTextArea("Invalid username, password, or role.");
        }
    }

    public void addReservation(String roomNumber, String clientId) {
        // Implement adding reservation logic here
        // For now, let's just display a message in the GUI
        view.updateTextArea("Adding reservation for room " + roomNumber + " with client ID " + clientId);
    }

    public void deleteReservation(String clientId) {
        // Implement deleting reservation logic here
        // For now, let's just display a message in the GUI
        view.updateTextArea("Deleting reservation for client ID " + clientId);
    }
}
