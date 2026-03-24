import java.util.ArrayList;
import java.util.Scanner;

/**
 * UC2: Dynamic Insertion and Removal of Passenger Bogies Using ArrayList
 * 
 * Goal: Allow dynamic insertion and removal of passenger bogies using ArrayList.
 * 
 * Key Concepts:
 *   - ArrayList – resizable collection for insertion and deletion at runtime
 *   - add() – inserts elements into the list
 *   - remove() – deletes elements from the list
 *   - contains() – checks whether a given element exists
 *   - Insertion order preservation
 *   - CRUD operations on collections
 */
public class UC2_ArrayListBogieManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println(" TRAIN CONSIST MANAGEMENT APP v1.0");
        System.out.println("====================================");
        System.out.println("UC2: Dynamic Bogie Management with ArrayList\n");

        // Step 1: Create an ArrayList for passenger bogies
        ArrayList<String> passengerBogies = new ArrayList<>();

        // Step 2: Add bogies — Sleeper, AC Chair, First Class
        System.out.println("--- Adding Passenger Bogies ---");
        passengerBogies.add("Sleeper");
        System.out.println("  [+] Added: Sleeper");
        passengerBogies.add("AC Chair");
        System.out.println("  [+] Added: AC Chair");
        passengerBogies.add("First Class");
        System.out.println("  [+] Added: First Class");

        // Step 3: Print the list after insertion
        System.out.println("\nCurrent Consist (after insertion):");
        System.out.println("  " + passengerBogies);
        System.out.println("  Total bogies: " + passengerBogies.size());

        // Step 4: Remove a bogie (AC Chair)
        System.out.println("\n--- Removing Bogie ---");
        String bogieToRemove = "AC Chair";
        boolean removed = passengerBogies.remove(bogieToRemove);
        if (removed) {
            System.out.println("  [-] Removed: " + bogieToRemove);
        } else {
            System.out.println("  [!] " + bogieToRemove + " not found in consist.");
        }

        // Step 5: Use contains() to check if Sleeper exists
        System.out.println("\n--- Checking Bogie Existence ---");
        String bogieToCheck = "Sleeper";
        if (passengerBogies.contains(bogieToCheck)) {
            System.out.println("  [✓] " + bogieToCheck + " is attached to the train.");
        } else {
            System.out.println("  [✗] " + bogieToCheck + " is NOT in the consist.");
        }

        // Also check the removed bogie
        if (passengerBogies.contains(bogieToRemove)) {
            System.out.println("  [✓] " + bogieToRemove + " is attached to the train.");
        } else {
            System.out.println("  [✗] " + bogieToRemove + " is NOT in the consist (was removed).");
        }

        // Step 6: Print final list state
        System.out.println("\n--- Final Consist State ---");
        System.out.println("  " + passengerBogies);
        System.out.println("  Total bogies: " + passengerBogies.size());

        // Interactive section — let user add/remove
        System.out.println("\n--- Interactive Mode ---");
        System.out.println("Commands: add <name>, remove <name>, list, exit");

        while (true) {
            System.out.print("\n> ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("list")) {
                System.out.println("  Consist: " + passengerBogies);
                System.out.println("  Size: " + passengerBogies.size());
            } else if (input.toLowerCase().startsWith("add ")) {
                String name = input.substring(4).trim();
                passengerBogies.add(name);
                System.out.println("  [+] Added: " + name);
            } else if (input.toLowerCase().startsWith("remove ")) {
                String name = input.substring(7).trim();
                if (passengerBogies.remove(name)) {
                    System.out.println("  [-] Removed: " + name);
                } else {
                    System.out.println("  [!] " + name + " not found.");
                }
            } else {
                System.out.println("  Unknown command. Use: add, remove, list, exit");
            }
        }

        System.out.println("\n--- Final Consist ---");
        System.out.println("  " + passengerBogies);
        System.out.println("\nUC2 complete. ArrayList bogie management demonstrated.");
        sc.close();
    }
}
