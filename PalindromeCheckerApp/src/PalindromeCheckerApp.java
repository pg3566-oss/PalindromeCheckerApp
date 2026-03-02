public class PalindromeCheckerApp {

    /**
     * Application entry point for UC10.
     * Case-Insensitive & Space-Ignored Palindrome Check
     */

    public static void main(String[] args) {

        // Step 1: Input string
        String input = "A man a plan a canal Panama";

        // Step 2: Normalize the string
        // Remove spaces and convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Step 3: Convert to character array
        char[] charArray = normalized.toCharArray();

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
            System.out.println(input + " is a Palindrome (Ignoring case & spaces)");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }
    }
}