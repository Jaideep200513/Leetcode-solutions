/*
37. Sudoku Solver

Approach:
Find an empty cell (marked .).
Try digits 1–9 in that cell.
Check validity → number must not repeat in:
  that row
  that column
  that 3×3 sub-grid
If valid → place the number and recurse to solve the rest of the board.
If stuck → backtrack (remove the number, try next one).
Continue until the board is completely filled (solution found)

*/

class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (backtrack(board)) {
                                return true;
                            }
                            board[i][j] = '.'; 
                        }
                    }
                    return false;
                }
            }
        }
        return true; 
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false;
            if (board[i][col] == c) return false;
            int subRow = 3 * (row / 3) + i / 3;
            int subCol = 3 * (col / 3) + i % 3;
            if (board[subRow][subCol] == c) return false;
        }
        return true;
    }
}
