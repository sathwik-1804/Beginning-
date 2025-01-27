// 10.4
class Node {
    int key;
    Node left, right;
    public Node(int item) {
        key = item;
        left = right = null;
    }
}
class  SecondHighest {
    Node root;
    int count = 0;
    private void secondLargestUtil(Node node) {
        if (node == null || count >= 2) {
            return;
        }
        secondLargestUtil(node.right);
        count++;
        if (count == 2) {
            System.out.println("The second largest element is " + node.key);
            return;
        }
        secondLargestUtil(node.left);
    }
    public void secondLargest(Node node) {
        count = 0;
        secondLargestUtil(node); 
    }
    public static void main(String[] args) {
        SecondHighest tree = new SecondHighest();
        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(20);
        tree.root.right.right = new Node(30);
        tree.secondLargest(tree.root);
    }
}
