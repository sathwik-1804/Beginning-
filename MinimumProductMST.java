import java.util.*;

public class MinimumProductMST {
    // Number of vertices in the graph
    static final int V = 5;

    // A utility function to find the vertex with minimum key value, from the set of vertices not yet included in MST
    int minKey(int key[], boolean mstSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }

        return min_index;
    }

    // A utility function to print the MST
    void printMST(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    // Prim's algorithm to find the MST for the graph with log-transformed weights
    void primMST(int inputGraph[][], int logGraph[][]) {
        // Array to store constructed MST
        int parent[] = new int[V];
        // Key values used to pick minimum weight edge in the cut
        int key[] = new int[V];
        // To represent set of vertices not yet included in MST
        boolean mstSet[] = new boolean[V];

        // Initialize all keys as infinite
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;  // Start with the first vertex
        parent[0] = -1;  // First node is always root of MST

        // Include all vertices in the MST
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum key vertex from the set of vertices not yet included in MST
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            // Update the key and parent for the adjacent vertices
            for (int v = 0; v < V; v++) {
                if (logGraph[u][v] != 0 && !mstSet[v] && logGraph[u][v] < key[v]) {
                    key[v] = logGraph[u][v];
                    parent[v] = u;
                }
            }
        }

        // Print the constructed MST
        printMST(parent, inputGraph);
    }

    // Function to calculate the minimum product spanning tree
    void minimumProductMST(int graph[][]) {
        // Create a log-transformed graph
        int logGraph[][] = new int[V][V];

        // Apply log transformation on edge weights
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (graph[i][j] != 0) {
                    logGraph[i][j] = (int) Math.log(graph[i][j]); // Replace with the log value of the weight
                }
            }
        }

        // Apply Prim's algorithm on the transformed graph to find the MST
        primMST(graph, logGraph);
    }

    public static void main(String[] args) {
        // Example graph with 5 vertices and the given edge weights
        int graph[][] = {
            {0, 10, 0, 0, 5},
            {10, 0, 20, 0, 0},
            {0, 20, 0, 10, 0},
            {0, 0, 10, 0, 15},
            {5, 0, 0, 15, 0}
        };

        MinimumProductMST obj = new MinimumProductMST();
        obj.minimumProductMST(graph);
    }
}
