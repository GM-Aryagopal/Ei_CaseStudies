import java.util.Scanner;

// Command Interface
interface Command {
    void execute();
}

// Concrete Command for turning on a light
class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete Command for turning off a light
class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Concrete Command for turning on a TV
class TVOnCommand implements Command {
    TV tv;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }
}

// Concrete Command for turning off a TV
class TVOffCommand implements Command {
    TV tv;

    public TVOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }
}

// Receiver class for Light
class Light {
    public void turnOn() {
        System.out.println("The light is ON");
    }

    public void turnOff() {
        System.out.println("The light is OFF");
    }
}

// Receiver class for TV
class TV {
    public void turnOn() {
        System.out.println("The TV is ON");
    }

    public void turnOff() {
        System.out.println("The TV is OFF");
    }
}

// Invoker class - Remote control that can execute commands
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Main class to demonstrate Command Pattern with dynamic user interaction
public class InteractiveCommandPatternDemo {
    public static void main(String[] args) {
        // Create receiver objects
        Light light = new Light();
        TV tv = new TV();

        // Create command objects for Light and TV
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command tvOn = new TVOnCommand(tv);
        Command tvOff = new TVOffCommand(tv);

        // Create invoker (Remote Control)
        RemoteControl remote = new RemoteControl();
        Scanner scanner = new Scanner(System.in);
        
        int option = 0; // Control for menu
        do {
            // Display the menu for the user
            System.out.println("\n--- Remote Control Menu ---");
            System.out.println("1. Turn ON the Light");
            System.out.println("2. Turn OFF the Light");
            System.out.println("3. Turn ON the TV");
            System.out.println("4. Turn OFF the TV");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            // Check for valid input
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                
                switch (option) {
                    case 1:
                        remote.setCommand(lightOn);
                        remote.pressButton();
                        break;

                    case 2:
                        remote.setCommand(lightOff);
                        remote.pressButton();
                        break;

                    case 3:
                        remote.setCommand(tvOn);
                        remote.pressButton();
                        break;

                    case 4:
                        remote.setCommand(tvOff);
                        remote.pressButton();
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid option. Please choose between 1 and 5.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        } while (option != 5);  // Exit when user selects option 5

        scanner.close();
    }
}
