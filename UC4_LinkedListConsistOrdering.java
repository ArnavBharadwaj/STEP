import java.util.LinkedList;
import java.util.Scanner;

/**
 * UC4: Train Consist Ordering Using LinkedList
 * 
 * Goal: Model the physical chaining of bogies using LinkedList for efficient
 * insertion and removal at any position.
 * 
 * Key Concepts:
 *   - LinkedList – doubly linked list where elements are connected via node references
 *   - Node structure – each element holds data + links to previous and next nodes
 *   - addFirst() / addLast() – attach bogies at head or tail
 *   - add(index, element) – insert a bogie in the middle
 *   - removeFirst() / removeLast() – detach from head or tail
 *   - Order preservation – maintains the physical sequence of the consist
 */
public class UC4_LinkedListConsistOrdering {

    /**
     * Helper to print the consist as a visual train diagram.
     */
    static void printTrain(LinkedList<String> consist) {
        System.out.print("  ");
        for (int i = 0; i < consist.size(); i++) {
            System.out.print("[" + consist.get(i) + "]");
            if (i < consist.size() - 1) {
                System.out.print(" — ");
            }
        }
        System.out.println();
        System.out.println("  (Total: " + consist.size() + " units)");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println(" TRAIN CONSIST MANAGEMENT APP v1.0");
        System.out.println("====================================");
        System.out.println("UC4: Consist Ordering with LinkedList\n");

        // Step 1: Create a LinkedList for the consist
        LinkedList<String> consist = new LinkedList<>();

        // Step 2: Add bogies — Engine, Sleeper, AC, Cargo, Guard
        System.out.println("--- Building Initial Consist ---");

        consist.add("Engine");
        System.out.println("  [+] Added: Engine");

        consist.add("Sleeper");
        System.out.println("  [+] Added: Sleeper");

        consist.add("AC");
        System.out.println("  [+] Added: AC");

        consist.add("Cargo");
        System.out.println("  [+] Added: Cargo");

        consist.add("Guard");
        System.out.println("  [+] Added: Guard");

        System.out.println("\nInitial Consist:");
        printTrain(consist);

        // Step 3: Insert a Pantry Car at position 2 (between Engine and Sleeper)
        System.out.println("\n--- Inserting Pantry Car at Position 2 ---");
        consist.add(2, "Pantry Car");
        System.out.println("  [+] Inserted: Pantry Car at index 2");
        System.out.println("\nConsist After Insertion:");
        printTrain(consist);

        // Step 4: Demonstrate addFirst and addLast
        System.out.println("\n--- Attaching Bogies at Head and Tail ---");

        consist.addFirst("Pilot Engine");
        System.out.println("  [+] addFirst: Pilot Engine (front of train)");

        consist.addLast("Brake Van");
        System.out.println("  [+] addLast: Brake Van (rear of train)");

        System.out.println("\nConsist After Head/Tail Additions:");
        printTrain(consist);

        // Step 5: Remove the first and last bogie
        System.out.println("\n--- Detaching Head and Tail ---");

        String removedFirst = consist.removeFirst();
        System.out.println("  [-] removeFirst: " + removedFirst);

        String removedLast = consist.removeLast();
        System.out.println("  [-] removeLast: " + removedLast);

        System.out.println("\nConsist After Removals:");
        printTrain(consist);

        // Step 6: Display peek operations
        System.out.println("\n--- Inspecting Head and Tail ---");
        System.out.println("  Head (peekFirst): " + consist.peekFirst());
        System.out.println("  Tail (peekLast) : " + consist.peekLast());

        // Step 7: Interactive mode
        System.out.println("\n--- Interactive Mode ---");
        System.out.println("Commands: addfirst <n>, addlast <n>, insert <pos> <n>,");
        System.out.println("          rmfirst, rmlast, list, exit");

        while (true) {
            System.out.print("\n> ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("list")) {
                printTrain(consist);
            } else if (input.equalsIgnoreCase("rmfirst")) {
                if (!consist.isEmpty()) {
                    System.out.println("  [-] Removed from front: " + consist.removeFirst());
                } else {
                    System.out.println("  [!] Consist is empty.");
                }
            } else if (input.equalsIgnoreCase("rmlast")) {
                if (!consist.isEmpty()) {
                    System.out.println("  [-] Removed from rear: " + consist.removeLast());
                } else {
                    System.out.println("  [!] Consist is empty.");
                }
            } else if (input.toLowerCase().startsWith("addfirst ")) {
                String name = input.substring(9).trim();
                consist.addFirst(name);
                System.out.println("  [+] Added at front: " + name);
            } else if (input.toLowerCase().startsWith("addlast ")) {
                String name = input.substring(8).trim();
                consist.addLast(name);
                System.out.println("  [+] Added at rear: " + name);
            } else if (input.toLowerCase().startsWith("insert ")) {
                try {
                    String[] parts = input.substring(7).trim().split("\\s+", 2);
                    int pos = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    consist.add(pos, name);
                    System.out.println("  [+] Inserted " + name + " at position " + pos);
                } catch (Exception e) {
                    System.out.println("  [!] Usage: insert <position> <bogie_name>");
                }
            } else {
                System.out.println("  Unknown command.");
            }
        }

        // Final state
        System.out.println("\n--- Final Train Consist ---");
        printTrain(consist);

        System.out.println("\nUC4 complete. LinkedList consist ordering demonstrated.");
        sc.close();
    }
}
