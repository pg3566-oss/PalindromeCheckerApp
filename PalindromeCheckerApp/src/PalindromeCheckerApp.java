public class PalindromeCheckerApp {

    /**
     * Application entry point for UC9.
     * Recursive Palindrome Checker
     */

    public static void main(String[] args) {

        // Step 1: Store input string
        String input = "madam";

        // Step 2: Call recursive function
        boolean result = isPalindrome(input, 0, input.length() - 1);

        // Step 3: Display result
        if (result) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }
    }

    // Recursive method
    public static boolean isPalindrome(String str, int start, int end) {

        // Base Condition (stopping condition)
        if (start >= end) {
            return true;
        }

        // Compare first and last characters
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call for inner substring
        return isPalindrome(str, start + 1, end - 1);
    }
}