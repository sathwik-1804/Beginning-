import java.util.*;
class Kruskal {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }
    private int V;
    private List<Edge> edges; 
    public Kruskal(int vertices) {
        this.V = vertices;
        this.edges = new ArrayList<>();
    }
    public void addEdge(int u, int v, int w) {
        Edge edge = new Edge();
        edge.src = u;
        edge.dest = v;
        edge.weight = w;
        edges.add(edge);
    }
    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    private void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            // Union by rank
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
    public void KruskalMST() {
        Collections.sort(edges);
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        List<Edge> mst = new ArrayList<>();
        int mstWeight = 0;
        for (Edge edge : edges) {
            int x = find(parent, edge.src);
            int y = find(parent, edge.dest);
            if (x != y) {
                mst.add(edge);
                mstWeight += edge.weight;
                union(parent, rank, x, y);
            }
        }
        System.out.println("Following are the edges in the constructed MST:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
        }

        System.out.println("Minimum Cost Spanning Tree: " + mstWeight);
    }

    public static void main(String[] args) {
        Kruskal g = new Kruskal(4);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 6);
        g.addEdge(0, 3, 5);
        g.addEdge(1, 3, 15);
        g.addEdge(2, 3, 4);
        g.KruskalMST();
    }
}
