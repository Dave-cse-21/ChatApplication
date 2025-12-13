package chatapp.ui;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import chatapp.db.DBConnection;

public class RegisterWindow extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnRegister;

    public RegisterWindow() {
        setTitle("Register");
        setSize(350, 180);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(20, 20, 80, 25);
        add(lblUser);

        txtUsername = new JTextField();
        txtUsername.setBounds(100, 20, 200, 25);
        add(txtUsername);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(20, 60, 80, 25);
        add(lblPass);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(100, 60, 200, 25);
        add(txtPassword);

        btnRegister = new JButton("Register");
        btnRegister.setBounds(100, 100, 200, 25);
        add(btnRegister);

        btnRegister.addActionListener(e -> registerUser());

        setVisible(true);
    }

    private void registerUser() {
        String username = txtUsername.getText().trim();
        String password = String.valueOf(txtPassword.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill both fields!");
            return;
        }

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO users(username,password) VALUES(?,?)"
            );
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Registration successful!");
            new LoginWindow().setVisible(true); // move to login
            dispose();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    // Optional: for testing only
    public static void main(String[] args) {
        new RegisterWindow();
    }
}
