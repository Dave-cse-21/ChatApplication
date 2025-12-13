package chatapp.db;

import chatapp.ui.ChatWindow;
import java.io.*;
import java.net.*;

public class ChatClient {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private ChatWindow chatWindow;
    private String username;

    // Constructor accepts username
    public ChatClient(String username) {
        this.username = username;
        chatWindow = new ChatWindow(username);

        try {
            socket = new Socket("localhost", 5000);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println(username); // send username to server

            // Listen for messages from server
            new Thread(() -> {
                String message;
                try {
                    while ((message = in.readLine()) != null) {
                        chatWindow.appendMessage(message);
                    }
                } catch (IOException e) {
                    chatWindow.appendMessage("Disconnected from server.");
                }
            }).start();

            // Send message from GUI
            chatWindow.btnSend.addActionListener(e -> {
                String msg = chatWindow.txtMessage.getText().trim();
                if (!msg.isEmpty()) {
                    out.println(msg);
                    chatWindow.txtMessage.setText("");
                }
            });

        } catch (IOException e) {
            chatWindow.appendMessage("Unable to connect to server: " + e.getMessage());
        }
    }

    // Optional main for testing
    public static void main(String[] args) {
        new ChatClient("TestUser");
    }
}
