import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    /**
     * Application entry point for UC6.
     * Queue + Stack Based Palindrome Check
     */

    public static void main(String[] args) {

        // Step 1: Store input string
        String input = "madam";

        // Step 2: Create Stack and Queue
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Step 3: Insert characters into both Stack and Queue
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));      // LIFO
            queue.add(input.charAt(i));       // FIFO
        }

        boolean isPalindrome = true;

        // Step 4: Compare dequeue (queue) with pop (stack)
        for (int i = 0; i < input.length(); i++) {

            char fromQueue = queue.remove();  // FIFO
            char fromStack = stack.pop();     // LIFO

            if (fromQueue != fromStack) {
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