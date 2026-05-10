import java.util.*;

public class DijkstraAlgorithm {

    public static void main(String[] args) {

        int graph[][] = {
                {0, 4, 0, 0, 0, 0},
                {4, 0, 8, 0, 0, 0},
                {0, 8, 0, 7, 2, 4},
                {0, 0, 7, 0, 9, 14},
                {0, 0, 2, 9, 0, 10},
                {0, 0, 4, 14, 10, 0}
        };

        int vertices = 6;

        int distance[] = new int[vertices];

        boolean visited[] = new boolean[vertices];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[0] = 0;

        for (int count = 0; count < vertices - 1; count++) {

            int min = Integer.MAX_VALUE;
            int u = -1;

            for (int i = 0; i < vertices; i++) {

                if (!visited[i] && distance[i] < min) {
                    min = distance[i];
                    u = i;
                }
            }

            visited[u] = true;

            for (int v = 0; v < vertices; v++) {

                if (!visited[v] &&
                        graph[u][v] != 0 &&
                        distance[u] != Integer.MAX_VALUE &&
                        distance[u] + graph[u][v] < distance[v]) {

                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        System.out.println("Vertex \tDistance");

        for (int i = 0; i < vertices; i++) {

            System.out.println(i + "\t" + distance[i]);
        }
    }
}