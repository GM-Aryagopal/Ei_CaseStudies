# Interactive News App

## Overview
The Interactive News App is a Java-based implementation of the Observer design pattern. It allows users to subscribe to a news channel and receive updates whenever new news is published. This app serves as a demonstration of how the Observer pattern can be utilized to manage subscribers and notifications in a simple news publishing system.

## Features
- Subscribe/Unsubscribe: Users can subscribe to or unsubscribe from the news channel.
- Publish News: Users can publish news updates that will be sent to all subscribers.
- Interactive Menu: A command-line interface that allows users to navigate the application easily.

## Components
- Subscriber Interface: Defines the method `update(String news)` that must be implemented by all subscribers to receive updates.
  
- NewsSubscriber Class: A concrete implementation of the `Subscriber` interface. It stores the subscriber's name and defines how the subscriber receives news updates.
  
- NewsPublisher Interface: Defines methods for subscribing, unsubscribing, and notifying subscribers.
  
- NewsChannel Class: A concrete implementation of the `NewsPublisher` interface. It manages a list of subscribers and notifies them of any news updates.
  
- InteractiveNewsApp Class: The main class that contains the user interface and controls the flow of the application.

## Getting Started

Follow these steps to download and run the Interactive News App on your local machine.

### Prerequisites
- Ensure you have the Java Development Kit (JDK) installed (version 8 or higher).

### Clone the Repository
1. Open your terminal.
2. Use the following command to clone the repository:
   ```bash
   git clone https://github.com/GM-Aryagopal/Ei_CaseStudies/tree/master/Ei_casestudy1/Behavioral_Design/News_notification_Observer
3. Navigate into the cloned directory
    cd Ei_casestudy1/Behavioral_Design/News_notification_Observer
4. Compile the java code using:
    javac InteractiveNewsApp.java
5. Execute the main class with:
    java InteractiveNewsApp
6. Follow the on-screen prompts to subscribe, unsubscribe, or publish news.

