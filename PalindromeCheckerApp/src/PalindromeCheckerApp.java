import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    /**
     * UC12: Strategy Pattern for Palindrome Algorithms
     * Choose palindrome algorithm dynamically at runtime.
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to check palindrome: ");
        String input = sc.nextLine();

        System.out.println("\nChoose Strategy:");
        System.out.println("1. Stack Strategy (Reverse using Stack)");
        System.out.println("2. Deque Strategy (Compare front & rear)");
        System.out.print("Enter choice (1/2): ");

        int choice;
        try {
            choice = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            choice = 2; // default
        }

        PalindromeStrategy strategy;
        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        // Inject strategy into service
        PalindromeService service = new PalindromeService(strategy);

        boolean result = service.check(input);

        if (result) {
            System.out.println("\n\"" + input + "\" is a Palindrome ✅");
        } else {
            System.out.println("\n\"" + input + "\" is NOT a Palindrome ❌");
        }

        System.out.println("Strategy used: " + strategy.name());

        sc.close();
    }
}

/**
 * Strategy interface (contract)
 */
interface PalindromeStrategy {
    boolean isPalindrome(String input);
    String name();
}

/**
 * Context / Service class that uses a strategy.
 * Demonstrates Dependency Injection at runtime.
 */
class PalindromeService {

    private final PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        return strategy.isPalindrome(input);
    }
}

/**
 * Strategy 1: Stack-based palindrome check (UC5 concept)
 */
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String name() {
        return "StackStrategy (LIFO reversal)";
    }
}

/**
 * Strategy 2: Deque-based palindrome check (UC7 concept)
 */
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String name() {
        return "DequeStrategy (front-rear compare)";
    }
}