import java.util.Arrays;
class Prisms {
    private int V; 
    private int[][] graph;
    public Prisms(int vertices) {
        this.V = vertices;
        this.graph = new int[V][V];
    }
    public void printMST(int[] parent) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }
    private int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
    public void primMST() {
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false);
        key[0] = 0;
        parent[0] = -1; 
        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }
        printMST(parent);
    }
    public static void main(String[] args) {
       Prisms g = new Prisms(5);
        g.graph[0][1] = 2;
        g.graph[1][0] = 2;
        g.graph[0][3] = 6;
        g.graph[3][0] = 6;
        g.graph[1][2] = 3;
        g.graph[2][1] = 3;
        g.graph[3][4] = 5;
        g.graph[4][3] = 5;
        g.graph[1][4] = 8;
        g.graph[4][1] = 8;
        g.graph[2][4] = 7;
        g.graph[4][2] = 7;
        g.primMST();
    }
}
