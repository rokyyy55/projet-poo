package examen;

public class Admin extends Modeluser {
    private roomreservation reservationManager;

    public Admin(String username, String password, roomreservation reservationManager) {
    	  super(username, password, null, 0); // Call to super constructor
        this.reservationManager = reservationManager;
    }

    // Method to add a room
    public void addRoom(room room, String clientId) {
        // Assuming you have a method to add a room in the roomreservation class
        reservationManager.addReservation(room, clientId);
        System.out.println("Room added successfully.");
    }

    // Method to modify a room
   
    // Method to delete a room
    public void deleteRoom(String clientId) {
        // Assuming you have a method to remove a room in the roomreservation class
        reservationManager.removeReservation(clientId);
        System.out.println("Room deleted successfully.");
    }
}
