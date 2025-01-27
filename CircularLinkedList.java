import java.util.ArrayList;

class Main {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class CircularLinkedList {
        Node last;
        // Insert at the beginning
        public void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            if (last == null) {
                last = newNode;
                last.next = last; // Point to itself
            } else {
                newNode.next = last.next;
                last.next = newNode;
            }
        }
        // Insert at the end
        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (last == null) {
                last = newNode;
                last.next = last; // Point to itself
            } else {
                newNode.next = last.next;
                last.next = newNode;
                last = newNode; // Update last to new node
            }
        }
        // Insert in between nodes
        public void addAfter(int data, int item) {
            if (last == null) {
                System.out.println("List is empty");
                return;
            }
            Node newNode = new Node(data);
            Node current = last.next;
            do {
                if (current.data == item) {
                    newNode.next = current.next;
                    current.next = newNode;
                    if (current == last) {
                        last = newNode; // Update last if item is last node
                    }
                    return;
                }
                current = current.next;
            } while (current != last.next);
            System.out.println(item + " not found in the list");
        }
        // Delete at the beginning
        public void deleteAtBeginning() {
            if (last == null) {
                System.out.println("List is empty");
                return;
            }
            if (last.next == last) {
                last = null; // Only one node
            } else {
                last.next = last.next.next; // Bypass the first node
            }
        }
        // Delete at the end
        public void deleteAtEnd() {
            if (last == null) {
                System.out.println("List is empty");
                return;
            }
            if (last.next == last) {
                last = null; // Only one node
            } else {
                Node current = last.next;
                while (current.next != last) {
                    current = current.next;
                }
                current.next = last.next; // Bypass the last node
                last = current; // Update last
            }
        }
        // Delete a specific node by value
        public void deleteNode(int key) {
            if (last == null) {
                System.out.println("List is empty");
                return;
            }
            Node current = last.next;
            Node prev = last;
            do {
                if (current.data == key) {
                    if (current == last) {
                        if (current.next == current) {
                            last = null; // Only one node
                        } else {
                            prev.next = current.next; // Bypass current node
                            last = prev; // Update last if needed
                        }
                    } else {
                        prev.next = current.next; // Bypass current node
                    }
                    return;
                }
                prev = current;
                current = current.next;
            } while (current != last.next);
            System.out.println(key + " not found in the list");
        }
        // Traverse the list
        public void traverse() {
            if (last == null) {
                System.out.println("List is empty");
                return;
            }
            Node current = last.next;
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != last.next);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertAtEnd(10);
        cll.insertAtEnd(20);
        cll.insertAtBeginning(5);
        cll.addAfter(15, 10);
        System.out.print("Circular Linked List: ");
        cll.traverse();
        cll.deleteAtBeginning();
        System.out.print("After deleting at beginning: ");
        cll.traverse();
        cll.deleteAtEnd();
        System.out.print("After deleting at end: ");
        cll.traverse();
        cll.deleteNode(15);
        System.out.print("After deleting node with value 15: ");
        cll.traverse();
    }
}
