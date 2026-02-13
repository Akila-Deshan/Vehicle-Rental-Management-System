public class Car extends Vehicle {
    // Additional attribute
    private int numberOfSeats;

    // Constructor
    public Car(String vehicleId, String brand, String model, double baseRatePerDay, int numberOfSeats) {
        super(vehicleId, brand, model, baseRatePerDay);
        this.numberOfSeats = numberOfSeats;
    }

    // Getter and Setter
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    // Override calculateRentalCost
    @Override
    public double calculateRentalCost(int days) {
        return (getBaseRatePerDay() * days) + (numberOfSeats * 200 * days);
    }

    // Override displayDetails
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Vehicle Type: Car");
        System.out.println("Number of Seats: " + numberOfSeats);
        System.out.println("------------------------");
    }
}