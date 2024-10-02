import java.io.*;
import java.net.*;

public class Client {

    private static Socket socket;
    private static BufferedReader reader;
    private static PrintWriter writer;

    public static void main(String[] args) {

        try {
            System.out.println("Attempting to connect to the server...");
            socket = new Socket("localhost", 1234);
            System.out.println("Connected to the chat server");

            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);

            // New thread to read messages from the server
            new ReadThread().start();

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String userInput;

            while ((userInput = consoleReader.readLine()) != null) {

                System.out.println("Sending user input: " + userInput);
                writer.println(userInput); // Send message or command to server

            }

        } catch (IOException ex) {

            System.out.println("Error connecting to the server: " + ex.getMessage());
            ex.printStackTrace();

        }
    }

    static class ReadThread extends Thread {

        public void run() {

            try {

                System.out.println("ReadThread started, waiting for server messages...");
                String serverMessage;

                while ((serverMessage = reader.readLine()) != null) {

                    System.out.println(serverMessage); // Display message from server

                }

            } catch (IOException ex) {

                System.out.println("Error reading from server: " + ex.getMessage());

            } finally {

                try {

                    System.out.println("Closing socket...");
                    socket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}