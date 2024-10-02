# Interactive Command Pattern Demo

## Overview
The Interactive Command Pattern Demo is a Java-based implementation of the Command design pattern. It demonstrates how to decouple the objects that send requests from the objects that execute these requests. In this example, we use a simple remote control to issue commands for turning on/off a light and a TV. The program allows the user to interact dynamically with the system through a command-line interface.

## Features
- Light Control: Users can turn the light on and off using the remote control.
- TV Control: Users can turn the TV on and off using the remote control.
- **Interactive Menu**: A command-line interface that allows users to easily issue commands through the remote control.

## Components
- Command Interface: Declares the method `execute()` that all commands must implement.

- **LightOnCommand / LightOffCommand Classes**: Concrete commands to turn the light on and off.

- **TVOnCommand / TVOffCommand Classes**: Concrete commands to turn the TV on and off.

- Light Class: A receiver class that defines the actual operations for turning a light on or off.

- TV Class: A receiver class that defines the actual operations for turning a TV on or off.

- RemoteControl Class: An invoker class that executes commands issued by the user.

- InteractiveCommandPatternDemo Class: The main class that provides a user interface and controls the flow of the application.

## Getting Started

Follow these steps to download and run the **Interactive Command Pattern Demo** on your local machine.

### Prerequisites
- Ensure you have the Java Development Kit (JDK) installed (version 8 or higher).

### Clone the Repository
1. Open your terminal.
2. Use the following command to clone the repository:
   ```bash
   git clone https://github.com/GM-Aryagopal/Ei_CaseStudies/tree/master/Ei_casestudy1/Behavioral_Design/Command_Pattern_Demo
3. Navigate into the cloned directory:
   cd Ei_casestudy1/Behavioral_Design/Command_Pattern_Demo
4. Compile the Java code using:
   javac InteractiveCommandPatternDemo.java
5. Execute the main class with:
   java InteractiveCommandPatternDemo
6. Follow the on-screen prompts to control the light or TV.
