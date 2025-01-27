//10.5
class Node {
    int val;
    Node left, right;
    public Node(int item) {
        val = item;
        left = right = null;
    }
}
class BinaryTreeInsertion {
    Node root;
    public BinaryTreeInsertion() {
        root = null;
    }
    public void insert(int val) {
        root = insertRec(root, val);
    }
    private Node insertRec(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.val)
            root.left = insertRec(root.left, val);
        else if (val > root.val)
            root.right = insertRec(root.right, val);
        return root;
    }
    public void inorder() {
        inorderRec(root);
    }
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);  
            System.out.print(root.val + " ");  
            inorderRec(root.right);
        }
    }
    public static void main(String[] args) {
        BinaryTreeInsertion tree = new BinaryTreeInsertion();
        tree.insert(100);
        tree.insert(20);
        tree.insert(500);
        tree.insert(10);
        tree.insert(30);
        System.out.println("In-order traversal before inserting 40:");
        tree.inorder(); 
        System.out.println();
        System.out.println("\nInserting 40 into the BST...");
        tree.insert(40);
        System.out.println("\nIn-order traversal after inserting 40:");
        tree.inorder(); 
    }
}
