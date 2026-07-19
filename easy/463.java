        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    for (int[] dir : dirs) {
                        int nr = i + dir[0];
                        int nc = j + dir[1];
                        if (nr < 0 || nr >= r || nc < 0 || nc >= c || grid[nr][nc] == 0) {
                            perimeter++;
                        }
                    }
                }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int perimeter = 0;
        int c = grid[0].length;
        int r = grid.length;
    public int islandPerimeter(int[][] grid) {
class Solution {