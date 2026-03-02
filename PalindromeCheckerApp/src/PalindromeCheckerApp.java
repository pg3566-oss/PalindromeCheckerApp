import java.util.Scanner;

public class PalindromeCheckerApp {

    /**
     * UC11: Object-Oriented Palindrome Service
     * Main app calls a service class (PalindromeChecker)
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to check palindrome: ");
        String input = sc.nextLine();

        // Create service object
        PalindromeChecker checker = new PalindromeChecker();

        // Call service method
        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("\"" + input + "\" is a Palindrome");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome");
        }

        sc.close();
    }
}

/**
 * PalindromeChecker class encapsulates palindrome logic.
 * Demonstrates Encapsulation + Single Responsibility Principle.
 */
class PalindromeChecker {

    /**
     * Public service method exposed to the outside world.
     * Internally uses char[] + two-pointer approach.
     */
    public boolean checkPalindrome(String input) {

        if (input == null) {
            return false;
        }

        // Convert to char[] for index-based access
        char[] arr = input.toCharArray();

        int start = 0;
        int end = arr.length - 1;

        // Two-pointer comparison
        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}