import java.util.Scanner;

public class PalindromeChecker {

    // Method to check palindrome (basic)
    public static boolean isPalindromeBasic(String str) {
        String reversed = "";
        
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        
        return str.equals(reversed);
    }

    // Method to check palindrome ignoring case and special characters
    public static boolean isPalindromeAdvanced(String str) {
        
        // Remove non-alphanumeric characters and convert to lowercase
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        String reversed = "";
        
        for (int i = cleaned.length() - 1; i >= 0; i--) {
            reversed += cleaned.charAt(i);
        }
        
        return cleaned.equals(reversed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        // Basic Check
        if (isPalindromeBasic(input)) {
            System.out.println("Basic Check: It is a Palindrome.");
        } else {
            System.out.println("Basic Check: Not a Palindrome.");
        }
        
        // Advanced Check
        if (isPalindromeAdvanced(input)) {
            System.out.println("Advanced Check: It is a Palindrome.");
        } else {
            System.out.println("Advanced Check: Not a Palindrome.");
        }
        
        sc.close();
    }
}
