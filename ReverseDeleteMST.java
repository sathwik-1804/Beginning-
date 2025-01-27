import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Edge class to represent an edge in the graph
class Edge {
    int src, dest, weight;
    
    // Constructor to initialize the edge
    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

// Graph class
class Graph {
    int V;  // Number of vertices
    List<Edge> edges;  // List to store edges

    // Constructor to initialize the graph with a number of vertices
    Graph(int V) {
        this.V = V;
        edges = new ArrayList<>();
    }

    // Function to add an edge to the graph
    void addEdge(int u, int v, int w) {
        edges.add(new Edge(u, v, w));
    }

    // DFS function to check if the graph is connected after deleting an edge
    void dfs(int v, boolean[] visited, List<Edge> remainingEdges) {
        visited[v] = true;
        
        for (Edge edge : remainingEdges) {
            if (edge.src == v && !visited[edge.dest]) {
                dfs(edge.dest, visited, remainingEdges);
            } else if (edge.dest == v && !visited[edge.src]) {
                dfs(edge.src, visited, remainingEdges);
            }
        }
    }

    // Function to check if the graph is connected using DFS
    boolean isConnected(List<Edge> remainingEdges) {
        boolean[] visited = new boolean[V];
        dfs(0, visited, remainingEdges);  // Start DFS from vertex 0
        
        // If all vertices are visited, the graph is connected
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    // Function to find the MST using Reverse Delete Algorithm
    void reverseDeleteMST() {
        // Sort all the edges in decreasing order of their weight
        Collections.sort(edges, (a, b) -> Integer.compare(b.weight, a.weight));

        // Initialize the graph as the full graph
        List<Edge> remainingEdges = new ArrayList<>(edges);

        // Iterate through the edges in decreasing order of weight
        for (Edge edge : edges) {
            // Remove the edge from the graph
            remainingEdges.remove(edge);
            
            // Check if the graph is still connected
            if (!isConnected(remainingEdges)) {
                // If the graph becomes disconnected, restore the edge
                remainingEdges.add(edge);
            }
        }

        // Output the edges of the MST
        System.out.println("Edges in the MST:");
        for (Edge edge : remainingEdges) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
    }
}

public class ReverseDeleteMST {
    public static void main(String[] args) {
        // Example usage
        Graph graph = new Graph(9);  // Create a graph with 9 vertices

        // Adding edges to the graph (u, v, weight)
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 7, 7);
        graph.addEdge(1, 2, 6);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 5, 4);
        graph.addEdge(2, 8, 7);
        graph.addEdge(3, 5, 9);
        graph.addEdge(4, 5, 11);
        graph.addEdge(4, 1, 7);
        graph.addEdge(5, 6, 8);
        graph.addEdge(6, 7, 6);
        graph.addEdge(7, 8, 9);
        graph.addEdge(3, 4, 14);

        // Find the Minimum Spanning Tree using Reverse Delete Algorithm
        graph.reverseDeleteMST();
    }
}
