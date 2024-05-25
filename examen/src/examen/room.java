package examen;


public class room {
     int roomnum;
     String roomtype;

    // Constructor
    public room(int roomnum, String roomtype) {
        this.roomnum = roomnum;
        this.roomtype = roomtype;
    }

    // Method to calculate price based on room type
    public int calculatePrice() {
        if (roomtype.equals("double")) {
            return 10000; // Double room price
        } else {
            return 6000; // Single room price
        }
    }

    // Getters and setters
   
    @Override
    public String toString() {
        return "Room{" +
                "roomnum=" + roomnum +
                ", roomtype='" + roomtype + '\'' +
                '}';
    }
}
