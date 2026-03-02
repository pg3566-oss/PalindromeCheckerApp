public class PalindromeCheckerApp {

    /**
     * Application entry point for UC3.
     * Palindrome Check Using String Reverse
     */

    public static void main(String[] args) {

        // Step 1: Store original string
        String input = "madam";

        // Step 2: Create an empty string to store reversed value
        String reversed = "";

        // Step 3: Reverse string using loop
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        // Step 4: Compare original and reversed string
        if (input.equals(reversed)) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }
    }
}