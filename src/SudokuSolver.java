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
        int boxRow = (row/3) * 3; // Top-left row of this cell's box.a
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

    // Tries to solve the board. Returns true if solved, false if impossible
    public boolean solve() {
        for (int row = 0; row < 9; row++) {

            // Step 1: find the next empty cell (a,0)
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    // an empty cell was found
                    // Step 2: try each number 1-9 in it
                    for (int num = 1; num <=9; num++) {
                        if (isValid(row, col, num)) {
                            // check if the number is valid here: place it as a guess.
                            board[row][col]  = num;

                            //Step3: try solving the rest of the board
                            if (solve()) {
                                // Board was fully solved
                                return true;
                            }
                            //Step4: it didn't work so undo the guess (backtrack)
                            board[row][col] = 0;
                        }
                    }
                    // If no number 1-9 worked in the cell, its a dead end
                    return false;
                }
            }
        }
        // If whole board is filled and solved:
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver solver = new SudokuSolver();

        System.out.println("Puzzle:");
        solver.printBoard();

        if(solver.solve()) {
            System.out.println("\nSolved");
            solver.printBoard();
        } else {
            System.out.println("\nThis puzzle has no solution.");
        }
    }
}