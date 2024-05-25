package examen;

import javax.swing.SwingUtilities;

public class Controller {

    private RoomReservationGUI view;

    public void setView(RoomReservationGUI view) {
        this.view = view;
    }

    public void login(String username, String password) {
        // You can implement your login logic here
        // For now, let's just display a message in the GUI

        if (username.equals("admin") && password.equals("admin")) {
            updateTextArea("Login successful as admin.");
        } else if (username.equals("client") && password.equals("client")) {
            updateTextArea("Login successful as client.");
        } else {
            updateTextArea("Invalid username or password.");
        }
    }

    public void addReservation(String roomNumber, String clientId) {
        // Implement adding reservation logic here
        // For now, let's just display a message in the GUI
        updateTextArea("Adding reservation for room " + roomNumber + " with client ID " + clientId);
    }

    public void deleteReservation(String clientId) {
        // Implement deleting reservation logic here
        // For now, let's just display a message in the GUI
        updateTextArea("Deleting reservation for client ID " + clientId);
    }

    private void updateTextArea(String text) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                view.updateTextArea(text);
            }
        });
    }
}
