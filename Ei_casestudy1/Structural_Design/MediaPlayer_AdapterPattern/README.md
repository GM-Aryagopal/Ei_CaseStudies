# Decorator Pattern Demo

## Overview
The **Decorator Pattern Demo** is a Java-based implementation of the Decorator design pattern. This program simulates a coffee ordering system where users can dynamically add milk and sugar to their coffee. It demonstrates how the Decorator pattern can be used to add functionality to objects dynamically without altering the original class.

## Features
- **Dynamic Add-Ons**: Users can start with a simple coffee and dynamically add milk or sugar to their coffee order.
- **Cost Calculation**: Each addition (milk or sugar) increases the total cost of the coffee.
- **Decorator Pattern**: This pattern allows you to add new functionality to objects at runtime without modifying their structure.

## Components
- **Coffee Interface**: Defines the basic methods `getDescription()` and `cost()` that must be implemented by all coffee classes.
  - `getDescription()`: Returns the description of the coffee.
  - `cost()`: Returns the cost of the coffee.

- **SimpleCoffee Class**: A concrete implementation of the `Coffee` interface that represents a basic coffee.
  
- **CoffeeDecorator Class**: An abstract base decorator class that implements the `Coffee` interface and holds a reference to a `Coffee` object. This class is extended by concrete decorators to add specific functionality.

- **MilkDecorator Class**: A concrete decorator that adds milk to the coffee and increases the cost.
  
- **SugarDecorator Class**: A concrete decorator that adds sugar to the coffee and increases the cost.

- **DecoratorPatternDemo Class**: The main class that interacts with the user, allowing them to add milk or sugar to their coffee and calculating the final cost.

## Getting Started

Follow these steps to download and run the **Decorator Pattern Demo** on your local machine.

### Prerequisites
- Ensure you have the Java Development Kit (JDK) installed (version 8 or higher).

### Clone the Repository
1. Open your terminal.
2. Use the following command to clone the repository:
   ```bash
   git clone https://github.com/GM-Aryagopal/Ei_CaseStudies/tree/master/Ei_casestudy1/Structural_Design/Decorator_Pattern_Demo
3. Navigate into the cloned directory:
   ```bash
   cd Ei_casestudy1/Structural_Design/Decorator_Pattern_Demo
4. Compile the Java code using:
   ```bash
   javac DecoratorPatternDemo.java
5. Execute the main class with:
   ```bash
   java DecoratorPatternDemo
6. Follow the on-screen prompts to add milk or sugar to your coffee or exit the program.
   

