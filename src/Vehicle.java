public abstract class Vehicle {
    // Private attributes
    private String vehicleId;
    private String brand;
    private String model;
    private double baseRatePerDay;
    private boolean isAvailable;

    // Parameterized constructor
    public Vehicle(String vehicleId, String brand, String model, double baseRatePerDay){
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.baseRatePerDay = baseRatePerDay;
        this.isAvailable = true;
    }

    // Getter and Setter methods
    public String getVehicleId(){
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getBaseRatePerDay(){
        return baseRatePerDay;
    }

    public void setBaseRatePerDay(double baseRatePerDay) {
        this.baseRatePerDay = baseRatePerDay;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Concrete methods
    public void rentVehicle(){
        if (isAvailable){
            isAvailable = false;
            System.out.println("Vehicle " + vehicleId + " has been rented.");
        }else{
            System.out.println("The vehicle" + vehicleId + "is already rented");
        }
    }

    public void returnVehicle(){
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Vehicle " + vehicleId + " returned successfully.");
        } else {
            System.out.println("Vehicle " + vehicleId + " was not rented.");
        }
    }

    public void displayDetails(){
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Base Rate Per Day: Rs:" + baseRatePerDay);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);
}
