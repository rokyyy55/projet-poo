package examen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomReservationGUI {

    private JFrame frame;
    private JTextArea textArea;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField roomNumberField;
    private JTextField clientIdField;

    private Controller controller;

    public RoomReservationGUI(Controller controller) {
        this.controller = controller;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("Room Reservation System");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        titleLabel.setBounds(180, 10, 250, 30);
        frame.getContentPane().add(titleLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 60, 80, 20);
        frame.getContentPane().add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(140, 60, 150, 20);
        frame.getContentPane().add(usernameField);
        usernameField.setColumns(10);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(300, 60, 80, 20);
        frame.getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(380, 60, 150, 20);
        frame.getContentPane().add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                controller.login(username, password);
            }
        });
        loginButton.setBounds(250, 100, 80, 30);
        frame.getContentPane().add(loginButton);

        JLabel roomNumberLabel = new JLabel("Room Number:");
        roomNumberLabel.setBounds(50, 150, 100, 20);
        frame.getContentPane().add(roomNumberLabel);

        roomNumberField = new JTextField();
        roomNumberField.setBounds(160, 150, 80, 20);
        frame.getContentPane().add(roomNumberField);
        roomNumberField.setColumns(10);

        JLabel clientIdLabel = new JLabel("Client ID:");
        clientIdLabel.setBounds(260, 150, 80, 20);
        frame.getContentPane().add(clientIdLabel);

        clientIdField = new JTextField();
        clientIdField.setBounds(350, 150, 150, 20);
        frame.getContentPane().add(clientIdField);
        clientIdField.setColumns(10);

        JButton addReservationButton = new JButton("Add Reservation");
        addReservationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String roomNumber = roomNumberField.getText();
                String clientId = clientIdField.getText();
                controller.addReservation(roomNumber, clientId);
            }
        });
        addReservationButton.setBounds(100, 200, 150, 30);
        frame.getContentPane().add(addReservationButton);

        JButton deleteReservationButton = new JButton("Delete Reservation");
        deleteReservationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String clientId = clientIdField.getText();
                controller.deleteReservation(clientId);
            }
        });
        deleteReservationButton.setBounds(280, 200, 150, 30);
        frame.getContentPane().add(deleteReservationButton);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50, 250, 500, 100);
        frame.getContentPane().add(scrollPane);

        frame.setVisible(true);
    }

    public void updateTextArea(String text) {
        textArea.append(text + "\n");
    }

    public void start() {
        // In this context, 'start' is a generic method name and does not need to be called
        // from outside the class in this specific example.
        // It could be used in more complex applications to initialize the GUI or the program itself.
        // But here, in this example, the GUI itself is initialized when the constructor is called.
    }
}
