import java.util.*;

class DepthFirstSearch {
    private Map<Integer, List<Integer>> graph;

    // Constructor to initialize the graph
    public DepthFirstSearch() {
        graph = new HashMap<>();
    }

    // Method to add an edge from u to v
    public void addEdge(int u, int v) {
        if (!graph.containsKey(u)) {
            graph.put(u, new ArrayList<>());
        }
        graph.get(u).add(v);
    }

    // Utility method for DFS (recursive)
    private void DFSUtil(int v, Set<Integer> visited) {
        // Mark the current node as visited and print it
        visited.add(v);
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        if (graph.containsKey(v)) {
            for (int neighbor : graph.get(v)) {
                if (!visited.contains(neighbor)) {
                    DFSUtil(neighbor, visited);
                }
            }
        }
    }

    // Public method to initiate DFS
    public void DFS(int v) {
        Set<Integer> visited = new HashSet<>();
        DFSUtil(v, visited);
    }

    public static void main(String[] args) {
        // Create a graph object
        DepthFirstSearch g = new DepthFirstSearch();

        // Add edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        // Perform DFS traversal starting from vertex 1
        System.out.print("DFS from vertex 1: ");
        g.DFS(1);
        System.out.println();  
    }
}
