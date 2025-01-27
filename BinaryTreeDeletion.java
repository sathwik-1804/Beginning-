class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class BinaryTreeDeletion {
    public static void deleteDeepest(Node root, Node dNode) {
        if (root == null) {
            return;
        }
        java.util.Queue<Node> q = new java.util.LinkedList<>();
        q.add(root);
        Node temp = null;
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp.left != null) {
                if (temp.left == dNode) {
                    temp.left = null;
                    return;
                } else {
                    q.add(temp.left);
                }
            }
            if (temp.right != null) {
                if (temp.right == dNode) {
                    temp.right = null;
                    return;
                } else {
                    q.add(temp.right);
                }
            }
        }
    }
    public static Node deletion(Node root, int key) {
        if (root == null) {
            System.out.println("Tree is empty");
            return null;
        }
        if (root.data == key && root.left == null && root.right == null) {
            return null;
        }
        java.util.Queue<Node> q = new java.util.LinkedList<>();
        q.add(root);
        Node temp = null;
        Node keyNode = null;
        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp.data == key) {
                keyNode = temp;
            }

            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
        if (keyNode == null) {
            System.out.println("Node with key " + key + " not found");
            return root;
        }
        int deepestNodeData = temp.data;
        deleteDeepest(root, temp); 
        if (keyNode != temp) {
            keyNode.data = deepestNodeData;
        }

        return root;
    }
    public static void levelOrder(Node root) {
        if (root == null) return;
        java.util.Queue<Node> q = new java.util.LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node root = new Node(13);
        root.left = new Node(12);
        root.right = new Node(10);
        root.left.left = new Node(4);
        root.left.right = new Node(19);
        root.right.left = new Node(16);
        root.right.right = new Node(9);
        System.out.println("Original Tree (Level Order): ");
        levelOrder(root);
        System.out.println("\nDeleting node 12....");
        root = deletion(root, 12);
        levelOrder(root);
    }
}


/*
    13
   /  \
  12   10
 /  \  /  \
4  19 16  9



    13
   /  \
  9    10
 /  \  /  \
4  19 16  



*/
