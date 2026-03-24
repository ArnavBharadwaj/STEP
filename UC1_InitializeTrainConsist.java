import java.util.Scanner;

/**
 * UC1: Initialize Train and Display Consist Summary
 * 
 * Goal: Initialize the Train Consist Management App and display the initial
 * state of the train consist (engine + bogies).
 * 
 * Key Concepts:
 *   - Class and Object creation
 *   - Arrays for fixed-size bogie storage
 *   - Constructor initialization
 *   - Method invocation and encapsulation
 *   - Console I/O with Scanner
 */
public class UC1_InitializeTrainConsist {

    // --- Domain classes ---

    static class Bogie {
        String id;
        String type;       // Sleeper, AC Chair, First Class, Goods-Rect, Goods-Cyl
        int capacity;      // seats for passenger bogies, tonnage for goods
        String cargoType;  // only relevant for goods bogies

        Bogie(String id, String type, int capacity, String cargoType) {
            this.id = id;
            this.type = type;
            this.capacity = capacity;
            this.cargoType = cargoType;
        }

        @Override
        public String toString() {
            if (cargoType != null && !cargoType.isEmpty()) {
                return String.format("| %-8s | %-14s | Capacity: %-4d tons | Cargo: %-12s |",
                        id, type, capacity, cargoType);
            }
            return String.format("| %-8s | %-14s | Capacity: %-4d seats |                    |",
                    id, type, capacity);
        }
    }

    static class TrainConsist {
        String trainName;
        String engineId;
        Bogie[] bogies;
        int bogieCount;

        TrainConsist(String trainName, String engineId, int maxBogies) {
            this.trainName = trainName;
            this.engineId = engineId;
            this.bogies = new Bogie[maxBogies];
            this.bogieCount = 0;
        }

        void attachBogie(Bogie b) {
            if (bogieCount < bogies.length) {
                bogies[bogieCount++] = b;
                System.out.println("  [+] Attached bogie " + b.id + " (" + b.type + ")");
            } else {
                System.out.println("  [!] Cannot attach " + b.id + " — consist is full.");
            }
        }

        void displaySummary() {
            System.out.println("\n============================================================");
            System.out.println("        TRAIN CONSIST SUMMARY");
            System.out.println("============================================================");
            System.out.println("  Train Name : " + trainName);
            System.out.println("  Engine ID  : " + engineId);
            System.out.println("  Bogies     : " + bogieCount);
            System.out.println("------------------------------------------------------------");

            int totalSeats = 0;
            int totalTonnage = 0;

            for (int i = 0; i < bogieCount; i++) {
                System.out.println("  " + (i + 1) + ". " + bogies[i]);
                if (bogies[i].cargoType != null && !bogies[i].cargoType.isEmpty()) {
                    totalTonnage += bogies[i].capacity;
                } else {
                    totalSeats += bogies[i].capacity;
                }
            }

            System.out.println("------------------------------------------------------------");
            System.out.println("  Total Passenger Seats : " + totalSeats);
            System.out.println("  Total Cargo Tonnage   : " + totalTonnage + " tons");
            System.out.println("============================================================\n");
        }
    }

    // --- Main ---

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println(" TRAIN CONSIST MANAGEMENT APP v1.0");
        System.out.println("====================================");
        System.out.println("UC1: Initialize Train & Display Consist Summary\n");

        System.out.print("Enter train name: ");
        String trainName = sc.nextLine();

        System.out.print("Enter engine ID: ");
        String engineId = sc.nextLine();

        // Create train with capacity for 6 bogies
        TrainConsist train = new TrainConsist(trainName, engineId, 6);

        // Attach default bogies
        System.out.println("\n--- Attaching default bogies ---");
        train.attachBogie(new Bogie("B001", "Sleeper", 72, null));
        train.attachBogie(new Bogie("B002", "AC Chair", 64, null));
        train.attachBogie(new Bogie("B003", "First Class", 24, null));
        train.attachBogie(new Bogie("B004", "Goods-Rect", 50, "Coal"));
        train.attachBogie(new Bogie("B005", "Goods-Cyl", 30, "Petroleum"));

        // Display summary
        train.displaySummary();

        System.out.println("UC1 complete. Train initialized successfully.");
        sc.close();
    }
}
