import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// The Observer Interface
interface Subscriber {
    void update(String news);
}

// Concrete Observer Class
class NewsSubscriber implements Subscriber {
    private String name;

    public NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news update: " + news);
    }

    @Override
    public String toString() {
        return name;
    }
}

// The Subject Interface
interface NewsPublisher {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers(String news);
}

// Concrete Subject Class
class NewsChannel implements NewsPublisher {
    private List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
        System.out.println(subscriber + " subscribed.");
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
        System.out.println(subscriber + " unsubscribed.");
    }

    @Override
    public void notifySubscribers(String news) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(news);
        }
    }
}

public class InteractiveNewsApp {
    public static void main(String[] args) {
        NewsChannel newsChannel = new NewsChannel();
        Scanner scanner = new Scanner(System.in);
        List<Subscriber> subscribers = new ArrayList<>();

        int option = 0; // To control the loop

        // Main menu loop controlled by user input, not while(true)
        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Subscribe a user");
            System.out.println("2. Unsubscribe a user");
            System.out.println("3. Publish news");
            System.out.println("4. Exit");

            // Ensure valid input by checking for integer
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                switch (option) {
                    case 1:
                        System.out.print("Enter the name of the user to subscribe: ");
                        String name = scanner.nextLine();
                        Subscriber subscriber = new NewsSubscriber(name);
                        subscribers.add(subscriber);
                        newsChannel.subscribe(subscriber);
                        break;

                    case 2:
                        System.out.print("Enter the name of the user to unsubscribe: ");
                        String unsubName = scanner.nextLine();
                        Subscriber toRemove = null;
                        for (Subscriber sub : subscribers) {
                            if (sub.toString().equalsIgnoreCase(unsubName)) {
                                toRemove = sub;
                                break;
                            }
                        }
                        if (toRemove != null) {
                            newsChannel.unsubscribe(toRemove);
                            subscribers.remove(toRemove);
                        } else {
                            System.out.println("Subscriber not found.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter news to publish: ");
                        String news = scanner.nextLine();
                        newsChannel.notifySubscribers(news);
                        break;

                    case 4:
                        System.out.println("Exiting the program...");
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        } while (option != 4);  // Exit the loop if the option is 4 (Exit)

        scanner.close();
    }
}
