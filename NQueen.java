public class NQueen {

    static int N = 4;
    static int[][] board = new int[N][N];

    // Check if queen can be placed
    static boolean isSafe(int row, int col) {

        // Check upper column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check upper left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 1)
                return false;
        }

        // Check upper right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < N;
             i--, j++) {

            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    static boolean solve(int row) {

        // All queens placed
        if (row == N)
            return true;

        // Try every column
        for (int col = 0; col < N; col++) {

            if (isSafe(row, col)) {

                // Place queen
                board[row][col] = 1;

                // Recur for next row
                if (solve(row + 1))
                    return true;

                // Backtrack
                board[row][col] = 0;
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