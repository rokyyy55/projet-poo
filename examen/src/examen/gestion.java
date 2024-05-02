package examen;
import java.util.*;


public class gestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// for the testing
		// if the client asks diffrent things 1 ask for a room reservation
		// crteate an instance for the client
		Scanner scanner =new Scanner(System.in);
		   // Prompt the user to enter reservation details
        System.out.println("Welcome to the hotel reservation system!");
        System.out.println("Please enter your username:");
        String username = scanner.nextLine();
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();
        System.out.println("Please enter your client ID:");
        String clientId = scanner.nextLine();
        System.out.println("Please enter the start date of your reservation (format: yyyy-MM-dd):");
        String startDate = scanner.nextLine();
        System.out.println("Please enter the end date of your reservation (format: yyyy-MM-dd):");
        String endDate = scanner.nextLine();

        // Create an instance for the client
        Client client = new Client(username, password, clientId, startDate, endDate);

		
		
	}

}
