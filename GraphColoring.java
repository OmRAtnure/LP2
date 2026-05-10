class GraphColoring {

    int V = 4;

    boolean isSafe(int v, int graph[][], int color[], int c) {

        for (int i = 0; i < V; i++) {

            if (graph[v][i] == 1 && color[i] == c) {
                return false;
            }
        }

        return true;
    }

    boolean solve(int graph[][], int m, int color[], int v) {

        // All vertices colored
        if (v == V) {
            return true;
        }

        // Try all colors
        for (int c = 1; c <= m; c++) {

            if (isSafe(v, graph, color, c)) {

                color[v] = c;

                // Recur for next vertex
                if (solve(graph, m, color, v + 1)) {
                    return true;
                }

                // Backtrack
                color[v] = 0;
            }
        }

        return false;
    }

    void graphColoring(int graph[][], int m) {

        int color[] = new int[V];

        if (solve(graph, m, color, 0)) {

            System.out.println("Solution Exists:");

            for (int i = 0; i < V; i++) {
                System.out.println("Vertex " + i +
                        " ---> Color " + color[i]);
            }

        } else {
            System.out.println("No Solution");
        }
    }

    public static void main(String[] args) {

        GraphColoring g = new GraphColoring();

        int graph[][] = {
                {0,1,1,1},
                {1,0,1,0},
                {1,1,0,1},
                {1,0,1,0}
        };

        int m = 3;

        g.graphColoring(graph, m);
    }
}