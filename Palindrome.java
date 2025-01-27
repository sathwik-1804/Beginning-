//7.5
class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Palindrome {
    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Find the middle of the linked list
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        Node prev = null;
        while (slow != null) {
            Node nextTemp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextTemp;
        }

        // Compare the first half and the reversed second half
        Node firstHalf = head;
        Node secondHalf = prev; // Start of the reversed second half
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true; // It's a palindrome
    }

    public static void main(String[] args) {
        // Example usage
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(1);

        Node head2 = new Node(1);
        head2.next = new Node(2);

        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(head1)); // Output: true
        System.out.println(palindrome.isPalindrome(head2)); // Output: false
    }
}
