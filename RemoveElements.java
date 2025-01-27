//7.3
class Node {
    int val;
    Node next;

    publicNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class RemoveElements {
    public Node removeElements(Node head, int val) {
        // Create a dummy node to simplify removal logic
        Node dummy = new Node(0);
        dummy.next = head;

        Node current = dummy;

        while (current.next != null) {
            if (current.next.val == val) {
                // Skip the node with the target value
                current.next = current.next.next;
            } else {
                current = current.next; // Move to the next node
            }
        }

        return dummy.next; // Return the new head
    }

    public static void main(String[] args) {
        // Example usage
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(6);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(6);

        RemoveElements removeElements = new RemoveElements();
        Node newHead = removeElements.removeElements(head, 6);

        // Print the new linked list
        Node current = newHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        // Output: 1 2 3 4 5
    }
}
