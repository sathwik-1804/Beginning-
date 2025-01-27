//10.2
class Node {
    int data;
    Node left, right;
    public Node(int item) {
        data = item;
        left = right = null;
    }
}
class BinarySearchTreeMin {
    Node root;
    public BinarySearchTreeMin() {
        root = null;
    }
    public void insert(int data) {
        root = insertRec(root, data);
    }
    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }
    public Node findMinValueNode() {
        return findMinValueNodeRec(root);
    }
    private Node findMinValueNodeRec(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        return findMinValueNodeRec(root.left);
    }
    public void inorder() {
        inorderRec(root);
    }
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
    public static void main(String[] args) {
        BinarySearchTreeMin tree = new BinarySearchTreeMin();
        tree.insert(22);
        tree.insert(12);
        tree.insert(30);
        tree.insert(8);
        tree.insert(20);
        System.out.println("Inorder traversal of the BST:");
        tree.inorder(); 
        System.out.println();
        Node minNode = tree.findMinValueNode();
        if (minNode != null) {
            System.out.println("Node with minimum value: " + minNode.data);
        } else {
            System.out.println("Tree is empty.");
        }
    }
}