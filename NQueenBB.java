public class NQueenBB {

    static int N = 4;

    static int[][] board = new int[N][N];

    static boolean[] col = new boolean[N];

    static boolean[] leftDiag = new boolean[2 * N - 1];

    static boolean[] rightDiag = new boolean[2 * N - 1];

    static boolean solve(int row) {

        if (row == N)
            return true;

        for (int c = 0; c < N; c++) {

            int ld = row - c + N - 1;
            int rd = row + c;

            // Check instantly
            if (!col[c] &&
                    !leftDiag[ld] &&
                    !rightDiag[rd]) {

                // Place queen
                board[row][c] = 1;

                col[c] = true;
                leftDiag[ld] = true;
                rightDiag[rd] = true;

                if (solve(row + 1))
                    return true;

                // Backtrack
                board[row][c] = 0;

                col[c] = false;
                leftDiag[ld] = false;
                rightDiag[rd] = false;
            }
        }

        return false;
    }

    static void printBoard() {

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                if (board[i][j] == 1)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        if (solve(0))
            printBoard();
        else
            System.out.println("No Solution");
    }
}