package examen;

import java.util.*;

public class roomreservation {
    LinkedHashMap<String, Integer> reservations; // Use LimitedHashMap instead of HashMap
    HashMap<String, Integer> clientSeconds; // HashMap to store client IDs with their corresponding seconds

    public roomreservation() {
        this.reservations = new LinkedHashMap<>(100);
        this.clientSeconds = new HashMap<>();
    }

    // Method to add a reservation
    public void addReservation(room room, String clientId) {
        // Check if the room number already exists in the reservations map
        if (reservations.containsKey(clientId)) {
            System.out.println("Room " + room.roomnum + " is already reserved.");
            System.out.println("You reserved the room number: " + room.roomnum);
            return; // Exit the method if the room is already reserved
        }

        // Add the reservation
        reservations.put(clientId, room.roomnum);
        System.out.println("Reservation added successfully for room " + room.roomnum);

        // Initialize client's seconds to 0
        clientSeconds.put(clientId, 0);
    }

    // Method to remove a reservation
    public void removeReservation(String clientId) {
        reservations.remove(clientId);
        clientSeconds.remove(clientId); // Remove client's seconds entry
    }

    // Method to get the room number for a given client ID
    public Integer getRoomNumberForClientId(String clientId) {
        return reservations.get(clientId);
    }

    // Method to count seconds and remove reservation
    public void countSeconds(int stopValue, String clientId) {
        int secondsElapsed = 0;
        while (secondsElapsed < stopValue) {
            System.out.println("Seconds elapsed: " + secondsElapsed);
            try {
                Thread.sleep(1000); // Pause for 1 second
            } catch (InterruptedException e) {
                System.out.println("Timer was interrupted.");
                return; // Exit the method if interrupted
            }
            secondsElapsed++;
            clientSeconds.put(clientId, secondsElapsed); // Update client's seconds
        }

        System.out.println("Timer stopped at " + stopValue + " seconds.");
        Integer roomNumber = getRoomNumberForClientId(clientId);
        if (roomNumber != null) {
            removeReservation(clientId);
        } else {
            System.out.println("No reservation found for client ID: " + clientId);
        }
    }

    // Method to get client ID for a given room
    public String getClientIdForRoom(room room) {
        for (Map.Entry<String, Integer> entry : reservations.entrySet()) {
            if (entry.getValue().equals(room.roomnum)) {
                return entry.getKey();
            }
        }
        return null;
    }

    // Method to get seconds for a given client ID
    public Integer getSecondsForClientId(String clientId) {
        return clientSeconds.get(clientId);
    }
}
