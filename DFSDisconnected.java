import java.util.*;

// Class representing a graph using adjacency list representation
class DFSDisconnected {
    // A Map to store the graph: key = vertex, value = list of adjacent vertices
    private Map<Integer, List<Integer>> graph;

    // Constructor to initialize the graph
    public DFSDisconnected() {
        graph = new HashMap<>();
    }

    // Method to add an edge to the graph
    public void addEdge(int u, int v) {
        // Add v to the adjacency list of u
        graph.putIfAbsent(u, new ArrayList<>());
        graph.get(u).add(v);

        // If it's an undirected graph, also add u to the adjacency list of v
        graph.putIfAbsent(v, new ArrayList<>());
        graph.get(v).add(u);
    }

    // Utility method to perform DFS starting from vertex v
    private void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited
        visited[v] = true;
        // Print the current vertex (or store it in a result list)
        System.out.print(v + " ");

        // Recur for all the adjacent vertices of the current vertex
        if (graph.containsKey(v)) {
            for (Integer neighbor : graph.get(v)) {
                if (!visited[neighbor]) {
                    DFSUtil(neighbor, visited);
                }
            }
        }
    }

    // Method to perform DFS for the entire graph, handling disconnected components
    public void DFS() {
        // Array to keep track of visited vertices
        boolean[] visited = new boolean[graph.size()];

        // Iterate over all vertices and perform DFS for unvisited ones
        for (Integer vertex : graph.keySet()) {
            if (!visited[vertex]) {
                DFSUtil(vertex, visited);
            }
        }
    }

    public static void main(String[] args) {
        // Create a graph with 4 vertices and 3 edges
        DFSDisconnected g = new DFSDisconnected();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);

        // Perform DFS on the graph
        System.out.print("DFS Traversal of the Graph: ");
        g.DFS(); // Output should be: 0 1 2 3
    }
}
