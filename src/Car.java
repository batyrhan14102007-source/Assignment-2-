public class Car extends Vehicle implements Servicable {

    private int numberOfDoors;

    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public double calculateInsuranceFee() {
        return basePrice * 0.05 + numberOfDoors * 50;
    }

    @Override
    public void performService() {
        System.out.println("Car " + model + " is being serviced");
    }

    @Override
    public int getServiceIntervalKm() {
        return 10000;
    }

    @Override
    public String toString() {
        return "Car {" + super.toString() +
                ", doors=" + numberOfDoors + "}";
    }
}
