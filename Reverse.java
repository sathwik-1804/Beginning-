class Node {

    int val;
  
    Node next;
  
    public Node(int val) {
  
      this.val = val;
  
      this.next = null;
  
    }
  
  }
  
  class Reverse {
  
    public Node reverseList(Node head) {
  
      Node prev = null;
  
      Node current = head;
  
      while (current != null) {
  
        Node nextTemp = current.next; // store next node
  
        current.next = prev; // reverse the link
  
        prev = current; // move prev and current one step forward
  
        current = nextTemp;
  
      }
  
      return prev; // prev will be the new head at the end
  
    }
  
    public static void main(String[] args) {
  
      // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
  
      Node head = new Node(1);
  
      head.next = new Node(2);
  
      head.next.next = new Node(3);
  
      head.next.next.next = new Node(4);
  
      head.next.next.next.next = new Node(5);
  
      // Reverse the linked list
  
      Reverse reverse = new Reverse();
  
      Node reversedHead = reverse.reverseList(head);
  
      // Print the reversed linked list
  
      Node current = reversedHead;
  
      while (current != null) {
  
        System.out.print(current.val + " ");
  
        current = current.next;
  
      }
  
    }
  
  }
  
  