# Chat Application

## Overview
The **Chat Application** is a simple Java-based client-server program that allows multiple clients to connect and communicate with each other in chat rooms. This application demonstrates the use of socket programming to create a chat system where users can create rooms, join existing ones, send messages to all participants, and send private messages to specific users.

## Features
- **Client-Server Architecture**: The application follows a client-server model where multiple clients can connect to a central server.
- **Chat Rooms**: Users can create new chat rooms and join existing ones to communicate with each other.
- **Private Messaging**: Users can send private messages to other connected users.
- **Active Users List**: Users can list all currently active users in the chat.
- **Room Management**: Users can exit rooms and manage their chat experience.

## Components
### Client
- **Client Class**: Handles the connection to the server, user input, and message sending/receiving.
- **ReadThread Class**: A separate thread that listens for messages from the server and displays them.

### Server
- **Server Class**: Manages client connections, handles commands, and facilitates communication between clients.
- **ClientHandler Class**: A thread that manages communication with a single client, processes commands, and manages chat rooms.

## Getting Started

Follow these steps to download and run the **Chat Application** on your local machine.

### Prerequisites
- Ensure you have the Java Development Kit (JDK) installed (version 8 or higher).

### Clone the Repository
1. Open your terminal.
2. Use the following command to clone the repository:
   ```bash
   git clone https://github.com/GM-Aryagopal/Ei_CaseStudies/tree/master/Ei_casestudy1/Network_Programming/Chat_Application
3. Navigate into the cloned directory:
   ```bash
   cd Ei_casestudy1/Network_Programming/Chat_Application
4. Compile the server code using:
   ```bash
   javac Server.java
5. Start the server with:
   ```bash
   java Server
6. Open a new terminal window and navigate to the same directory.
   ```bash
   javac Client.java
7. Start the client with:
   ```bash
   java Client
8. Follow the on-screen prompts to enter your name and start chatting. You can create/join rooms,send messages,and perform other commands.
9. Commands:
   ```bash
   create <room_name>: Create a new chat room with the specified name.
   join <room_name>: Join an existing chat room.
   list_active_users: List all active users in the chat.
   private_msg <username> <message>: Send a private message to a specific user.
   exit_room: Exit the current chat room.
   exit: Disconnect from the chat server.

