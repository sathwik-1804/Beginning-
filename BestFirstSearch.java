import java.util.*;

// Pair class to represent a graph edge (node, cost)
class Pair<T, U> {
    public T first;
    public U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}

class BestFirstSearch {
    static int v = 14;  // Number of vertices in the graph
    static List<List<Pair<Integer, Integer>>> graph = new ArrayList<>(); // Adjacency list for the graph
    
    // Add edge to the graph
    public static void addedge(int x, int y, int cost) {
        graph.get(x).add(new Pair<>(y, cost)); // Add an edge from x to y with cost
        graph.get(y).add(new Pair<>(x, cost)); // Add an edge from y to x with cost (since it's an undirected graph)
    }
    
    // Best First Search algorithm
    static void best_first_search(int actual_Src, int target, int n) {
        // Priority Queue (min-heap) to store nodes with their costs, sorted by the cost
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.second));
        
        // Array to track visited nodes
        boolean[] visited = new boolean[n];
        
        // Insert the start node into the priority queue with cost 0 (starting point)
        pq.add(new Pair<>(actual_Src, 0)); // (node, heuristic cost)
        visited[actual_Src] = true;  // Mark the source node as visited
        
        while (!pq.isEmpty()) {
            // Remove the node with the least cost (min-heap behavior)
            Pair<Integer, Integer> node = pq.poll();
            int u = node.first;  // The current node
            int cost = node.second;  // The cost associated with the current node
            
            System.out.println("Visiting node: " + u + " with cost: " + cost);
            
            // If we reach the target, stop the search
            if (u == target) {
                System.out.println("Goal reached: " + u);
                return;
            }
            
            // Explore the neighbors of the current node
            for (Pair<Integer, Integer> neighbor : graph.get(u)) {
                int v = neighbor.first;  // Neighbor node
                int edgeCost = neighbor.second;  // Cost to reach the neighbor
                
                // Only visit unvisited neighbors
                if (!visited[v]) {
                    visited[v] = true;  // Mark the neighbor as visited
                    pq.add(new Pair<>(v, edgeCost));  // Add the neighbor to the priority queue
                }
            }
        }
        
        System.out.println("Goal not reachable.");
    }
    
    // Main method
    public static void main(String[] args) {
        // Initialize the graph as an adjacency list
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges with the heuristic cost
        // Example graph: Each edge (node1 -> node2, cost)
        addedge(0, 1, 4);  // S -> A
        addedge(0, 2, 1);  // S -> C
        addedge(1, 3, 1);  // A -> D
        addedge(2, 3, 5);  // C -> D
        addedge(2, 4, 3);  // C -> E
        addedge(3, 5, 2);  // D -> F
        addedge(4, 5, 6);  // E -> F
        addedge(3, 6, 7);  // D -> G
        addedge(5, 6, 4);  // F -> G
        addedge(6, 7, 1);  // G -> H
        addedge(5, 7, 8);  // F -> H
        addedge(4, 8, 3);  // E -> I
        addedge(8, 9, 2);  // I -> J
        addedge(9, 10, 3); // J -> K
        
        // Perform Best First Search starting from node 0 (S) looking for node 8 (I)
        System.out.println("Starting Best First Search...");
        best_first_search(0, 8, v);
    }
}
