/*
778. Swim in Rising Water

Approach :
1. tart from the lowest possible time (the value at grid[0][0]).

2. Gradually increase time t until you can reach the destination.

3. For each t, check if you can travel from (0,0) to (n-1,n-1) using DFS or BFS, moving only through cells with elevation ≤ t.

4. The first time when you can reach the end — that’s your answer.
*/

import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[n][n];
        
        // Min-heap stores {time, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int r = current[1];
            int c = current[2];
            
            // If reached destination
            if (r == n - 1 && c == n - 1) return time;
            
            if (visited[r][c]) continue;
            visited[r][c] = true;
            
            // Explore all 4 directions
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc]) {
                    pq.offer(new int[]{Math.max(time, grid[nr][nc]), nr, nc});
                }
            }
        }
        return -1;
    }
}
