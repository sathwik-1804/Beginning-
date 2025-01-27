//11.3
class Node {
    int key, ht, desc;
    Node lt, rt;
    Node(int d) {
        key = d;
        ht = 1;
        desc = 1; 
    }
}
class AVLCountMax {
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
        z.desc = 1 + getDesc(z.lt) + getDesc(z.rt); 
        y.desc = 1 + getDesc(y.lt) + getDesc(y.rt); 
        return y;
    }
    public Node ltRotate(Node z) {
        Node y = z.rt;
        Node T2 = y.lt;
        y.lt = z;
        z.rt = T2;
        z.ht = Math.max(ht(z.lt), ht(z.rt)) + 1;
        y.ht = Math.max(ht(y.lt), ht(y.rt)) + 1;
        z.desc = 1 + getDesc(z.lt) + getDesc(z.rt); 
        y.desc = 1 + getDesc(y.lt) + getDesc(y.rt);
        return y;
    }
    public int getDesc(Node node) {
        if (node == null) {
            return 0;
        }
        return node.desc;
    }
    public Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key < node.key) {
            node.lt = insert(node.lt, key);
        } else if (key > node.key) {
            node.rt = insert(node.rt, key);
        } else {
            return node;
        }
        node.ht = 1 + Math.max(ht(node.lt), ht(node.rt));
        node.desc = 1 + getDesc(node.lt) + getDesc(node.rt);
        int bal = getBal(node);
        if (bal > 1 && key < node.lt.key) {
            return rtRotate(node);
        }
        if (bal < -1 && key > node.rt.key) {
            return ltRotate(node);
        }
        if (bal > 1 && key > node.lt.key) {
            node.lt = ltRotate(node.lt);
            return rtRotate(node);
        }
        if (bal < -1 && key < node.rt.key) {
            node.rt = rtRotate(node.rt);
            return ltRotate(node);
        }
        return node;
    }
    public Node minValueNode(Node node) {
        Node current = node;
        while (current.lt != null) {
            current = current.lt;
        }
        return current;
    }
    public Node deleteNode(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.lt = deleteNode(root.lt, key);
        } else if (key > root.key) {
            root.rt = deleteNode(root.rt, key);
        } else {
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
                root.key = temp.key;
                root.rt = deleteNode(root.rt, temp.key);
            }
        }
        if (root == null) {
            return root;
        }
        root.ht = 1 + Math.max(ht(root.lt), ht(root.rt));
        root.desc = 1 + getDesc(root.lt) + getDesc(root.rt);
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
    public int countGreaterThan(Node node, int x) {
        if (node == null) {
            return 0;
        }
        if (node.key > x) {
            return 1 + getDesc(node.rt) + countGreaterThan(node.lt, x);
        }
        return countGreaterThan(node.rt, x);
    }
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.lt);
            preOrder(node.rt);
        }
    }
    public static void main(String[] args) {
        AVLCountMax tree = new AVLCountMax();
        Node root = null;
        root = tree.insert(root, 9);
        root = tree.insert(root, 1);
        root = tree.insert(root, 10);
        root = tree.insert(root, 0);
        root = tree.insert(root, 5);
        root = tree.insert(root, -1);
        root = tree.insert(root, 2);
        root = tree.insert(root, 6);
        root = tree.insert(root, 11);
        System.out.println("Pre-order traversal of the AVL tree:");
        tree.preOrder(root);
        System.out.println();
        int x = 5;
        int result = tree.countGreaterThan(root, x);
        System.out.println("Number of elements greater than " + x + ": " + result);
    }
}