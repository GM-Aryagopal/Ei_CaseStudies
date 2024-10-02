# Singleton Pattern Demo

## Overview
The **Singleton Pattern Demo** is a Java-based implementation of the Singleton design pattern. This program demonstrates how to ensure that a class has only one instance and provides a global point of access to it. In this example, we simulate a database connection using the Singleton pattern, ensuring that only one instance of the `DatabaseConnection` class is created.

## Features
- **Singleton Database Connection**: Ensures that only one instance of the database connection can exist at any given time.
- **User Interaction**: The program prompts the user to connect to the database and demonstrates the Singleton pattern in action.

## Components
- **DatabaseConnection Class**: A Singleton class that restricts the instantiation of itself to one instance and provides a global access point to it.
  - `getInstance()`: Returns the single instance of `DatabaseConnection`.
  - `connect()`: Simulates a database connection.

- **SingletonPatternDemo Class**: The main class that interacts with the user, allowing them to connect to the database or exit the program.

## Getting Started

Follow these steps to download and run the **Singleton Pattern Demo** on your local machine.

### Prerequisites
- Ensure you have the Java Development Kit (JDK) installed (version 8 or higher).

### Clone the Repository
1. Open your terminal.
2. Use the following command to clone the repository:
   ```bash
   git clone https://github.com/GM-Aryagopal/Ei_CaseStudies/tree/master/Ei_casestudy1/Creational_Design/Singleton_Pattern_Demo
3. Navigate into the cloned directory:
   ```bash
   cd Ei_casestudy1/Creational_Design/Singleton_Pattern_Demo
4. Compile the Java code using:
   ```bash
   javac SingletonPatternDemo.java
5. Execute the main class with:
   ```bash
   java SingletonPatternDemo
6. Follow the on-screen prompts to connect to the database or exit.