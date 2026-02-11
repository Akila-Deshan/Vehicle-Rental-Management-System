import java.util.ArrayList;
import java.util.Scanner;
public class RentalApp {
    private static ArrayList<Vehicle> vehicleList = new ArrayList<>();
    private static double totalRevenue = 0.0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

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
                    default:
                        System.out.println("Invalid option try again!");
                }
            }catch(Exception e){
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    private static Vehicle findVehicle(String id){
        for (Vehicle v : vehicleList){
            if(v.getVehicleId().equalsIgnoreCase(id)){
                return v;
            }
        }
        return null;
    }

    private static void addVehicle(){
        System.out.println("\nSelect Type: 1. Car | 2. Bike | 3. Van");
        try{
            int type = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter ID: ");
            String id = scanner.nextLine();
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

    private static void viewVehicles(){
        if(vehicleList.isEmpty()){
            System.out.println("No vehicles found!");
        }else{
            System.out.println("\n=== Vehicle List ===");
            for(Vehicle v : vehicleList){
                v.displayDetails();
            }
        }
    }

    private static void rentVehicle(){
        System.out.print("Enter Vehicle ID to Rent: ");
        String id = scanner.nextLine();

        Vehicle v = findVehicle(id);
        if (v == null){
            System.out.println("Vehicle not found!");
            return;
        }
        if (!v.isAvailable()){
            System.out.println("Vehicle is already rented!");
            return;
        }

        System.out.print("Enter Days: ");

        try{
            int days = scanner.nextInt();
            scanner.nextLine();
            if(days <= 0){
                System.out.println("Days must be positive!");
                return;
            }

            double cost = v.calculateRentalCost(days);
            System.out.println("Total Cost: " + cost);

            System.out.print("Confirm rent? (yes/no): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("yes")){
                v.rentVehicle();
                totalRevenue += cost;
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

    private static void sortVehicles(){
        if(vehicleList.isEmpty()){
            System.out.println("No vehicles to sort.");
            return;
        }
        int n = vehicleList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Vehicle v1 = vehicleList.get(j);
                Vehicle v2 = vehicleList.get(j + 1);

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
