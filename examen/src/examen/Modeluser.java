package examen;
import java.util.*;

public class Modeluser {
    String username;
    String password;
    boolean isAdmin;
    HashMap<String, String> Users; // Note: HashMap is uppercase, and Users is lowercase

    public Modeluser(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.Users = new HashMap<>(); // Initialize the HashMap
    }

    public boolean authenticate(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public void addUser(String username, String password) {
        Users.put(username, password);
    }
}
