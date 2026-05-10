
public class PrimsMST {

    public static void main(String[] args) {

        int graph[][] = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        int vertices = 5;

        boolean selected[] = new boolean[vertices];

        selected[0] = true;

        System.out.println("Edge \tWeight");

        for (int edge = 0; edge < vertices - 1; edge++) {

            int min = Integer.MAX_VALUE;
            int x = 0;
            int y = 0;

            for (int i = 0; i < vertices; i++) {

                if (selected[i]) {

                    for (int j = 0; j < vertices; j++) {

                        if (!selected[j] &&
                                graph[i][j] != 0) {

                            if (graph[i][j] < min) {

                                min = graph[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }

            System.out.println(x + " - " + y + "\t" + graph[x][y]);

            selected[y] = true;
        }
    }
}