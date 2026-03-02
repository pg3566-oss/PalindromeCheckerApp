import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    /**
     * UC13: Performance Comparison
     * Compares different palindrome approaches using System.nanoTime()
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to benchmark palindrome algorithms: ");
        String input = sc.nextLine();

        // (Optional) repeat count to make timings more stable
        int iterations = 50_000;

        System.out.println("\nIterations per algorithm: " + iterations);
        System.out.println("Input length: " + input.length());
        System.out.println();

        benchmark("Char[] Two-Pointer (UC4)", iterations, () -> isPalindromeCharTwoPointer(input));
        benchmark("Reverse using String + (UC3)", iterations, () -> isPalindromeReverseConcat(input));
        benchmark("Stack Strategy (UC5)", iterations, () -> isPalindromeStack(input));
        benchmark("Deque Strategy (UC7)", iterations, () -> isPalindromeDeque(input));

        sc.close();
    }

    // ---------- Benchmark Helper ----------

    private static void benchmark(String name, int iterations, Algo algo) {

        // warm-up (helps reduce first-run noise)
        for (int i = 0; i < 5_000; i++) {
            algo.run();
        }

        long start = System.nanoTime();

        boolean lastResult = false;
        for (int i = 0; i < iterations; i++) {
            lastResult = algo.run();
        }

        long end = System.nanoTime();
        long totalNs = end - start;

        double avgNs = (double) totalNs / iterations;
        double totalMs = totalNs / 1_000_000.0;

        System.out.printf("%-28s | Result: %-5s | Total: %10.3f ms | Avg: %10.2f ns%n",
                name, lastResult, totalMs, avgNs);
    }

    @FunctionalInterface
    interface Algo {
        boolean run();
    }

    // ---------- Algorithms ----------

    // UC4 style: convert to char[] and compare with two pointers
    private static boolean isPalindromeCharTwoPointer(String input) {
        if (input == null) return false;

        char[] arr = input.toCharArray();
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] != arr[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    // UC3 style: reverse using String concatenation (intentionally less efficient)
    private static boolean isPalindromeReverseConcat(String input) {
        if (input == null) return false;

        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }
        return input.equals(reversed);
    }

    // UC5 style: Stack<Character>
    private static boolean isPalindromeStack(String input) {
        if (input == null) return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) return false;
        }
        return true;
    }

    // UC7 style: Deque<Character> compare front and rear
    private static boolean isPalindromeDeque(String input) {
        if (input == null) return false;

        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}