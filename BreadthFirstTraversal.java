import java.util.*;

class BreadthFirstTraversal {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list

    // Constructor to initialize the graph with V vertices
    BreadthFirstTraversal(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>(); // Create a typed LinkedList for each vertex
        }
    }

    // Method to add an edge to the graph
    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to the adjacency list of v
    }

    // Method to perform BFS starting from vertex s
    List<Integer> bfsOfGraph(int s) {
        // List to store the BFS traversal result
        List<Integer> result = new ArrayList<>();

        // Boolean array to keep track of visited nodes
        boolean[] visited = new boolean[V];

        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Mark the source node as visited and enqueue it
        visited[s] = true;
        queue.offer(s);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and add it to result
            int node = queue.poll();
            result.add(node);

            // Get all adjacent vertices of the dequeued vertex
            for (Integer neighbor : adj[node]) {
                // If the neighbor hasn't been visited, mark it as visited and enqueue it
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        // Return the BFS traversal result
        return result;
    }

    public static void main(String[] args) {
        // Test case 1: Graph with 5 vertices and 4 edges
        BreadthFirstTraversal graph1 = new BreadthFirstTraversal(5);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(0, 3);
        graph1.addEdge(2, 4);
    }
}
