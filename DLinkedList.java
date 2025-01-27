import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node prev;
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
class DLinkedList {
    Node head;
    void insertBeg(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; 
        } else {
            newNode.next = head;
            head.prev = newNode; 
            head = newNode; 
        }
    }
    void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; 
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp; 
        }
    }
    void insertPos(int pos, int data) {
        if (pos <= 0) {
            System.out.println("Position must be greater than 0.");
            return;
        }
        if (pos == 1) {
            insertBeg(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position exceeds the length of the list. Inserting at the end.");
            insertEnd(data);
        } else {
            newNode.next = temp.next; 
            newNode.prev = temp; 
            if (temp.next != null) {
                temp.next.prev = newNode;
            }
            temp.next = newNode;
        }
    }
    void deleteBeg() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next; 
        if (head != null) {
            head.prev = null; 
        }
    }
    void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null; 
    }
    void deletePos(int pos) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (pos <= 0) {
            System.out.println("Position must be greater than 0.");
            return;
        }
        if (pos == 1) {
            deleteBeg();
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position exceeds the length of the list.");
        } else {
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
            if (temp.prev != null) {
                temp.prev.next = temp.next; 
            }
        }
    }
    void traverseF() {
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
    void traverseR() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DLinkedList list = new DLinkedList();
        list.insertBeg(10);
        list.insertEnd(20);
        list.insertEnd(30);
        list.insertBeg(5);
        list.insertPos(2, 15);
        System.out.print("Traverse forward: ");
        list.traverseF();
        System.out.print("Traverse backward: ");
        list.traverseR();
        list.deleteBeg();
        System.out.print("After deleting at beginning: ");
        list.traverseF();
        list.deleteEnd();
        System.out.print("After deleting at end: ");
        list.traverseF();
        list.deletePos(2);
        System.out.print("After deleting at position 2: ");
        list.traverseF();
        scanner.close();
    }
}
