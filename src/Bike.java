public class Bike extends Vehicle {
    // Additional attribute
    private int engineCapacityCC;

    // Constructor
    public Bike(String vehicleId, String brand, String model, double baseRatePerDay, int engineCapacityCC) {
        super(vehicleId, brand, model, baseRatePerDay);
        this.engineCapacityCC = engineCapacityCC;
    }

    // Getter and Setter
    public int getEngineCapacityCC() {
        return engineCapacityCC;
    }

    public void setEngineCapacityCC(int engineCapacityCC) {
        this.engineCapacityCC = engineCapacityCC;
    }

    // Override calculateRentalCost
    @Override
    public double calculateRentalCost(int days) {
        return (getBaseRatePerDay() * days) + (engineCapacityCC * 0.5 * days);
    }

    // Override displayDetails
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Vehicle Type: Bike");
        System.out.println("Engine Capacity: " + engineCapacityCC + " CC");
        System.out.println("------------------------");
    }
}
