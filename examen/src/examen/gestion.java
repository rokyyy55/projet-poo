package examen;
import java.util.*;


public class gestion {
    // Static inner class for generating client IDs
    public static class ClientIdGenerator {
        // Method to generate a unique ID for clients
    	public static String generateClientId() {
    	    String clientId = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
    	    return clientId;
    	}
    }

    public static void main(String[] args) {
        // Prompt the user to enter reservation details
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the hotel reservation system!");
        System.out.println("Please enter your username:");
        String username = scanner.nextLine();
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();
        System.out.println("Can you please tell us how we can help you:");
        System.out.println("Type: 'reserve', 'cancel', or 'change'");
        String operation = scanner.nextLine();

        String clientId = null;
        String startDate = null;
        String endDate = null;

        if (operation.equals("cancel") || operation.equals("change")) {
            // Generate a client ID
        	 System.out.println("Please enter your client ID:");
             clientId = scanner.nextLine();
             System.out.println("Please enter the start date of your reservation (format: yyyy-MM-dd):");
             startDate = scanner.nextLine();
             System.out.println("Please enter the end date of your reservation (format: yyyy-MM-dd):");
             endDate = scanner.nextLine();
        } else if (operation.equals("reserve")) {
            // Prompt the user to enter additional reservation details
        	  clientId = ClientIdGenerator.generateClientId();
              System.out.println("Generated Client ID: " + clientId);
              Client.idclient= clientId;
              System.out.println("can you tell us what time of room would you like to reserve:\t");
              System.out.println("choose: 'single'   'double'");
              String roomtype=scanner.nextLine();
              
              
              
             
         
        } else {
            System.out.println("Invalid operation!");
            // Handle invalid operation here, you can throw an exception or exit the program
            return;
        }

        // Create an instance for the client
        Client client = new Client(username, password, clientId, startDate, endDate);
        // Now you can use the 'client' object as needed
    }
}