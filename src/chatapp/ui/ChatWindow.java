package chatapp.ui;

import javax.swing.*;

public class ChatWindow extends JFrame {

    private JTextArea textArea;
    public JTextField txtMessage;
    public JButton btnSend;

    // Constructor that accepts username
    public ChatWindow(String username) {
        setTitle("Chat - Logged in as: " + username);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBounds(20, 20, 440, 250);
        add(scroll);

        txtMessage = new JTextField();
        txtMessage.setBounds(20, 290, 340, 30);
        add(txtMessage);

        btnSend = new JButton("Send");
        btnSend.setBounds(370, 290, 90, 30);
        add(btnSend);

        setVisible(true);
    }

    // Method to append a message
    public void appendMessage(String message) {
        textArea.append(message + "\n");
    }

    public static void main(String[] args) {
        new ChatWindow("TestUser");
    }
}
