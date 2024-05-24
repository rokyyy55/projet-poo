package examen;
import java.util.*;
import examen.room;
import examen.roomreservation;
public class Modeluser {
 
	 String username;
	    String password;

	    public Modeluser(String username, String password) {
	        this.username = username;
	        this.password = password;
	    }
	}

	// Subclass for administrators
	class Admin extends Modeluser {
	    public Admin(String username, String password) {
	        super(username, password);
	    }
	    roomreservation reservationManager;

	    public Admin(String username, String password, roomreservation reservationManager) {
	        super(username, password);
	        this.reservationManager = reservationManager;
	    }

	    // Method to add a room
	    public void addRoom(room roomNumber, int clientId ) {
	        // Assuming you have a method to add a room in the roomreservation class
	        reservationManager.addReservation(roomNumber, clientId);
	        System.out.println("Room added successfully.");
	    }

	    // Method to modify a room
	   
	    public void modifyRoom(room roomNumber, int clientId ) {
	        // Assuming you have a method to modify a room in the roomreservation class
	        reservationManager.addReservation(roomNumber, clientId);
	        System.out.println("Room modified successfully.");
	    }

	    // Method to delete a room
	    public void deleteRoom(room roomNumber) {
	        // Assuming you have a method to remove a room in the roomreservation class
	        reservationManager.removeReservation(roomNumber);
	        System.out.println("Room deleted successfully.");
	    }
	    
	}

	// Subclass for clients
	class Client extends Modeluser {
		String idclient;
		int days;
	    public Client(String username, String password,String idclient,int days) {
	        super(username, password);
	        this.idclient=idclient;
	        this.days=days;
	        
	        
	        
	        
	    }

	    // Add additional methods specific to clients if needed
	


		
	}

