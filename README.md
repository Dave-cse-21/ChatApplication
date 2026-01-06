//README for both chat application and RMICalculator projects respectively:

## Author

Name  -----------------           Dawit Eyasu 

Section  ------------------        3/5  

program -----------------           CSE  

ID NUMBER    ----------------          ugr/34206/16



# ChatApplication

 1. Project Overview
ChatApplication is a Java desktop application that allows users to register, log in, and communicate with each other in real time. The system is built using a client-server architecture and provides a graphical user interface for ease of use.


 2. Project Structure
The project is organized into packages based on responsibility.

 2.1 Packages and Classes

 Package: chatapp.ui
This package contains all graphical user interface (GUI) classes.

       - LoginWindow  
               Responsible for user login. It collects username and password and verifies them using the database.

       - RegisterWindow  
               Allows new users to create an account. User details are saved in the database.

       - ChatWindow  
               Provides the main chat interface where users can send and receive messages.

 Package: chatapp.db
This package handles database and client-side logic.

       - DBConnection  
                Manages the connection between the application and the MySQL database using JDBC.

       - ChatClient  
                Connects the client to the chat server using TCP sockets and handles sending and receiving messages.

3. Database Design
The project uses a MySQL database.

       *Database Name:chatapplication

       *User Table
               The user table stores login information.

               Columns:
                      - id (INT, Primary Key)
                      - username (VARCHAR)
                      - password (VARCHAR)

The database is accessed using JDBC through the DBConnection class.


4. External Libraries (JAR Files)
The project uses the following external library:

           - MySQL Connector/J  
                   This JAR file enables Java to connect to the MySQL database using JDBC.
                   The JAR file is added to the project libraries in NetBeans. 

5. Technologies Used
              - Java
              - Java Swing (GUI)
              - TCP Sockets (Networking)
              - Multithreading
              - MySQL
              - JDBC
              - Git & GitHub

6. How to Run the Project

    Step 1: Database Setup
- Install MySQL Server
- Create the database and user table
- Update database credentials in DBConnection class

    Step 2: Add Library
- Add MySQL Connector/J JAR to the project libraries
   
    Step 3: Run Server
- Run the chat server class first

    Step 4: Run Client
- Run the ChatClient or LoginWindow class
- Register or log in
- Start chatting

7. How to Check the Project
- Successful login indicates database connection works
- Multiple clients chatting indicates networking and multithreading work
- Messages appearing in real time indicate socket communication is successful







# RMI-Based Calculator Application

## Introduction
The RMI-Based Calculator Application is a simple Java project that demonstrates the use of Remote Method Invocation (RMI) for implementing a distributed calculator system. The application allows a client to remotely invoke arithmetic operations on a server.


## Project Objectives
- To understand Java RMI concepts
- To implement remote interfaces and remote objects
- To demonstrate client–server communication
- To perform arithmetic operations remotely


## Features
- Addition of numbers
- Subtraction of numbers
- Multiplication of numbers
- Division of numbers (with error handling)


## Technologies Used
- Programming Language: Java
- Distributed Technology: Java RMI
- IDE: NetBeans
- Java Version: JDK 8 or higher


## Project Structure
RMICalculator
├── src
│ └── calculator
│ ├── Calculator.java
│ ├── CalculatorImpl.java
│ ├── CalculatorServer.java
│ └── CalculatorClient.java
├── README.md
└── nbproject


## Component Description

### Calculator.java
Defines the remote interface and declares the arithmetic methods.

### CalculatorImpl.java
Implements the Calculator interface and provides the logic for arithmetic operations.

### CalculatorServer.java
Starts the RMI registry, creates the remote object, and binds it to the registry.

### CalculatorClient.java
Connects to the remote server, takes user input, invokes remote methods, and displays results.


## How to Run the Project

### Step 1: Start the Server
- Open the project in NetBeans
- Right-click `CalculatorServer.java`
- Select **Run File**
- Output:


### Step 2: Run the Client
- Right-click `CalculatorClient.java`
- Select **Run File**
- Enter two numbers
- Choose an operation
- View the result

> Note: The server must be running before starting the client.

## RMI Communication Flow
1. Client looks up the remote object
2. RMI registry locates the object
3. Client invokes remote methods
4. Server processes the request
5. Result is returned to the client

## Applications
- Academic laboratory exercises
- Learning distributed systems
- Understanding client–server architecture



sec 3/5
CSE
