public class PalindromeCheckerApp {

    /**
     * Application entry point for UC4.
     * Character Array Based Palindrome Check
     */

    public static void main(String[] args) {

        // Step 1: Store the original string
        String input = "madam";

        // Step 2: Convert string to character array
        char[] charArray = input.toCharArray();

        // Step 3: Initialize two pointers
        int start = 0;
        int end = charArray.length - 1;

        boolean isPalindrome = true;

        // Step 4: Two-pointer comparison
        while (start < end) {

            if (charArray[start] != charArray[end]) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        // Step 5: Display result
        if (isPalindrome) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }
    }
}