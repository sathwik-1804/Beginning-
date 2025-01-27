//7.7
class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class Conversion {
    public int getDecimalValue(Node head) {
        int decimalValue = 0;
        Node current = head;

        while (current != null) {
            decimalValue = (decimalValue << 1) | current.val; // Shift left and add current value
            current = current.next; // Move to the next node
        }

        return decimalValue; // Return the decimal value
    }

    public static void main(String[] args) {
        // Example usage
        Node head1 = new Node(1);
        head1.next = new Node(0);
        head1.next.next = new Node(1);

        Node head2 = new Node(0);

        Conversion conversion = new Conversion();
        System.out.println(conversion.getDecimalValue(head1)); // Output: 5
        System.out.println(conversion.getDecimalValue(head2)); // Output: 0
    }
}
