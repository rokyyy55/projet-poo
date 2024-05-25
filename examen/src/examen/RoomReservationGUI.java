package examen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomReservationGUI {

    private JFrame frame;
    private JTextArea textArea;
    private JTextField roomNumberField;
    private JTextField clientIdField;

    private Controller controller;

    public RoomReservationGUI(Controller controller) {
        this.controller = controller;
        initializeLoginFrame();
    }

    private void initializeLoginFrame() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Room Reservation System");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        titleLabel.setBounds(115, 11, 233, 22);
        panel.add(titleLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(60, 66, 76, 14);
        panel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(146, 63, 130, 20);
        panel.add(usernameField);
        usernameField.setColumns(10);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(60, 105, 76, 14);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(146, 102, 130, 20);
        panel.add(passwordField);

        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setBounds(60, 144, 46, 14);
        panel.add(roleLabel);

        JComboBox<String> roleComboBox = new JComboBox<>();
        roleComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"admin", "client"}));
        roleComboBox.setBounds(146, 141, 130, 20);
        panel.add(roleComboBox);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String role = (String) roleComboBox.getSelectedItem();
                login(username, password, role);
            }
        });
        loginButton.setBounds(156, 185, 89, 23);
        panel.add(loginButton);

        frame.setVisible(true);
    }

    public void showMainGUI() {
        JFrame mainFrame = new JFrame();
        mainFrame.setBounds(100, 100, 600, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("Room Reservation System");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        titleLabel.setBounds(180, 10, 250, 30);
        mainFrame.getContentPane().add(titleLabel);

        roomNumberField = new JTextField();
        roomNumberField.setBounds(160, 150, 80, 20);
        mainFrame.getContentPane().add(roomNumberField);
        roomNumberField.setColumns(10);

        clientIdField = new JTextField();
        clientIdField.setBounds(350, 150, 150, 20);
        mainFrame.getContentPane().add(clientIdField);
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
        mainFrame.getContentPane().add(addReservationButton);

        JButton deleteReservationButton = new JButton("Delete Reservation");
        deleteReservationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String clientId = clientIdField.getText();
                controller.deleteReservation(clientId);
            }
        });
        deleteReservationButton.setBounds(280, 200, 150, 30);
        mainFrame.getContentPane().add(deleteReservationButton);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50, 250, 500, 100);
        mainFrame.getContentPane().add(scrollPane);

        mainFrame.setVisible(true);
    }

    public void updateTextArea(String text) {
        if (textArea != null) {
            textArea.append(text + "\n");
        } else {
            System.err.println("Error: textArea is null.");
        }
    }

    public void start() {
        showMainGUI();
    }

    private void login(String username, String password, String role) {
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Username and password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (role.equals("admin") && username.equals("admin") && password.equals("admin")) {
            showMainGUI();
            frame.dispose();
            controller.login(username, password, role);
        } else if (role.equals("client") && username.equals("client") && password.equals("client")) {
            showMainGUI();
            frame.dispose();
            controller.login(username, password, role);
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid username or password for the selected role.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        RoomReservationGUI gui = new RoomReservationGUI(controller);
        controller.setView(gui);
    }
}
