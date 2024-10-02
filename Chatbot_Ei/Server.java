import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static Set<Socket> clientSockets = new HashSet<>();
    private static Map<String, Set<Socket>> chatRooms = new HashMap<>();
    private static Map<Socket, String> clientNames = new HashMap<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                clientSockets.add(socket); // Keep track of the client sockets
                // Start a new thread for the client
                new ClientHandler(socket).start();
            }

        } catch (IOException ex) {
            System.out.println("Error in the server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter writer;
        private String currentRoom;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                System.out.println("Handling client: " + socket);
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                OutputStream output = socket.getOutputStream();
                writer = new PrintWriter(output, true);

                // Get the client's name
                writer.println("Enter your name: ");
                String clientName = reader.readLine();

                if (clientName == null || clientName.trim().isEmpty()) {
                    writer.println("Client name is null or empty. Connection closing.");
                    socket.close();
                    return;
                }

                synchronized (clientNames) {
                    if (clientNames.containsValue(clientName)) {
                        writer.println("This name is already taken. Connection closing.");
                        socket.close();
                        return;
                    }
                    clientNames.put(socket, clientName);
                }

                String serverMessage = "New user connected: " + clientName;
                System.out.println(serverMessage);

                while (true) {
                    writer.println(
                            "Enter a command (create/join <room_name>, list_active_users, private_msg <username> <message>, exit_room or exit): ");
                    String command = reader.readLine();

                    if (command.equalsIgnoreCase("exit")) {
                        break; // Exit the loop and disconnect
                    }

                    if (command.equalsIgnoreCase("list_active_users")) {
                        listActiveUsers(writer);
                        continue; // Return to command prompt after listing users
                    }

                    if (command.startsWith("private_msg ")) {
                        sendPrivateMessage(command, clientName);
                        continue; // Return to command prompt after sending a private message
                    }

                    if (command.equalsIgnoreCase("exit_room")) {
                        exitRoom(writer);
                        continue; // Return to command prompt after exiting room
                    }

                    String[] parts = command.split(" ");
                    if (parts.length < 2) {
                        writer.println("Invalid command. Please use create/join <room_name>.");
                        continue;
                    }

                    String action = parts[0].toLowerCase();
                    String roomName = parts[1];

                    if (action.equals("create")) {
                        createRoom(roomName);
                        writer.println("Room '" + roomName + "' created. You have joined it.");
                        joinRoom(roomName);
                        startListeningForMessages(reader); // Start listening for messages after joining
                    } else if (action.equals("join")) {
                        if (!joinRoom(roomName)) {
                            writer.println("Room '" + roomName + "' does not exist. Please try again.");
                        } else {
                            writer.println("You have joined room '" + roomName + "'.");
                            startListeningForMessages(reader); // Start listening for messages after joining
                        }
                    } else {
                        writer.println("Invalid command. Please use create/join <room_name>.");
                    }
                }

                // Clean up on disconnect
                synchronized (clientNames) {
                    clientNames.remove(socket);
                }

                socket.close();
                System.out.println(clientName + " disconnected.");

            } catch (IOException ex) {
                System.out.println("Error in ClientHandler: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        private void createRoom(String roomName) {
            synchronized (chatRooms) {
                chatRooms.putIfAbsent(roomName, new HashSet<>());
            }
            joinRoom(roomName); // Automatically join the room after creating it
        }

        private boolean joinRoom(String roomName) {
            synchronized (chatRooms) {
                if (!chatRooms.containsKey(roomName))
                    return false;

                if (currentRoom != null) { // Leave the previous room if any
                    chatRooms.get(currentRoom).remove(socket);
                    broadcastToRoom(currentRoom, "User left: " + clientNames.get(socket));
                }

                chatRooms.get(roomName).add(socket);
                currentRoom = roomName; // Set current room

                // Notify others in the room
                broadcastToRoom(roomName, "User joined: " + clientNames.get(socket));

                return true;
            }
        }

        private void startListeningForMessages(BufferedReader reader) throws IOException {
            String message;
            while ((message = reader.readLine()) != null && currentRoom != null) {

                // Check for exit_room before broadcasting
                if (!message.equalsIgnoreCase("exit_room")) {
                    broadcastToRoom(currentRoom, "[" + clientNames.get(socket) + "]: " + message);
                } else {
                    exitRoom(writer); // Call exit room method when exit_room is received
                    break; // Break out of the loop to stop listening for messages
                }
            }
        }

        private void broadcastToRoom(String roomName, String message) {
            Set<Socket> socketsInRoom = chatRooms.get(roomName);
            for (Socket clientSocket : socketsInRoom) {
                try {
                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                    writer.println(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void listActiveUsers(PrintWriter writer) {
            synchronized (clientNames) {
                writer.println("Active users:");
                for (String name : clientNames.values()) {
                    writer.println(name);
                }
            }
        }

        private void sendPrivateMessage(String command, String senderName) {
            String[] parts = command.split(" ", 3); // Split into 3 parts: command, username, message
            if (parts.length < 3) {
                return; // Invalid format
            }

            String recipientName = parts[1];
            String messageContent = parts[2];

            Socket recipientSocket = null;

            synchronized (clientNames) {
                for (Map.Entry<Socket, String> entry : clientNames.entrySet()) {
                    if (entry.getValue().equals(recipientName)) {
                        recipientSocket = entry.getKey();
                        break;
                    }
                }
            }

            if (recipientSocket != null) {
                try {
                    PrintWriter recipientWriter = new PrintWriter(recipientSocket.getOutputStream(), true);
                    recipientWriter.println("[Private from " + senderName + "]: " + messageContent);
                    writer.println("Private message sent to " + recipientName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                writer.println("User '" + recipientName + "' not found.");
            }
        }

        private void exitRoom(PrintWriter writer) {
            if (currentRoom != null) {
                chatRooms.get(currentRoom).remove(socket);
                broadcastToRoom(currentRoom, "User left: " + clientNames.get(socket));
                writer.println("You have exited the room '" + currentRoom + "'.");
                currentRoom = null; // Clear current room
            } else {
                writer.println("You are not currently in a room.");
            }
        }
    }
}