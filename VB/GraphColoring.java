public class GraphColoring {

    static int vertices = 4;
    static int colors = 3;

    static int graph[][] = {
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0}
    };

    static int color[] = new int[vertices];

    static boolean isSafe(int vertex, int c) {

        for (int i = 0; i < vertices; i++) {

            if (graph[vertex][i] == 1 &&
                    color[i] == c) {

                return false;
            }
        }

        return true;
    }

    static boolean solve(int vertex) {

        if (vertex == vertices)
            return true;

        for (int c = 1; c <= colors; c++) {

            if (isSafe(vertex, c)) {

                color[vertex] = c;

                if (solve(vertex + 1))
                    return true;

                color[vertex] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        if (solve(0)) {

            System.out.println("Vertex Colors:");

            for (int i = 0; i < vertices; i++) {

                System.out.println(
                        "Vertex " + i +
                        " --> Color " + color[i]
                );
            }

        } else {

            System.out.println("No Solution");
        }
    }
}