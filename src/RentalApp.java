import java.util.ArrayList;
import java.util.Scanner;
public class RentalApp {
    // Vehicles stored in an ArrayList
    private static ArrayList<Vehicle> vehicleList = new ArrayList<>();
    // Track total income
    private static double totalRevenue = 0.0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        // Main menu loop
        while(true){
            System.out.println("\n=== Vehicle Rental Management System ===");
            System.out.println("1. Add a Vehicle");
            System.out.println("2. View All Vehicles");
            System.out.println("3. Rent a Vehicle");
            System.out.println("4. Return a Vehicle");
            System.out.println("5. Search Vehicle by ID");
            System.out.println("6. View Total Rental Income");
            System.out.println("7. Exit");
            System.out.println("8. Sort Vehicles by Rate (Special Feature!)");
            System.out.print("Enter your choice: ");

            // Handle invalid numeric inputs
            try{
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch(choice){
                    case 1:
                        addVehicle();
                        break;
                    case 2:
                        viewVehicles();
                        break;
                    case 3:
                        rentVehicle();
                        break;
                    case 4:
                        returnVehicle();
                        break;
                    case 5:
                        searchVehicle();
                        break;
                    case 6:
                        System.out.println("Total Rental Income: " + totalRevenue);
                        break;
                    case 7:
                        System.out.println("Goodbye!");
                        return;
                    case 8:
                        sortVehicles();
                        break;
                    // Stop invalid menu selections
                    default:
                        System.out.println("Invalid option try again!");
                }
            }catch(Exception e){
                // Meaningful error messages
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    // Helper method for find a vehicle by id this make the code cleaner and professional
    private static Vehicle findVehicle(String id){
        for (Vehicle v : vehicleList){
            if(v.getVehicleId().equalsIgnoreCase(id)){
                return v;
            }
        }
        return null;
    }

    // Method for add vehicle
    private static void addVehicle(){
        System.out.println("\nSelect Type: 1. Car | 2. Bike | 3. Van");
        try{
            int type = scanner.nextInt();
            scanner.nextLine();

            // Validate the type attribute
            if (type < 1 || type > 3){
                System.out.println("Invalid vehicle type!");
                return;
            }

            System.out.print("Enter ID: ");
            String id = scanner.nextLine();

            // Using findVehicle helper to check same id's
            if (findVehicle(id) != null){
                System.out.println("Error: ID already exists!");
                return;
            }

            System.out.print("Enter Brand: ");
            String brand = scanner.nextLine();
            System.out.print("Enter Model: ");
            String model = scanner.nextLine();
            System.out.print("Enter Base Rate: ");
            double rate = scanner.nextDouble();

            // Create specific objects based on user input
            switch (type){
                case 1:
                    System.out.print("Enter Seats: ");
                    int seats = scanner.nextInt();
                    vehicleList.add(new Car(id, brand, model, rate, seats));
                    break;
                case 2:
                    System.out.print("Enter CC: ");
                    int cc = scanner.nextInt();
                    vehicleList.add(new Bike(id, brand, model, rate, cc));
                    break;
                case 3:
                    System.out.print("Enter Cargo (Kg): ");
                    double kg = scanner.nextDouble();
                    vehicleList.add(new Van(id, brand, model, rate, kg));
                    break;
                default:
                    System.out.println("Invalid vehicle type!");
            }
            System.out.println("Vehicle added Successfully!");
        }catch (Exception e){
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
    }

    // Method for view vehicles
    private static void viewVehicles(){
        if(vehicleList.isEmpty()){
            System.out.println("No vehicles found!");
        }else{
            System.out.println("\n=== Vehicle List ===");
            // Demonstrate polymorphism
            for(Vehicle v : vehicleList){
                v.displayDetails();
            }
        }
    }

    // Method for rent vehicle
    private static void rentVehicle(){
        System.out.print("Enter Vehicle ID to Rent: ");
        String id = scanner.nextLine();

        Vehicle v = findVehicle(id);
        if (v == null){
            System.out.println("Vehicle not found!");
            return;
        }
        // Cannot rent if already rented
        if (!v.isAvailable()){
            System.out.println("Vehicle is already rented!");
            return;
        }

        System.out.print("Enter Days: ");

        try{
            int days = scanner.nextInt();
            scanner.nextLine();
            // Rental days must be > 0
            if(days <= 0){
                System.out.println("Days must be positive!");
                return;
            }

            // Polymorphic calculation
            double cost = v.calculateRentalCost(days);
            System.out.println("Total Cost: " + cost);

            System.out.print("Confirm rent? (yes/no): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("yes")){
                v.rentVehicle(); // Update status
                totalRevenue += cost; // Update revenue
            }else if(confirm.equalsIgnoreCase("No")){
                System.out.println("Rental cancelled!");
            }else{
                System.out.println("Invalid input try again!");
            }
        }catch (Exception e){
            System.out.println("Invalid Input!");
            scanner.nextLine();
        }
    }

    // Method for return vehicle
    private static void returnVehicle(){
        System.out.print("Enter Vehicle ID to return: ");
        String id = scanner.nextLine();
        Vehicle v = findVehicle(id);

        if (v != null){
            v.returnVehicle();
        }else{
            System.out.println("Vehicle not found");
        }
    }

    // Method for search vehicle
    private static void searchVehicle(){
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        Vehicle v = findVehicle(id);
        if (v != null){
            v.displayDetails();
        }else{
            System.out.println("Vehicle not found!");
        }
    }

    // Method to sort vehicles (Special Feature task 5.1)
    private static void sortVehicles(){
        if(vehicleList.isEmpty()){
            System.out.println("No vehicles to sort.");
            return;
        }
        int n = vehicleList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Get two adjacent vehicles
                Vehicle v1 = vehicleList.get(j);
                Vehicle v2 = vehicleList.get(j + 1);

                // Compare Base Rates and Swap
                if (v1.getBaseRatePerDay() > v2.getBaseRatePerDay()) {
                    vehicleList.set(j, v2);
                    vehicleList.set(j + 1, v1);
                }
            }
        }

        System.out.println("Vehicles sorted by Base Rate (Low -> High):");
        viewVehicles();
    }
}
