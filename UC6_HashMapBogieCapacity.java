import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * UC6: Bogie-Capacity Mapping Using HashMap
 * 
 * Goal: Associate each bogie with its seating or load capacity using
 * a key–value mapping structure.
 * 
 * Key Concepts:
 *   - HashMap – hash table based Map implementation storing key–value pairs
 *   - Map Interface – maps unique keys to corresponding values
 *   - put() – inserts a key–value pair (bogie name → capacity)
 *   - get() – retrieves value by key
 *   - entrySet() – provides a view of all entries for iteration
 *   - Key–value association for real-world attribute mapping
 *   - Fast O(1) lookup using keys
 */
public class UC6_HashMapBogieCapacity {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println(" TRAIN CONSIST MANAGEMENT APP v1.0");
        System.out.println("====================================");
        System.out.println("UC6: Bogie-Capacity Mapping with HashMap\n");

        // Step 1: Create a HashMap for bogie → capacity
        HashMap<String, Integer> bogieCapacity = new HashMap<>();

        // Step 2: Insert capacity values using put()
        System.out.println("--- Registering Bogie Capacities ---");

        bogieCapacity.put("Sleeper", 72);
        System.out.println("  [+] Sleeper       → 72 seats");

        bogieCapacity.put("AC Chair", 64);
        System.out.println("  [+] AC Chair      → 64 seats");

        bogieCapacity.put("First Class", 24);
        System.out.println("  [+] First Class   → 24 seats");

        bogieCapacity.put("Goods-Rect", 50);
        System.out.println("  [+] Goods-Rect    → 50 tons");

        bogieCapacity.put("Goods-Cyl", 30);
        System.out.println("  [+] Goods-Cyl     → 30 tons");

        bogieCapacity.put("Pantry Car", 0);
        System.out.println("  [+] Pantry Car    → 0 (service bogie)");

        // Step 3: Display all entries using entrySet()
        System.out.println("\n============================================================");
        System.out.println("        BOGIE CAPACITY REGISTER");
        System.out.println("============================================================");
        System.out.printf("  %-16s | %s%n", "BOGIE TYPE", "CAPACITY");
        System.out.println("  --------------------------------");

        int totalCapacity = 0;
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            String bogie = entry.getKey();
            int capacity = entry.getValue();
            String unit = bogie.startsWith("Goods") ? " tons" : " seats";
            if (capacity == 0) unit = " (service)";

            System.out.printf("  %-16s | %d%s%n", bogie, capacity, unit);
            totalCapacity += capacity;
        }

        System.out.println("  --------------------------------");
        System.out.println("  Total combined capacity: " + totalCapacity);
        System.out.println("============================================================");

        // Step 4: Fast lookup by key
        System.out.println("\n--- Fast Lookup Demo ---");
        String[] lookups = {"Sleeper", "AC Chair", "Executive"};
        for (String key : lookups) {
            Integer cap = bogieCapacity.get(key);
            if (cap != null) {
                System.out.println("  Capacity of " + key + ": " + cap);
            } else {
                System.out.println("  " + key + ": NOT FOUND in register.");
            }
        }

        // Step 5: Update a capacity (overwrite with put)
        System.out.println("\n--- Updating Capacity ---");
        System.out.println("  Sleeper capacity before update: " + bogieCapacity.get("Sleeper"));
        bogieCapacity.put("Sleeper", 80);
        System.out.println("  Sleeper capacity after update : " + bogieCapacity.get("Sleeper"));

        // Step 6: Check existence with containsKey / containsValue
        System.out.println("\n--- Existence Checks ---");
        System.out.println("  containsKey('First Class')  : " + bogieCapacity.containsKey("First Class"));
        System.out.println("  containsKey('Executive')    : " + bogieCapacity.containsKey("Executive"));
        System.out.println("  containsValue(64)           : " + bogieCapacity.containsValue(64));
        System.out.println("  containsValue(100)          : " + bogieCapacity.containsValue(100));

        // Step 7: Remove an entry
        System.out.println("\n--- Removing Bogie ---");
        Integer removedCap = bogieCapacity.remove("Pantry Car");
        if (removedCap != null) {
            System.out.println("  [-] Removed Pantry Car (was: " + removedCap + ")");
        }

        // Step 8: Interactive mode
        System.out.println("\n--- Interactive Mode ---");
        System.out.println("Commands: add <bogie> <cap>, get <bogie>, remove <bogie>, list, exit");

        while (true) {
            System.out.print("\n> ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("list")) {
                System.out.println("  Current mappings:");
                for (Map.Entry<String, Integer> e : bogieCapacity.entrySet()) {
                    System.out.println("    " + e.getKey() + " → " + e.getValue());
                }
                System.out.println("  Total entries: " + bogieCapacity.size());
            } else if (input.toLowerCase().startsWith("add ")) {
                try {
                    String rest = input.substring(4).trim();
                    int lastSpace = rest.lastIndexOf(' ');
                    String name = rest.substring(0, lastSpace).trim();
                    int cap = Integer.parseInt(rest.substring(lastSpace + 1).trim());
                    bogieCapacity.put(name, cap);
                    System.out.println("  [+] " + name + " → " + cap);
                } catch (Exception e) {
                    System.out.println("  [!] Usage: add <bogie_name> <capacity>");
                }
            } else if (input.toLowerCase().startsWith("get ")) {
                String name = input.substring(4).trim();
                Integer cap = bogieCapacity.get(name);
                if (cap != null) {
                    System.out.println("  " + name + " → " + cap);
                } else {
                    System.out.println("  [!] " + name + " not found.");
                }
            } else if (input.toLowerCase().startsWith("remove ")) {
                String name = input.substring(7).trim();
                if (bogieCapacity.remove(name) != null) {
                    System.out.println("  [-] Removed: " + name);
                } else {
                    System.out.println("  [!] " + name + " not found.");
                }
            } else {
                System.out.println("  Unknown command.");
            }
        }

        // Final state
        System.out.println("\n--- Final Capacity Register ---");
        for (Map.Entry<String, Integer> e : bogieCapacity.entrySet()) {
            System.out.printf("  %-16s → %d%n", e.getKey(), e.getValue());
        }

        System.out.println("\nUC6 complete. HashMap bogie-capacity mapping demonstrated.");
        sc.close();
    }
}
