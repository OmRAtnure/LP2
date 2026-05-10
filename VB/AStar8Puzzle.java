import java.util.*;

public class AStar8Puzzle {

    static class Node {
        int[][] board;
        int x, y;
        int cost;
        int level;
        Node parent;

        Node(int[][] board, int x, int y, int level, Node parent) {
            this.board = new int[3][3];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    this.board[i][j] = board[i][j];
                }
            }

            this.x = x;
            this.y = y;
            this.level = level;
            this.parent = parent;
        }
    }

    static int[][] goal = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 0}
    };

    static int calculateCost(int[][] board) {

        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i][j] != 0 && board[i][j] != goal[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    static void printBoard(int[][] board) {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    static void printPath(Node node) {

        if (node == null) {
            return;
        }

        printPath(node.parent);

        printBoard(node.board);
    }

    public static void main(String[] args) {

        int[][] start = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 5, 8}
        };

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> (a.cost + a.level) - (b.cost + b.level)
        );

        Node root = new Node(start, 1, 1, 0, null);

        root.cost = calculateCost(start);

        pq.add(root);

        int[] row = {1, 0, -1, 0};
        int[] col = {0, -1, 0, 1};

        while (!pq.isEmpty()) {

            Node current = pq.poll();

            if (current.cost == 0) {

                System.out.println("Solution Path:\n");

                printPath(current);

                return;
            }

            for (int i = 0; i < 4; i++) {

                int newX = current.x + row[i];
                int newY = current.y + col[i];

                if (newX >= 0 && newX < 3 && newY >= 0 && newY < 3) {

                    int[][] newBoard = new int[3][3];

                    for (int r = 0; r < 3; r++) {
                        for (int c = 0; c < 3; c++) {
                            newBoard[r][c] = current.board[r][c];
                        }
                    }

                    int temp = newBoard[current.x][current.y];
                    newBoard[current.x][current.y] = newBoard[newX][newY];
                    newBoard[newX][newY] = temp;

                    Node child = new Node(newBoard, newX, newY,
                            current.level + 1, current);

                    child.cost = calculateCost(newBoard);

                    pq.add(child);
                }
            }
        }
    }
}