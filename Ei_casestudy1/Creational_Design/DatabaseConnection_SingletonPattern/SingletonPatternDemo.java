import java.util.Scanner;

// Singleton Class
class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        // Private constructor to prevent instantiation
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to the database.");
    }
}

// Main class to demonstrate Singleton Pattern
public class SingletonPatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 'connect' to connect to the database or 'exit' to quit: ");
        
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("connect")) {
            DatabaseConnection dbConnection = DatabaseConnection.getInstance();
            dbConnection.connect();
        } else {
            System.out.println("Exiting...");
        }

        scanner.close();
    }
}
