 class Node {
    int data;
    Node next, prev;
    Node(int data) {
        this.data = data;
    }
}
class DeleteAtGivenPosn {
    static Node deleteNode(Node head, Node del) {
        if (head == null || del == null) return head;
        if (head == del) {
            head = del.next;
        }
        if (del.next != null) {
            del.next.prev = del.prev;
        }
        if (del.prev != null) {
            del.prev.next = del.next;
        }
        del = null;
        return head; 
    }
    static Node deleteNodeAtGivenPos(Node head, int n) {
        if (head == null || n <= 0) return head; 
        Node current = head;
        for (int i = 1; i < n && current != null; i++) {
            current = current.next; 
        }
        if (current == null) {
            System.out.println("Position exceeds the length of the list.");
            return head;
        }
        head = deleteNode(head, current);
        return head;
    }
    static void printList(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(1);head.next = new Node(2);head.next.prev = head;
        head.next.next = new Node(3);head.next.next.prev = head.next;
        head.next.next.next = new Node(4);head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;
        System.out.print("Original List: ");
        printList(head);
        int n = 2;
        head = deleteNodeAtGivenPos(head, n);
        System.out.print("List after deleting node at position " + n + ": ");
        printList(head);
    }
}
