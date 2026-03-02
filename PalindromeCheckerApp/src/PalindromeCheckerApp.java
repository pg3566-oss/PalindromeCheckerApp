public class PalindromeCheckerApp {

    /**
     * Application entry point for UC2.
     * Hardcoded Palindrome Validation
     */

    public static void main(String[] args) {

        // Step 1: Store a predefined (hardcoded) string
        String input = "madam";

        // Step 2: Assume it is a palindrome initially
        boolean isPalindrome = true;

        // Step 3: Loop only till half of the string length
        for (int i = 0; i < input.length() / 2; i++) {

            // Step 4: Compare characters from both ends
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        // Step 5: Display the result
        if (isPalindrome) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }
    }
}