
//9.1
import java.util.ArrayList;
import java.util.List;
class TreeBasicTerminologies {
    public static void printChildren(int root, List<List<Integer>> adj) {
        System.out.print("Children of node " + root + ": ");
        if (adj.get(root).isEmpty()) {
            System.out.println("No children");
        } else {
            for (int child : adj.get(root)) {
                System.out.print(child + " ");
            }
            System.out.println();
        }
    }
    public static void printLeafNodes(int root, List<List<Integer>> adj) {
        System.out.print("Leaf nodes: ");
        boolean foundLeaf = false;
        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i).isEmpty()) { 
                System.out.print(i + " ");
                foundLeaf = true;
            }
        }
        if (!foundLeaf) {
            System.out.println("No leaf nodes");
        }
        System.out.println();
    }
    public static void printDegrees(int root, List<List<Integer>> adj) {
        System.out.println("Degrees of nodes:");
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("Node " + i + " has degree " + adj.get(i).size());
        }
    }
    public static void main(String[] args) {
        int numNodes = 7;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(2).add(5);
        adj.get(5).add(6);
        printChildren(0, adj);
        printLeafNodes(0, adj);
        printDegrees(0, adj);
    }
}