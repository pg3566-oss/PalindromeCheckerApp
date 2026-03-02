public class PalindromeCheckerApp {

    // Singly Linked List Node
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        // Step 1: Input string
        String input = "madam";

        // Step 2: Convert string to singly linked list
        Node head = buildLinkedList(input);

        // Step 3: Check palindrome using linked list logic
        boolean result = isPalindrome(head);

        // Step 4: Print result
        if (result) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }
    }

    // Convert string to linked list
    private static Node buildLinkedList(String s) {
        if (s == null || s.length() == 0) return null;

        Node head = new Node(s.charAt(0));
        Node current = head;

        for (int i = 1; i < s.length(); i++) {
            current.next = new Node(s.charAt(i));
            current = current.next;
        }
        return head;
    }

    // UC8 core: Palindrome check using fast-slow, reverse second half, compare halves
    private static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Step A: Find middle using fast & slow pointers
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // If fast != null => odd length, skip the middle element
        if (fast != null) {
            slow = slow.next;
        }

        // Step B: Reverse second half starting from slow
        Node secondHalfHead = reverse(slow);

        // Step C: Compare first half and reversed second half
        Node firstHalf = head;
        Node secondHalf = secondHalfHead;

        while (secondHalf != null) { // second half is shorter or equal
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // In-place reversal of singly linked list
    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}