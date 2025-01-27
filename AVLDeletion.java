// 11.2
class Node {
    int val, ht;
    Node lt, rt;
    Node(int d) {
        val = d;
        ht = 1; 
    }
}
class AVLDeletion {
    public int ht(Node node) {
        if (node == null) {
            return 0;
        }
        return node.ht;
    }
    public int getBal(Node node) {
        if (node == null) {
            return 0;
        }
        return ht(node.lt) - ht(node.rt);
    }
    public Node rtRotate(Node z) {
        Node y = z.lt;
        Node T2 = y.rt;
        y.rt = z;
        z.lt = T2;
        z.ht = Math.max(ht(z.lt), ht(z.rt)) + 1;
        y.ht = Math.max(ht(y.lt), ht(y.rt)) + 1;
        return y;
    }
    public Node ltRotate(Node z) {
        Node y = z.rt;
        Node T2 = y.lt;
        y.lt = z;
        z.rt = T2;
        z.ht = Math.max(ht(z.lt), ht(z.rt)) + 1;
        y.ht = Math.max(ht(y.lt), ht(y.rt)) + 1;
        return y;
    }
    public Node minValueNode(Node node) {
        Node current = node;
        while (current.lt != null) {
            current = current.lt;
        }
        return current;
    }
    public Node delete(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.val) {
            root.lt = delete(root.lt, key);
        }
        else if (key > root.val) {
            root.rt = delete(root.rt, key);
        }
        else {
            if (root.lt == null || root.rt == null) {
                Node temp = null;
                if (root.lt != null) {
                    temp = root.lt;
                } else if (root.rt != null) {
                    temp = root.rt;
                }
                if (temp == null) {
                    temp = root;
                    root = null;
                } else { 
                    root = temp;
                }
            } else {
                Node temp = minValueNode(root.rt);
                root.val = temp.val;
                root.rt = delete(root.rt, temp.val);
            }
        }
        if (root == null) {
            return root;
        }
        root.ht = 1 + Math.max(ht(root.lt), ht(root.rt));
        int bal = getBal(root);
        if (bal > 1 && getBal(root.lt) >= 0) {
            return rtRotate(root);
        }
        if (bal < -1 && getBal(root.rt) <= 0) {
            return ltRotate(root);
        }
        if (bal > 1 && getBal(root.lt) < 0) {
            root.lt = ltRotate(root.lt);
            return rtRotate(root);
        }
        if (bal < -1 && getBal(root.rt) > 0) {
            root.rt = rtRotate(root.rt);
            return ltRotate(root);
        }
        return root;
    }
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.lt);
            System.out.print(root.val + " ");
            inorder(root.rt);
        }
    }
    public static void main(String[] args) {
        AVLDeletion tree = new AVLDeletion();
        Node root = null;
        root = tree.insert(root, 20);
        root = tree.insert(root, 10);
        root = tree.insert(root, 30);
        root = tree.insert(root, 5);
        root = tree.insert(root, 15);
        System.out.println("Inorder traversal of the AVL tree:");
        tree.inorder(root);
        System.out.println();
        root = tree.delete(root, 10);
        System.out.println("Inorder traversal after deleting 10:");
        tree.inorder(root);
        System.out.println();
    }
    public Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.val) {
            root.lt = insert(root.lt, key);
        } else if (key > root.val) {
            root.rt = insert(root.rt, key);
        } else {
            return root;
        }
        root.ht = 1 + Math.max(ht(root.lt), ht(root.rt));
        int bal = getBal(root);
        if (bal > 1 && key < root.lt.val) {
            return rtRotate(root);
        }
        if (bal < -1 && key > root.rt.val) {
            return ltRotate(root);
        }
        if (bal > 1 && key > root.lt.val) {
            root.lt = ltRotate(root.lt);
            return rtRotate(root);
        }
        if (bal < -1 && key < root.rt.val) {
            root.rt = rtRotate(root.rt);
            return ltRotate(root);
        }
        return root;
    }
}
