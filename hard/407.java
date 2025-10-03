/*
407. Trapping Rain Water II

Approach :
1. In 1D, water is trapped between two boundaries.

2. In 2D, water is trapped by the lowest boundary around a cell.

3. To solve, we use a priority queue (min-heap) to always expand from the lowest boundary outward:

    Push all boundary cells into a min-heap (these can’t trap water).
    
    Keep track of visited cells.
    
    While the heap isn’t empty:
        Pop the lowest height cell.
        Look at its 4 neighbors.
        If the neighbor is lower, water can be trapped:   water += max(0, height - neighborHeight)
        Push the neighbor into the heap with effective height = max(neighborHeight, height) (because water raises the floor).

*/

import java.util.*;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        if (m <= 2 || n <= 2) return 0;

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // Add all boundary cells into pq
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int water = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0], y = cell[1], h = cell[2];

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                water += Math.max(0, h - heightMap[nx][ny]);
                pq.offer(new int[]{nx, ny, Math.max(heightMap[nx][ny], h)});
            }
        }
        return water;
    }
}
