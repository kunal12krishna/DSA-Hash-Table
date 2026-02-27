package P8_ParkingSystem;

public class ParkingLot {

    private String[] table;
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.table = new String[capacity];
    }

    // Hash function
    private int hash(String licensePlate) {
        return Math.abs(licensePlate.hashCode()) % capacity;
    }

    // Park vehicle
    public void parkVehicle(String licensePlate) {

        int index = hash(licensePlate);
        int startIndex = index;

        while (table[index] != null) {
            index = (index + 1) % capacity;

            if (index == startIndex) {
                System.out.println("Parking Full!");
                return;
            }
        }

        table[index] = licensePlate;
        System.out.println("Vehicle " + licensePlate +
                " parked at spot " + index);
    }

    // Exit vehicle
    public void exitVehicle(String licensePlate) {

        int index = hash(licensePlate);
        int startIndex = index;

        while (table[index] != null) {

            if (table[index].equals(licensePlate)) {
                table[index] = null;
                System.out.println("Vehicle " + licensePlate +
                        " exited from spot " + index);
                return;
            }

            index = (index + 1) % capacity;

            if (index == startIndex)
                break;
        }

        System.out.println("Vehicle not found!");
    }

    // Display parking statuspackage P8_ParkingSystem;
    //
    //public class Main {
    //
    //    public static void main(String[] args) {
    //
    //        ParkingLot lot = new ParkingLot(5);
    //
    //        lot.parkVehicle("ABC-123");
    //        lot.parkVehicle("XYZ-999");
    //        lot.parkVehicle("LMN-456");
    //
    //        lot.displayStatus();
    //
    //        lot.exitVehicle("XYZ-999");
    //
    //        lot.displayStatus();
    //    }
    //}
    public void displayStatus() {
        System.out.println("\nParking Status:");
        for (int i = 0; i < capacity; i++) {
            System.out.println("Spot " + i + ": " +
                    (table[i] == null ? "Empty" : table[i]));
        }
    }
}