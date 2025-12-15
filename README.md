
# ChatApplication

## 1. Project Overview
ChatApplication is a Java desktop application that allows users to register, log in, and communicate with each other in real time. The system is built using a client-server architecture and provides a graphical user interface for ease of use.

---

## 2. Project Structure
The project is organized into packages based on responsibility.

### 2.1 Packages and Classes

#### Package: chatapp.ui
This package contains all graphical user interface (GUI) classes.

- LoginWindow  
  Responsible for user login. It collects username and password and verifies them using the database.

- RegisterWindow  
  Allows new users to create an account. User details are saved in the database.

- ChatWindow  
  Provides the main chat interface where users can send and receive messages.

---

#### Package: chatapp.db
This package handles database and client-side logic.

- DBConnection  
  Manages the connection between the application and the MySQL database using JDBC.

- ChatClient  
  Connects the client to the chat server using TCP sockets and handles sending and receiving messages.

---

## 3. Database Design
The project uses a MySQL database.

### Database Name
- chatapplication

### User Table
The user table stores login information.

Columns:
- id (INT, Primary Key)
- username (VARCHAR)
- password (VARCHAR)

The database is accessed using JDBC through the DBConnection class.

---

## 4. External Libraries (JAR Files)
The project uses the following external library:

- MySQL Connector/J  
  This JAR file enables Java to connect to the MySQL database using JDBC.

The JAR file is added to the project libraries in NetBeans.

---

## 5. Technologies Used
- Java
- Java Swing (GUI)
- TCP Sockets (Networking)
- Multithreading
- MySQL
- JDBC
- Git & GitHub

---

## 6. How to Run the Project

### Step 1: Database Setup
- Install MySQL Server
- Create the database and user table
- Update database credentials in DBConnection class

### Step 2: Add Library
- Add MySQL Connector/J JAR to the project libraries

### Step 3: Run Server
- Run the chat server class first

### Step 4: Run Client
- Run the ChatClient or LoginWindow class
- Register or log in
- Start chatting

---

## 7. How to Check the Project
- Successful login indicates database connection works
- Multiple clients chatting indicates networking and multithreading work
- Messages appearing in real time indicate socket communication is successful

---

