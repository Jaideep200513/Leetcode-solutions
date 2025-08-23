/*
LeetCode Problem: Minimum Area Rectangle that covers all 1s in a grid

Approach:
- Find min/max row and col where 1 appears
- Rectangle height = maxRow - minRow + 1
- Rectangle width  = maxCol - minCol + 1
- Return height * width

Time Complexity: O(m * n)
Space Complexity: O(1)
*/

class Solution {
    public int minimumArea(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int minRow = rows, maxRow = -1;
        int minCol = cols, maxCol = -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;

        return height * width;
    }
}
