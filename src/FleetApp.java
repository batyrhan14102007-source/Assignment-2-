import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FleetApp {

    private List<Vehicle> vehicles = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Choose option: ");

            switch (choice) {
                case 1 -> printAllVehicles();
                case 2 -> addCar();
                case 3 -> addBus();
                case 4 -> showTotalInsurance();
                case 5 -> showOlderThanN();
                case 6 -> serviceAll();
                case 7 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nFleet Management System");
        System.out.println("1. Print all vehicles");
        System.out.println("2. Add new car");
        System.out.println("3. Add new bus");
        System.out.println("4. Show total yearly insurance fees");
        System.out.println("5. Show vehicles older than N years");
        System.out.println("6. Perform service for all vehicles");
        System.out.println("7. Quit");
    }

    private void printAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet");
            return;
        }
        vehicles.forEach(System.out::println);
    }

    private void addCar() {
        System.out.print("Model: ");
        String model = scanner.nextLine();
        int year = readInt("Year: ");
        double price = readDouble("Base price: ");
        int doors = readInt("Number of doors: ");

        vehicles.add(new Car(model, year, price, doors));
        System.out.println("Car added");
    }

    private void addBus() {
        System.out.print("Model: ");
        String model = scanner.nextLine();
        int year = readInt("Year: ");
        double price = readDouble("Base price: ");
        int capacity = readInt("Passenger capacity: ");

        vehicles.add(new Bus(model, year, price, capacity));
        System.out.println("Bus added");
    }

    private void showTotalInsurance() {
        double total = 0;
        for (Vehicle v : vehicles) {
            total += v.calculateInsuranceFee();
        }
        System.out.println("Total insurance: " + total);
    }

    private void showOlderThanN() {
        int currentYear = readInt("Current year: ");
        int n = readInt("N years: ");

        for (Vehicle v : vehicles) {
            if (v.getAge(currentYear) > n) {
                System.out.println(v);
            }
        }
    }

    private void serviceAll() {
        for (Vehicle v : vehicles) {
            if (v instanceof Servicable s) {
                s.performService();
            }
        }
    }

    private int readInt(String msg) {
        System.out.print(msg);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Enter number: ");
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }

    private double readDouble(String msg) {
        System.out.print(msg);
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.print("Enter number: ");
        }
        double val = scanner.nextDouble();
        scanner.nextLine();
        return val;
    }
}
