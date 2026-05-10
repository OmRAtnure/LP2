import java.util.*;

public class BFS {

    static void bfs(int start,
                    boolean[] visited,
                    ArrayList<ArrayList<Integer>> graph) {

        Queue<Integer> queue = new LinkedList<>();

        // Mark starting node visited
        visited[start] = true;

        // Add starting node to queue
        queue.add(start);

        while (!queue.isEmpty()) {

            // Remove front node
            int node = queue.poll();

            // Print node
            System.out.print(node + " ");

            // Visit all neighbors
            for (int neighbor : graph.get(node)) {

                if (!visited[neighbor]) {

                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {

        int vertices = 5;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(1).add(4);

        boolean[] visited = new boolean[vertices];

        // Start BFS from node 0
        bfs(0, visited, graph);
    }
}