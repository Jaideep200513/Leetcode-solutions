/*
417. Pacific Atlantic Water Flow

Approach :
1. Create two boolean grids: pacific[m][n], atlantic[m][n]
2. Run DFS/BFS from:
   - Pacific edges: top row and left column
   - Atlantic edges: bottom row and right column
3. For each DFS step:
   - Move to next cell if it’s within bounds,
     not visited, and height[next] >= height[current].
4. After both DFS runs:
   - Collect cells where pacific[i][j] && atlantic[i][j]
   
*/

import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // Directions: up, down, left, right
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        // DFS from Pacific (top & left borders)
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, heights[0][j]);
        }
        
        // DFS from Atlantic (bottom & right borders)
        for (int i = 0; i < m; i++) {
            dfs(heights, atlantic, i, n - 1, heights[i][n - 1]);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, atlantic, m - 1, j, heights[m - 1][j]);
        }
        
        // Collect cells reachable by both oceans
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    
    private void dfs(int[][] heights, boolean[][] visited, int r, int c, int prevHeight) {
        int m = heights.length, n = heights[0].length;
        
        if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c] || heights[r][c] < prevHeight)
            return;
        
        visited[r][c] = true;
        
        dfs(heights, visited, r + 1, c, heights[r][c]);
        dfs(heights, visited, r - 1, c, heights[r][c]);
        dfs(heights, visited, r, c + 1, heights[r][c]);
        dfs(heights, visited, r, c - 1, heights[r][c]);
    }
}
