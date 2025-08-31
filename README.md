Java Calculator Project

This project is a simple calculator built in Java to demonstrate the concepts of object-oriented programming (OOP), especially inheritance and polymorphism.

The calculator is implemented in two different ways:

A terminal version (console-based).

A graphical version (GUI using Swing).

✨ Key Features

Inheritance: A base class (Calculator) defines the structure, while subclasses (Addition, Subtraction, Multiplication, Division) extend it to implement specific operations.

Polymorphism: Each operation class overrides the calculate() method in its own way.

Two interfaces:

CalculatorTest → a text-based terminal interface.

CalculatorGUI → a user-friendly graphical interface with buttons.

Error handling: Division by zero is caught and handled gracefully.

📂 Project Structure
Calculator.java        → Superclass (defines structure of a calculation)  
Addition.java          → Subclass (implements addition)  
Subtraction.java       → Subclass (implements subtraction)  
Multiplication.java    → Subclass (implements multiplication)  
Division.java          → Subclass (implements division, with zero-check)  
CalculatorTest.java    → Console-based calculator for testing in terminal  
CalculatorGUI.java     → Graphical interface calculator built with Swing  

🎯 Learning Goals

This project is designed to help practice:

Encapsulation: using fields and constructors.

Inheritance: sharing structure in a superclass, extending in subclasses.

Polymorphism: calling calculate() on different operation objects.

Separation of concerns: keeping the calculation logic separate from the interface (console or GUI).