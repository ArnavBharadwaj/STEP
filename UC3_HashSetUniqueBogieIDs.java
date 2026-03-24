import java.util.HashSet;
import java.util.Scanner;

/**
 * UC3: Ensure No Duplicate Bogie IDs Using HashSet
 * 
 * Goal: Ensure no duplicate bogie IDs are added to the train.
 * 
 * Key Concepts:
 *   - HashSet – stores unique elements using hashing for fast access
 *   - Set Interface – collection type that does not allow duplicates
 *   - add() – inserts values; returns false if duplicate
 *   - Automatic deduplication without manual checks
 *   - Unordered storage – elements are not stored by index
 */
public class UC3_HashSetUniqueBogieIDs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println(" TRAIN CONSIST MANAGEMENT APP v1.0");
        System.out.println("====================================");
        System.out.println("UC3: Unique Bogie IDs with HashSet\n");

        // Step 1: Create a HashSet for bogie IDs
        HashSet<String> bogieIDs = new HashSet<>();

        // Step 2: Add bogie IDs (including intentional duplicates)
        System.out.println("--- Adding Bogie IDs ---");

        String[] idsToAdd = {"B001", "B002", "B003", "B004", "B002", "B005", "B001", "B006", "B003"};

        for (String id : idsToAdd) {
            boolean added = bogieIDs.add(id);
            if (added) {
                System.out.println("  [+] Added: " + id);
            } else {
                System.out.println("  [!] Duplicate ignored: " + id + " (already in consist)");
            }
        }

        // Step 3: Display the unique set of IDs
        System.out.println("\n--- Unique Bogie IDs in Consist ---");
        System.out.println("  " + bogieIDs);
        System.out.println("  Total unique bogies: " + bogieIDs.size());
        System.out.println("  Note: HashSet does NOT guarantee insertion order.");

        // Step 4: Check membership
        System.out.println("\n--- Membership Checks ---");
        String[] checks = {"B002", "B007", "B005"};
        for (String id : checks) {
            if (bogieIDs.contains(id)) {
                System.out.println("  [✓] " + id + " is registered in the consist.");
            } else {
                System.out.println("  [✗] " + id + " is NOT in the consist.");
            }
        }

        // Step 5: Remove a bogie ID
        System.out.println("\n--- Removing Bogie ---");
        String toRemove = "B004";
        if (bogieIDs.remove(toRemove)) {
            System.out.println("  [-] Removed: " + toRemove);
        } else {
            System.out.println("  [!] " + toRemove + " was not found.");
        }

        // Step 6: Interactive — let user try adding duplicates
        System.out.println("\n--- Interactive Mode ---");
        System.out.println("Try adding bogie IDs (type 'exit' to quit):");

        while (true) {
            System.out.print("\n  Enter bogie ID: ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if (input.isEmpty()) {
                System.out.println("  [!] ID cannot be empty.");
                continue;
            }

            boolean result = bogieIDs.add(input);
            if (result) {
                System.out.println("  [+] " + input + " added successfully.");
            } else {
                System.out.println("  [!] " + input + " is a DUPLICATE — rejected by HashSet.");
            }
        }

        // Final state
        System.out.println("\n--- Final Unique Bogie IDs ---");
        System.out.println("  " + bogieIDs);
        System.out.println("  Total: " + bogieIDs.size());

        System.out.println("\nUC3 complete. HashSet deduplication demonstrated.");
        sc.close();
    }
}
