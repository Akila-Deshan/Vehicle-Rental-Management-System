public abstract class Vehicle {
    private final String vehicleId;
    private final String brand;
    private final String model;
    private final double baseRatePerDay;
    private boolean isAvailable;

    public Vehicle(String vehicleId, String brand, String model, double baseRatePerDay){
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.baseRatePerDay = baseRatePerDay;
        this.isAvailable = true;
    }

    public String getVehicleId(){
        return vehicleId;
    }
    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public double getBaseRatePerDay(){
        return baseRatePerDay;
    }
    public boolean getIsAvailable(){
        return isAvailable;
    }

    public abstract double calculateRentalCost(int days);

    public void rentVehicle(){
        if (isAvailable){
            isAvailable = false;
            System.out.println("Vehicle " + vehicleId + " has been rented.");
        }else{
            System.out.println("The vehicle is already rented");
        }
    }

    public void returnVehicle(){
        isAvailable = true;
        System.out.println("Vehicle " + vehicleId + " has been returned.");
    }

    public void displayDetails(){
        String status = isAvailable ? "Available" : "Rented";
        System.out.println("Id: " + vehicleId + " | " + brand + " " + model + " | Rate: Rs: " + baseRatePerDay + " day | Status: " + status);
    }
}
