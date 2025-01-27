// 12.1
class Node {
    int val, ht;
    Node lt, rt;
    Node(int d) {
        val = d;
        ht = 1;
    }
}
class AVLInsertion {
    public int ht(Node node) {
        if (node == null) {
            return 0;
        }
        return node.ht;
    }
    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return ht(node.lt) - ht(node.rt);
    }
    public Node rightRotate(Node y) {
        Node x = y.lt;
        Node T2 = x.rt;
        x.rt = y;
        y.lt = T2;
        y.ht = Math.max(ht(y.lt), ht(y.rt)) + 1;
        x.ht = Math.max(ht(x.lt), ht(x.rt)) + 1;
        return x;
    }
    public Node leftRotate(Node x) {
        Node y = x.rt;
        Node T2 = y.lt;
        y.lt = x;
        x.rt = T2;
        x.ht = Math.max(ht(x.lt), ht(x.rt)) + 1;
        y.ht = Math.max(ht(y.lt), ht(y.rt)) + 1;
        return y;
    }
    public Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key < node.val) {
            node.lt = insert(node.lt, key);
        } else if (key > node.val) {
            node.rt = insert(node.rt, key);
        } else {
            return node;
        }
        node.ht = 1 + Math.max(ht(node.lt), ht(node.rt));
        int balance = getBalance(node);
        if (balance > 1 && key < node.lt.val) {
            return rightRotate(node);
        }
        if (balance < -1 && key > node.rt.val) {
            return leftRotate(node);
        }
        if (balance > 1 && key > node.lt.val) {
            node.lt = leftRotate(node.lt);
            return rightRotate(node);
        }
        if (balance < -1 && key < node.rt.val) {
            node.rt = rightRotate(node.rt);
            return leftRotate(node);
        }
        return node;
    }
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.lt);
            System.out.print(root.val + " ");
            inorder(root.rt);
        }
    }
    public static void main(String[] args) {
        AVLInsertion tree = new AVLInsertion();
        Node root = null;
        root = tree.insert(root, 10);
        root = tree.insert(root, 20);
        root = tree.insert(root, 30);
        root = tree.insert(root, 15);
        root = tree.insert(root, 25);
        System.out.println("Inorder traversal of the AVL tree:");
        tree.inorder(root);
    }
}
