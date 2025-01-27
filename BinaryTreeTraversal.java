import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
class BT {
    Node root;
    public BT() {
        this.root = null;
    }
    public void insert(int data) {
        root = insertRec(root, data);
    }
    Node insertRec(Node root, int data) {
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
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);  
            System.out.print(root.data + " ");
            inorder(root.right);  
        }
    }
    public void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " "); 
            preorder(root.left);
            preorder(root.right);  
        }
    }
    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);   
            postorder(root.right); 
            System.out.print(root.data + " ");
        }
    }
    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}
class BinaryTreeTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BT tree = new BT();
        System.out.println("Enter the number of nodes to insert into the tree:");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " values for the nodes:");
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            tree.insert(data);
        }
        System.out.println("\nInorder Traversal:");
        tree.inorder(tree.root);  
        System.out.println("\nPreorder Traversal:");
        tree.preorder(tree.root);
        System.out.println("\nPostorder Traversal:");
        tree.postorder(tree.root); 
        System.out.println("\nLevel Order Traversal:");
        tree.levelOrder(); 
        sc.close();
    }
}
