 class Node {
    int data;
    Node next, prev;
    Node(int data) {
        this.data = data;
    }
}
class DeleteOccurrenceDLL {
    static Node deleteNode(Node head_ref, Node del) {
        if (head_ref == null || del == null) return head_ref;
        if (head_ref == del) {
            head_ref = del.next; 
        }
        if (del.next != null) {
            del.next.prev = del.prev;
        }
        if (del.prev != null) {
            del.prev.next = del.next;
        }
        return head_ref;
    }
    static Node deleteAllOccurOfX(Node head, int x) {
        if (head == null) return null;
        Node current = head;
        Node next;
        while (current != null) {
            if (current.data == x) {
                next = current.next; 
                head = deleteNode(head, current); 
                current = next; 
            } else {
                current = current.next; 
            }
        }
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
        Node head = new Node(2);head.next = new Node(2);
        head.next.prev = head;head.next.next = new Node(10);
        head.next.next.prev = head.next;head.next.next.next = new Node(8);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next.prev = head.next.next.next.next.next;
        head.next.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next.prev = head.next.next.next.next.next.next;
        System.out.print("Original List: ");
        printList(head);
        int x = 2;
        head = deleteAllOccurOfX(head, x);
        System.out.print("List after deleting " + x + ": ");
        printList(head);
    }
}
