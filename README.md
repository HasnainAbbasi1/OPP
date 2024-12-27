# Car Rental System

## Description
The Car Rental System is a Java-based application that implements Object-Oriented Programming (OOP) concepts to manage car rentals efficiently. It provides a graphical user interface (GUI) for users to reserve cars, view available cars, return cars, and generate bills. The project demonstrates the use of classes, inheritance, serialization, and event handling in Java.

## Features
- **User Management:**
  - Sign up and log in to access the system.
- **Car Inventory:**
  - View available cars for rental.
  - Search cars by model and specifications.
- **Reservation:**
  - Make reservations for available cars.
  - Save and retrieve reservation history.
- **Return Car:**
  - Process car returns with reservation verification.
- **Billing:**
  - Generate and display detailed invoices.
- **Company Policies:**
  - View terms and conditions for car rentals.
- **Data Persistence:**
  - Store and retrieve data using file I/O and serialization.

## Technologies Used
- **Programming Language:** Java
- **GUI Framework:** Swing
- **File Handling:** Serialization and text files
- **Concepts:** OOP (Inheritance, Polymorphism, Encapsulation)

## Project Structure
- **Classes:**
  - `Car`: Represents a car with attributes like model, brand, year, seating capacity, and rental rate.
  - `User`: Handles user-related information like name, username, and password.
  - `CarInventory`: Manages the list of cars and their availability.
  - `Welcome`, `UserMenu`, `SignUp`, `GUI`: Handles the GUI components.
  - `Reservation`, `Return_Car`, `Generate_Bill`: Manage reservations, returns, and billing processes.
- **Main Class:**
  - `carrental`: Initializes the system, populates the inventory, and launches the GUI.

