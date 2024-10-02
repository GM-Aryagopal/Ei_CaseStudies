import java.util.Scanner;

// Shape Interface
interface Shape {
    void draw();
}

// Concrete Class for Circle
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle.");
    }
}

// Concrete Class for Square
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square.");
    }
}

// Shape Factory Class
class ShapeFactory {
    public Shape createShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("square")) {
            return new Square();
        }
        return null;
    }
}

// Main class to demonstrate Factory Method Pattern
public class FactoryMethodPatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the shape you want to create (Circle/Square) or 'exit' to quit: ");
        
        String shapeType = scanner.nextLine();

        if (!shapeType.equalsIgnoreCase("exit")) {
            ShapeFactory shapeFactory = new ShapeFactory();
            Shape shape = shapeFactory.createShape(shapeType);

            if (shape != null) {
                shape.draw();
            } else {
                System.out.println("Invalid shape type.");
            }
        } else {
            System.out.println("Exiting...");
        }

        scanner.close();
    }
}
