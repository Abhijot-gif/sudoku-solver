public class SudokuSolver {
    // 9x9 grid - 0 represents an empty cell.
    private int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    // Print the board to the screen
    public void printBoard() {
        for (int row =0; row < 9; row++) {
            for(int col=0; col<9;col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    // Check if the number placed at (row,col) violates the rules of Sudoku.
    public boolean isValid(int row, int col, int num) {
        //Rule 1: num must not already be in this current row.
        for (int c=0; c<9; c++) {
            if (board[row][c] == num) {
                return false;
            }
        }
        //Rule 2: num must not already be in this current col.
        for (int r =0; r<9; r++) {
            if(board[r][col] == num) {
                return false;
            }
        }
        //Rule 3: num must not already be in this current 3x3 box.
        int boxRow = (row/3) * 3; // Top-left row of this cell's box.
        int boxCol = (col/3) * 3; // Top-left col of this cell's box.
        for (int r = boxRow; r<boxRow+3; r++) {
            for (int c = boxCol; c < boxCol + 3; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }
        // If all three checks pass:
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver solver = new SudokuSolver();
        solver.printBoard();
        System.out.println();

        // Top-left cell is empty [0][2]. Let's test:
        System.out.println("Can I put 1 at [0][2]? " + solver.isValid(0,2,1));
        System.out.println("Can I put 5 at [0][2]? " + solver.isValid(0,2,5));
        System.out.println("Can I put 7 at [0][2]? " + solver.isValid(0,2,7));
    }
}