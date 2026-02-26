VEHICLE RENTAL MANAGEMENT SYSTEM

Module: Object Oriented Programming (OOP)
Assignment: Vehicle Rental Management System


HOW TO COMPILE AND RUN THE PROGRAM


Step 1: Make sure Java JDK is installed.

Step 2: Open Command Prompt (CMD) in the project folder.

Step 3: Compile all Java files:
        javac *.java

Step 4: Run the program:
        java RentalApp


SYSTEM DESCRIPTION


This is a menu-driven Vehicle Rental Management System developed using Object-Oriented Programming concepts.

The system allows users to:

1. Add a Vehicle
2. View All Vehicles
3. Rent a Vehicle
4. Return a Vehicle
5. Search Vehicle by ID
6. View Total Rental Income
7. Exit
8. Sort Vehicles by Rate (Special Feature!)


OOP CONCEPTS USED


1. Abstraction:
   - Vehicle is an abstract class.
   - calculateRentalCost() is an abstract method.

2. Inheritance:
   - Car, Bike, and Van extend the Vehicle class.

3. Polymorphism:
   - Vehicles are stored in ArrayList<Vehicle>.
   - Overridden calculateRentalCost() method 
     is executed at runtime.

4. Encapsulation:
   - All attributes are private.
   - Getters and setters are used. (Task 1 Requirement).


ASSUMPTIONS MADE


- Vehicle IDs must be unique.
- Rental days must be greater than zero.
- A vehicle cannot be rented if already rented.


SAMPLE MENU USAGE


1. User selects "Add Vehicle" and add the vehicle details
2. View all added vehicles
3. User selects "Rent Vehicle" and enter the vehicle ID, days to rent that specific vehicle
4. Return the vehicle by adding the vehicle id of rented vehicle
5. Search the vehicle by adding vehicle ID you can see the availability of the vehicle by this
6. System shows total rental income by selecting view total rental income
7. User can exit from the application by selecting "Exit"
8. User can sort out the vehicles by the rate from using Sort vehicles by rate (Special Feature!)


Thank you.
