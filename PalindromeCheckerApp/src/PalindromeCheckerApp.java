import java.util.Deque;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    /**
     * Application entry point for UC7.
     * Deque-Based Optimized Palindrome Checker
     */

    public static void main(String[] args) {

        // Step 1: Store input string
        String input = "madam";

        // Step 2: Create a Deque (Double Ended Queue)
        Deque<Character> deque = new LinkedList<>();

        // Step 3: Insert characters into deque (at rear)
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        boolean isPalindrome = true;

        // Step 4: Remove from both ends and compare
        while (deque.size() > 1) {

            char frontChar = deque.removeFirst(); // front
            char rearChar = deque.removeLast();   // rear

            if (frontChar != rearChar) {
                isPalindrome = false;
                break;
            }
        }

        // Step 5: Display result
        if (isPalindrome) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }
    }
}