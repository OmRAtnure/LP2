import java.util.*;

public class KruskalMST {

    public static void main(String[] args) {

        int[][] edges = {
                {0, 1, 10},
                {0, 2, 6},
                {0, 3, 5},
                {1, 3, 15},
                {2, 3, 4}
        };

        int vertices = 4;

        // Sort edges by weight
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));

        int[] parent = new int[vertices];

        // Initially every node is its own parent
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        int total = 0;

        System.out.println("MST Edges:");

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            int pu = find(parent, u);
            int pv = find(parent, v);

            // If no cycle
            if (pu != pv) {

                System.out.println(u + " - " + v + " : " + w);

                total += w;

                parent[pu] = pv;
            }
        }

        System.out.println("Total Cost = " + total);
    }

    static int find(int[] parent, int x) {

        while (parent[x] != x) {
            x = parent[x];
        }

        return x;
    }
}