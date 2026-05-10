import java.util.*;

public class Dijkstra {

    static int V = 5;

    static int minDistance(int dist[], boolean visited[]) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < V; i++) {

            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    static void dijkstra(int graph[][], int source) {

        int dist[] = new int[V];
        boolean visited[] = new boolean[V];

        // Initialize distances
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        dist[source] = 0;

        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, visited);

            visited[u] = true;

            for (int v = 0; v < V; v++) {

                // Update distance
                if (!visited[v]
                        && graph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Print result
        System.out.println("Vertex \t Distance from Source");

        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {

        int graph[][] = {
                {0, 2, 4, 0, 0},
                {2, 0, 1, 7, 0},
                {4, 1, 0, 3, 5},
                {0, 7, 3, 0, 1},
                {0, 0, 5, 1, 0}
        };

        dijkstra(graph, 0);
    }
}