import java.util.Scanner;

// Component Interface
interface Coffee {
    String getDescription();
    double cost();
}

// Concrete Component
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 5.0;
    }
}

// Base Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public abstract String getDescription();
}

// Concrete Decorator for Milk
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return coffee.cost() + 1.0;
    }
}

// Concrete Decorator for Sugar
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.5;
    }
}

// Main class to demonstrate Decorator Pattern
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Start with a simple coffee
        Coffee coffee = new SimpleCoffee();
        System.out.println("You have ordered: " + coffee.getDescription());
        System.out.println("Cost: $" + coffee.cost());

        String choice;
        do {
            System.out.print("Would you like to add milk or sugar to your coffee? (milk/sugar/exit): ");
            choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("milk")) {
                coffee = new MilkDecorator(coffee);
            } else if (choice.equalsIgnoreCase("sugar")) {
                coffee = new SugarDecorator(coffee);
            } else if (!choice.equalsIgnoreCase("exit")) {
                System.out.println("Invalid option. Please choose 'milk', 'sugar', or 'exit'.");
            }
        } while (!choice.equalsIgnoreCase("exit"));

        System.out.println("\nFinal order: " + coffee.getDescription());
        System.out.println("Total cost: $" + coffee.cost());

        scanner.close();
    }
}
