package examen;

public class View {

    private Controller controller;

    // Constructor that accepts a Controller instance
    public View(Controller controller) {
        this.controller = controller;
    }

    // Method to start the view
    public void start() {
        // Implement your view logic here
        System.out.println("View started.");
    }

    // Main method to run the application
    public static void main(String[] args) {
        Controller controller = new Controller();
        RoomReservationGUI gui = new RoomReservationGUI(controller);
        controller.setView(gui);

        gui.start(); // Start the GUI
    }
}
