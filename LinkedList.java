//7.1
class Node {
    String data;
    Node next;
    Node(String data) {
        this.data = data;
        this.next = null;
    }
}
class LinkedList {
    private Node head;
    public void insertAtEnd(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
    }

    public void updateNode(String val, int index) {
        Node current = head;
        for (int count = 0; current != null; count++) {
            if (count == index) {
                current.data = val;
                return;
            }
            current = current.next;
        }
        System.out.println("Index out of bounds");
    }

    public void remove_first_node() {
        if (head != null) head = head.next;
    }

    public void remove_last_node() {
        if (head == null) return;
        if (head.next == null) { head = null; return; }
        Node current = head;
        while (current.next.next != null) current = current.next;
        current.next = null;
    }

    public void remove_at_index(int index) {
        if (head == null) return;
        if (index == 0) { head = head.next; return; }
        Node current = head;
        for (int count = 0; current != null && count < index - 1; count++) {
            current = current.next;
        }
        if (current != null && current.next != null) current.next = current.next.next;
    }

    public void remove_node(String data) {
        if (head == null) return;
        if (head.data.equals(data)) { head = head.next; return; }
        Node current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }
        if (current.next != null) current.next = current.next.next;
    }

    public int sizeOfLL() {
        int count = 0;
        Node current = head;
        while (current != null) { count++; current = current.next; }
        return count;
    }

    public void printLL() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtEnd("A");
        list.insertAtEnd("B");
        list.insertAtEnd("C");
        list.printLL();
        list.updateNode("D", 1);
        list.printLL();
        list.remove_first_node();
        list.printLL();
        list.remove_last_node();
        list.printLL();
        list.remove_at_index(0);
        list.printLL();
        list.remove_node("D");
        list.printLL();
        System.out.println("Size of linked list: " + list.sizeOfLL());
    }
}
