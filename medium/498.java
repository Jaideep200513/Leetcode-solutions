/*
498. Diagonal Traverse

Aprroach:

1. Key Idea
  We need to print all elements of the matrix diagonal by diagonal, and the direction alternates:
  One diagonal goes up-right (↗).
  The next diagonal goes down-left (↙).

2. Observations
  The total number of diagonals in an m x n matrix = m + n - 1.
  Every element on the same diagonal has the same value of row + col.
  Example: In [[1,2,3],[4,5,6],[7,8,9]]
    1 (0+0), 5 (1+1), 9 (2+2) all lie on diagonals where row+col is constant.
  We must traverse diagonals in alternating directions:
  Even diagonals (row+col even) → go up-right.
  Odd diagonals (row+col odd) → go down-left.

3. Simulation Approach
  We can simulate movement directly:
  Start from (0,0).
  Keep a direction flag (1 for up-right, -1 for down-left).

  At each step:
    Add mat[row][col] to result.
    
    Depending on direction, move:
        Up-right: (row-1, col+1)
        Down-left: (row+1, col-1)

    If out of bounds, adjust:
        If moving up-right and we go out:
            If at last column → go down (row++).
            Else → go right (col++).

    If moving down-left and we go out:
        If at last row → go right (col++).
        Else → go down (row++).

    Flip direction whenever a diagonal ends.
*/

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0)
        {
            return new int[0];
        } 
        
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0, dir = 1; // dir = 1 means up-right, -1 means down-left
        
        for (int i = 0; i < m * n; i++) {
            result[i] = mat[row][col];
            
            // Moving up-right
            if (dir == 1) {
                if (col == n - 1) { // hit right boundary
                    row++;
                    dir = -1;
                } else if (row == 0) { // hit top boundary
                    col++;
                    dir = -1;
                } else {
                    row--;
                    col++;
                }
            }
            // Moving down-left
            else {
                if (row == m - 1) { // hit bottom boundary
                    col++;
                    dir = 1;
                } else if (col == 0) { // hit left boundary
                    row++;
                    dir = 1;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return result;
    }
}
