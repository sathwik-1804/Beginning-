import java.util.*;
class BreathFirstSearch {
    private Map<Integer, List<Integer>> graph;
    public BreathFirstSearch() {
        graph = new HashMap<>();
    }
    public void addEdge(int u, int v) {
        if (!graph.containsKey(u)) {
            graph.put(u, new ArrayList<>());
        }
        graph.get(u).add(v);
    }
    public void BFS(int s) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(s);
        queue.offer(s);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            if (graph.containsKey(vertex)) {
                for (int neighbor : graph.get(vertex)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        BreathFirstSearch g = new BreathFirstSearch();
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        System.out.println("Following is Breadth First Traversal (starting from vertex 2):");
        g.BFS(2);
    }
}
