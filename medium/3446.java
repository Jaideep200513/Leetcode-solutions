/*
3446. Sort Matrix by Diagonals

Approach:

Identify all diagonals:
  Bottom-left + main diagonal → start from first column and last row.
  Top-right diagonals → start from first row (excluding first cell).

For each diagonal:
  Collect all elements.
  Sort:
    Bottom-left → sort in descending order.
    Top-right → sort in ascending order.
  Put sorted values back into the diagonal.
  
Return the updated matrix.

*/

import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        
        for (int i = 0; i < n; i++) {
            sortDiagonal(grid, i, 0, false);
        }
        for (int j = 1; j < n; j++) {
            sortDiagonal(grid, n - 1, j, false); 
        }
        
        for (int j = 1; j < n; j++) {
            sortDiagonal(grid, 0, j, true); 
        }
        
        return grid;
    }
    
    private void sortDiagonal(int[][] grid, int row, int col, boolean increasing) {
        int n = grid.length;
        List<Integer> diagonal = new ArrayList<>();
        int r = row, c = col;
        
        while (r < n && c < n) {
            diagonal.add(grid[r][c]);
            r++;
            c++;
        }
        
        if (increasing) {
            Collections.sort(diagonal);
        } else {
            diagonal.sort(Collections.reverseOrder());
        }
        
        r = row;
        c = col;
        int idx = 0;
        while (r < n && c < n) {
            grid[r][c] = diagonal.get(idx++);
            r++;
            c++;
        }
    }
}
