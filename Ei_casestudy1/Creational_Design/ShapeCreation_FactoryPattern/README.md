# Factory Method Pattern Demo

## Overview
The **Factory Method Pattern Demo** is a Java-based implementation of the Factory Method design pattern. This program allows users to create different shapes (Circle or Square) dynamically by using a factory class. It demonstrates how the Factory Method pattern can be used to create objects without specifying the exact class of the object that will be created.

## Features
- **Dynamic Shape Creation**: Users can input a shape type (Circle or Square), and the program will create and draw the corresponding shape.
- **Factory Method**: The `ShapeFactory` class encapsulates the object creation logic, providing a flexible way to instantiate different shapes based on user input.

## Components
- **Shape Interface**: Defines the method `draw()` that must be implemented by all shape classes.
  - `draw()`: Displays the shape being drawn.

- **Circle Class**: A concrete implementation of the `Shape` interface that represents a Circle.
  
- **Square Class**: A concrete implementation of the `Shape` interface that represents a Square.

- **ShapeFactory Class**: The factory class responsible for creating instances of `Shape` objects.
  - `createShape(String shapeType)`: Takes the shape type as input and returns an instance of either `Circle` or `Square` based on the input.

- **FactoryMethodPatternDemo Class**: The main class that interacts with the user, allowing them to select a shape and demonstrating the use of the Factory Method pattern.

## Getting Started

Follow these steps to download and run the **Factory Method Pattern Demo** on your local machine.

### Prerequisites
- Ensure you have the Java Development Kit (JDK) installed (version 8 or higher).

### Clone the Repository
1. Open your terminal.
2. Use the following command to clone the repository:
   ```bash
   git clone https://github.com/GM-Aryagopal/Ei_CaseStudies/tree/master/Ei_casestudy1/Creational_Design/Factory_Method_Pattern_Demo
3. Navigate into the cloned directory:
   ```bash
   cd Ei_casestudy1/Creational_Design/Factory_Method_Pattern_Demo
4. Compile the Java code using:
   ```bash
   javac FactoryMethodPatternDemo.java
5. Execute the main class with:
   ```bash
   java FactoryMethodPatternDemo
6. Follow the on-screen prompts to create and draw a shape or exit the program.



