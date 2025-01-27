//7.2
class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}
class Solution {
    public boolean hasCycle(Node head) {
        if (head == null) return false;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;        
            fast = fast.next.next;    
            if (slow == fast) {
                return true; // Cycle detected
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Node head = new Node(3);
        Node second = new Node(2);
        Node third = new Node(0);
        Node fourth = new Node(-4);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(head)); 
    }
}
