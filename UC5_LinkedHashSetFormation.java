import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * UC5: Maintain Insertion Order While Enforcing Uniqueness Using LinkedHashSet
 * 
 * Goal: Maintain the physical attachment order of bogies while preventing
 * duplicate entries in the train formation.
 * 
 * Key Concepts:
 *   - LinkedHashSet – hash table + linked list implementation of Set;
 *     stores unique elements while preserving insertion order
 *   - Set Interface – no duplicates allowed
 *   - add() – inserts if not already present; silently ignores duplicates
 *   - Automatic deduplication without manual validation
 *   - Insertion order preservation (unlike HashSet)
 *   - Ordered iteration – elements returned in attachment sequence
 */
public class UC5_LinkedHashSetFormation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println(" TRAIN CONSIST MANAGEMENT APP v1.0");
        System.out.println("====================================");
        System.out.println("UC5: Ordered Unique Formation with LinkedHashSet\n");

        // Step 1: Create a LinkedHashSet for the train formation
        LinkedHashSet<String> formation = new LinkedHashSet<>();

        // Step 2: Attach bogies — Engine, Sleeper, Cargo, Guard
        System.out.println("--- Attaching Bogies ---");

        String[] bogiesToAttach = {"Engine", "Sleeper", "AC Chair", "Cargo", "Guard"};
        for (String bogie : bogiesToAttach) {
            boolean added = formation.add(bogie);
            System.out.println("  [+] Attached: " + bogie + (added ? "" : " — FAILED (duplicate)"));
        }

        System.out.println("\nFormation after initial attachment:");
        System.out.println("  " + formation);
        System.out.println("  Size: " + formation.size());

        // Step 3: Attempt to attach duplicates intentionally
        System.out.println("\n--- Attempting Duplicate Attachments ---");

        String[] duplicates = {"Sleeper", "Engine", "Guard", "Sleeper"};
        for (String dup : duplicates) {
            boolean added = formation.add(dup);
            if (added) {
                System.out.println("  [+] Attached: " + dup);
            } else {
                System.out.println("  [!] Duplicate rejected: " + dup + " (already in formation)");
            }
        }

        // Step 4: Display the final formation — order is preserved
        System.out.println("\n--- Final Train Formation ---");
        System.out.println("  " + formation);
        System.out.println("  Size: " + formation.size());

        // Step 5: Show ordered iteration
        System.out.println("\n--- Ordered Iteration (attachment sequence) ---");
        int position = 1;
        for (String bogie : formation) {
            System.out.println("  Position " + position + ": " + bogie);
            position++;
        }

        // Step 6: Comparison — LinkedHashSet vs HashSet vs ArrayList
        System.out.println("\n--- When to Use What? ---");
        System.out.println("  ArrayList       : Allows duplicates, maintains order, index access");
        System.out.println("  HashSet         : No duplicates, NO order guarantee, fast lookup");
        System.out.println("  LinkedHashSet   : No duplicates, PRESERVES insertion order");
        System.out.println("  → For train formation: LinkedHashSet is ideal!");

        // Step 7: Interactive mode
        System.out.println("\n--- Interactive Mode ---");
        System.out.println("Commands: attach <name>, detach <name>, list, exit");

        while (true) {
            System.out.print("\n> ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("list")) {
                System.out.println("  Formation: " + formation);
                System.out.println("  Size: " + formation.size());
            } else if (input.toLowerCase().startsWith("attach ")) {
                String name = input.substring(7).trim();
                if (formation.add(name)) {
                    System.out.println("  [+] Attached: " + name);
                } else {
                    System.out.println("  [!] Duplicate rejected: " + name);
                }
            } else if (input.toLowerCase().startsWith("detach ")) {
                String name = input.substring(7).trim();
                if (formation.remove(name)) {
                    System.out.println("  [-] Detached: " + name);
                } else {
                    System.out.println("  [!] " + name + " not found in formation.");
                }
            } else {
                System.out.println("  Unknown command. Use: attach, detach, list, exit");
            }
        }

        // Final state
        System.out.println("\n--- Final Formation ---");
        int pos = 1;
        for (String bogie : formation) {
            System.out.println("  " + pos + ". " + bogie);
            pos++;
        }

        System.out.println("\nUC5 complete. LinkedHashSet formation demonstrated.");
        sc.close();
    }
}
