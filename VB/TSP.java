// import java.util.*;

public class TSP {

    static int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
    };

    static int n = 4;
    static boolean[] visited = new boolean[n];
    static int minCost = Integer.MAX_VALUE;

    static void tsp(int city, int count, int cost) {

        if (count == n && graph[city][0] > 0) {

            minCost = Math.min(minCost,
                    cost + graph[city][0]);

            return;
        }

        for (int i = 0; i < n; i++) {

            if (!visited[i] && graph[city][i] > 0) {

                visited[i] = true;

                tsp(i, count + 1,
                        cost + graph[city][i]);

                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        visited[0] = true;

        tsp(0, 1, 0);

        System.out.println("Minimum Cost = " + minCost);
    }
}