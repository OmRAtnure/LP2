class GraphColoringBB {

    int V = 4;
    int bestColors = Integer.MAX_VALUE;

    boolean isSafe(int graph[][], int color[],
                   int v, int c) {

        for (int i = 0; i < V; i++) {

            if (graph[v][i] == 1 &&
                    color[i] == c) {

                return false;
            }
        }

        return true;
    }

    void solve(int graph[][], int color[],
               int v, int usedColors) {

        // Bound condition
        if (usedColors >= bestColors) {
            return;
        }

        // All vertices processed
        if (v == V) {

            bestColors = usedColors;

            System.out.println("Better Solution Found");

            for (int i = 0; i < V; i++) {
                System.out.println(
                        "Vertex " + i +
                                " -> Color " + color[i]);
            }

            System.out.println(
                    "Colors Used = " + bestColors);

            return;
        }

        // Try colors
        for (int c = 1; c <= V; c++) {

            if (isSafe(graph, color, v, c)) {

                color[v] = c;

                solve(graph, color,
                        v + 1,
                        Math.max(usedColors, c));

                color[v] = 0;
            }
        }
    }

    public static void main(String[] args) {

        GraphColoringBB g =
                new GraphColoringBB();

        int graph[][] = {
                {0,1,1,1},
                {1,0,1,0},
                {1,1,0,1},
                {1,0,1,0}
        };

        int color[] = new int[g.V];

        g.solve(graph, color, 0, 0);
    }
}