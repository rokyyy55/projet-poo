package examen;

import javax.swing.*;

public class Controller {

    private RoomReservationGUI view;

    public void setView(RoomReservationGUI view) {
        this.view = view;
    }

    public boolean login(String username, String password, String role) {
        // You can implement your login logic here
        // For now, let's just validate based on the provided role and credentials

        if ("admin".equals(role) && "admin".equals(username) && "admin".equals(password)) {
            return true;
        } else if ("client".equals(role) && "client".equals(username) && "client".equals(password)) {
            return true;
        } else {
            return false;
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

    public void selectRoomType(String roomType) {
        // Handle room type selection here
        view.updateTextArea("Selected room type: " + roomType);
    }
}
