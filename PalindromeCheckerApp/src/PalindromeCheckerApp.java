import java.util.Stack;

public class PalindromeCheckerApp {

    /**
     * Application entry point for UC5.
     * Stack-Based Palindrome Checker
     */

    public static void main(String[] args) {

        // Step 1: Store input string
        String input = "madam";

        // Step 2: Create a stack
        Stack<Character> stack = new Stack<>();

        // Step 3: Push all characters into stack
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        boolean isPalindrome = true;

        // Step 4: Pop from stack and compare with original string
        for (int i = 0; i < input.length(); i++) {

            char poppedChar = stack.pop();

            if (input.charAt(i) != poppedChar) {
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