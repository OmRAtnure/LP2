import java.util.*;

public class KruskalMST {

    static class Edge {
        int src, dest, weight;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            weight = w;
        }
    }

    static int find(int parent[], int i) {

        if (parent[i] == i)
            return i;

        return find(parent, parent[i]);
    }

    static void union(int parent[], int x, int y) {

        int xSet = find(parent, x);
        int ySet = find(parent, y);

        parent[xSet] = ySet;
    }

    public static void main(String[] args) {

        int vertices = 4;

        Edge edges[] = {
                new Edge(0, 1, 10),
                new Edge(0, 2, 6),
                new Edge(0, 3, 5),
                new Edge(1, 3, 15),
                new Edge(2, 3, 4)
        };

        Arrays.sort(edges, (a, b) -> a.weight - b.weight);

        int parent[] = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        System.out.println("Edge \tWeight");

        int count = 0;
        int i = 0;

        while (count < vertices - 1) {

            Edge next = edges[i++];

            int x = find(parent, next.src);
            int y = find(parent, next.dest);

            if (x != y) {

                System.out.println(
                        next.src + " - " +
                        next.dest + "\t" +
                        next.weight
                );

                union(parent, x, y);

                count++;
            }
        }
    }
}