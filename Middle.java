//7.6
class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class Middle {
    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;

        // Use the fast and slow pointer approach
        while (fast != null && fast.next != null) {
            slow = slow.next;           // Move slow pointer by one
            fast = fast.next.next;      // Move fast pointer by two
        }

        // When fast reaches the end, slow will be at the middle
        return slow; // Return the middle node
    }

    public static void main(String[] args) {
        // Example usage
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);
        head2.next.next.next.next.next = new Node(6);

        Middle middle = new Middle();
        Node middle1 = middle.middleNode(head1);
        Node middle2 = middle.middleNode(head2);

        // Print the values of the middle nodes
        System.out.print("Middle of list 1: ");
        while (middle1 != null) {
            System.out.print(middle1.val + " ");
            middle1 = middle1.next;
        }
        System.out.println(); // Output: 3 4 5

        System.out.print("Middle of list 2: ");
        while (middle2 != null) {
            System.out.print(middle2.val + " ");
            middle2 = middle2.next;
        }
        // Output: 4 5 6
    }
}
