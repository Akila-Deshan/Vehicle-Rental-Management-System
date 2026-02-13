public class Van extends Vehicle {
    // Additional attribute
    private double cargoCapacityKg;

    // Constructor
    public Van(String vehicleId, String brand, String model, double baseRatePerDay, double cargoCapacityKg) {
        super(vehicleId, brand, model, baseRatePerDay);
        this.cargoCapacityKg = cargoCapacityKg;
    }

    // Getter and Setter
    public double getCargoCapacityKg() {
        return cargoCapacityKg;
    }

    public void setCargoCapacityKg(double cargoCapacityKg) {
        this.cargoCapacityKg = cargoCapacityKg;
    }

    // Override calculateRentalCost
    @Override
    public double calculateRentalCost(int days) {
        return (getBaseRatePerDay() * days) + (cargoCapacityKg * 0.2 * days);
    }

    // Override displayDetails
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Vehicle Type: Van");
        System.out.println("Cargo Capacity: " + cargoCapacityKg + " KG");
        System.out.println("------------------------");
    }
}
