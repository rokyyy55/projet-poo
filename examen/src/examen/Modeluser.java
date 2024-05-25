package examen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Modeluser {
    private String username;
    private String password;
    private String clientId;
    private int days;

    public Modeluser(String username, String password, String clientId, int days) {
        this.username = username;
        this.password = password;
        this.clientId = clientId;
        this.days = days;
    }

    @Override
    public String toString() {
        return "Modeluser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", clientId='" + clientId + '\'' +
                ", days=" + days +
                '}';
    }

    public static void main(String[] args) {
        List<Modeluser> users = new ArrayList<>();
        roomreservation reservationManager = new roomreservation();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter your role (admin/client):");
            String role = scanner.nextLine();
            System.out.println("Please enter your username:");
            String username = scanner.nextLine();
            System.out.println("Please enter your password:");
            String password = scanner.nextLine();

            if (role.equalsIgnoreCase("admin")) {
                Admin admin = new Admin(username, password, reservationManager);
                users.add(admin);
                System.out.println("Admin added: " + admin);

                // Admin operations
                System.out.println("Would you like to manage rooms? (yes/no)");
                String manageRooms = scanner.nextLine();
                if (manageRooms.equalsIgnoreCase("yes")) {
                    System.out.println("Type 'add',  or 'delete' to manage rooms:");
                    String operation = scanner.nextLine();
                    System.out.println("Enter room number:");
                    int roomNumber = scanner.nextInt();
                    System.out.println("Enter room type (single/double):");
                    String roomType = scanner.nextLine();
                    room room = new room(roomNumber, roomType);

                    if (operation.equalsIgnoreCase("add")) {
                        System.out.println("Enter client ID:");
                        String clientId = scanner.nextLine();
                        admin.addRoom(room, clientId);
                    
                    } else if (operation.equalsIgnoreCase("delete")) {
                        System.out.println("Enter client ID:");
                        String clientId = scanner.nextLine();
                        admin.deleteRoom(clientId);
                    } else {
                        System.out.println("Invalid operation!");
                    }
                }
            } else if (role.equalsIgnoreCase("client")) {
                System.out.println("Generated Client ID: " + ClientIdGenerator.generateClientId());
                System.out.println("Please enter the number of days for your reservation:");
                int days = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                client client = new client(username, password, ClientIdGenerator.generateClientId(), days);
                users.add(client);
                System.out.println("Client added: " + client);
            } else {
                System.out.println("Invalid role!");
            }

            System.out.println("Do you want to add another user? (yes/no)");
            String continueInput = scanner.nextLine();
            if (!continueInput.equalsIgnoreCase("yes")) {
                break;
            }
        }

        // Print all users
        System.out.println("All users:");
        for (Modeluser user : users) {
            System.out.println(user);
        }
    }

    // Static inner class for generating client IDs
    public static class ClientIdGenerator {
        // Method to generate a unique ID for clients
        public static String generateClientId() {
            String clientId = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
            return clientId;
        }
    }
}
