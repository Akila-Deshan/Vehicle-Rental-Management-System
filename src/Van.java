public class Van extends Vehicle {
    private double cargoCapacityKg;

    public Van(String vehicleId, String brand, String model, double baseRatePerDay, double cargoCapacityKg) {
        super(vehicleId, brand, model, baseRatePerDay);
        this.cargoCapacityKg = cargoCapacityKg;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getBaseRatePerDay() * days) + (cargoCapacityKg * 0.2 * days);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("   Type: Van | Cargo: " + cargoCapacityKg + "Kg");
        System.out.println("------------------------------------------------");
    }
}
