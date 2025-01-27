/*class Node {
    int data;
    Node next, prev;
    Node(int data) {
        this.data = data;
    }
}
class SortedMergeDCLL {
    static Node mergeUtil(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        Node last1 = head1.prev, last2 = head2.prev;
        Node lastNode;
        if (last1.data < last2.data) {
            lastNode = last2;
        } else {
            lastNode = last1;
        }
        last1.next = null;
        last2.next = null;
        Node finalHead;
        if (head1.data <= head2.data) {
            finalHead = head1;
            head1.prev = lastNode;
            lastNode.next = head1;
            last1.next = head2;
            head2.prev = last1;
        } else {
            finalHead = head2;
            head2.prev = lastNode;
            lastNode.next = head2;
            last2.next = head1;
            head1.prev = last2;
        }
        return finalHead;
    }
    static void printList(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3); head1.next.prev = head1; head1.next.next = new Node(5);
        head1.next.next.prev = head1.next;head1.prev = head1.next.next;
        head1.next.next.next = head1; 
        Node head2 = new Node(2); head2.next = new Node(4);
        head2.next.prev = head2; head2.next.next = new Node(6);
        head2.next.next.prev = head2.next;head2.prev = head2.next.next;head2.next.next.next = head2;
        System.out.print("List 1: ");printList(head1);
        System.out.print("List 2: ");printList(head2);
        Node mergedHead = mergeUtil(head1, head2);
        System.out.print("Merged List: ");printList(mergedHead);
    }
} */
class Node {
    int data;
    Node next, prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class SortedMergeDoublyCircularLinkedList {

    // Merge two sorted doubly circular linked lists
    static Node mergeUtil(Node head1, Node head2) {
        // If either of the lists is empty
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        // Get the last node of both lists
        Node last1 = head1.prev; // Last node of list 1
        Node last2 = head2.prev; // Last node of list 2

        // Determine the last node of the merged list
        Node lastNode;
        if (last1.data < last2.data) {
            lastNode = last2;
        } else {
            lastNode = last1;
        }

        // Temporarily break the circular links
        last1.next = null;
        last2.next = null;

        // Merge the two lists
        Node mergedHead = sortedMerge(head1, head2);

        // Update the pointers to make it circular again
        mergedHead.prev = lastNode;
        lastNode.next = mergedHead;

        return mergedHead;
    }

    // Function to merge two sorted doubly linked lists
    static Node sortedMerge(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                head1.prev = tail;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2.prev = tail;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        // Attach the remaining nodes
        if (head1 != null) {
            tail.next = head1;
            head1.prev = tail;
        } else if (head2 != null) {
            tail.next = head2;
            head2.prev = tail;
        }

        // Return the head of the merged list
        return dummy.next;
    }

    // Function to print the doubly circular linked list
    static void printList(Node head) {
        if (head == null) return;

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
     public static void main(String[] args) {
        // Create first sorted doubly circular linked list
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.prev = head1;
        head1.next.next = new Node(30);
        head1.next.next.prev = head1.next;
        head1.prev = head1.next.next; // Last node points back to head
        head1.next.next.next = head1; // Circular connection

        // Create second sorted doubly circular linked list
        Node head2 = new Node(5);
        head2.next = new Node(15);
        head2.next.prev = head2;
        head2.next.next = new Node(25);
        head2.next.next.prev = head2.next;
        head2.prev = head2.next.next; // Last node points back to head
        head2.next.next.next = head2; // Circular connection

        // Merge the two lists
        Node mergedHead = mergeUtil(head1, head2);

        // Print the merged list
        System.out.print("Merged Doubly Circular Linked List: ");
        printList(mergedHead);
    }
}

