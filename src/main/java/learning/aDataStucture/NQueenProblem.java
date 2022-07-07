package learning.aDataStucture;

public class NQueenProblem {
    final int N = 4;

    void printSolution(int board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }
    boolean isSafe(int board[][], int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    boolean solveNQUtil(int board[][], int col) {
        if (col >= board.length)
            return true;

        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (solveNQUtil(board, col + 1))
                    return true;

                board[i][col] = 0; // BACKTRACK
            }
        }

        return false;
    }

    boolean solveNQ() {
        int board[][] = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        if (!solveNQUtil(board, 0)) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    // driver program to test above function
    public static void main(String args[]) {
        NQueenProblem Queen = new NQueenProblem();
        Queen.solveNQ();
    }
}
