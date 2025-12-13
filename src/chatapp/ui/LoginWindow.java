package chatapp.ui;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import chatapp.db.DBConnection;
import chatapp.db.ChatClient;

public class LoginWindow extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnRegister;

    public LoginWindow() {
        setTitle("Login");
        setSize(350, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Username label & text field
        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(20, 20, 80, 25);
        add(lblUser);

        txtUsername = new JTextField();
        txtUsername.setBounds(100, 20, 200, 25);
        add(txtUsername);

        // Password label & text field
        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(20, 60, 80, 25);
        add(lblPass);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(100, 60, 200, 25);
        add(txtPassword);

        // Login button
        btnLogin = new JButton("Login");
        btnLogin.setBounds(100, 100, 90, 25);
        add(btnLogin);

        // Register button
        btnRegister = new JButton("Register");
        btnRegister.setBounds(210, 100, 90, 25);
        add(btnRegister);

        // Action for login button
        btnLogin.addActionListener(e -> loginUser());

        // Action for register button
        btnRegister.addActionListener(e -> {
            new RegisterWindow().setVisible(true);
            dispose();
        });

        setVisible(true);
    }

    private void loginUser() {
        String username = txtUsername.getText().trim();
        String password = String.valueOf(txtPassword.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill both fields!");
            return;
        }

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM users WHERE username=? AND password=?"
            );
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                // Open ChatClient with this username
                new ChatClient(username); 
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    // Optional main for testing
    public static void main(String[] args) {
        new LoginWindow();
    }
}
