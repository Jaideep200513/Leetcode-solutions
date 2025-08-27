/*
3459. Longest of Longest V-Shaped Diagonal Segment 

Approach:
1. Understand the Segment Rules
  The segment must start with 1.
  The sequence must follow:
    1 → 2 → 0 → 2 → 0 → … (repeats after 2,0).
  It must move diagonally in one of four directions:
    (down-right)   ↘
    (down-left)    ↙
    (up-left)      ↖
    (up-right)     ↗
  At most one clockwise 90° turn is allowed.

2. Starting Points
  Iterate over the grid.
  Every cell with value 1 is a potential starting point.

3. Explore in All Diagonal Directions
  From each 1, try moving along all four diagonals.
  As you move, check whether the cell matches the expected value in the sequence.
    After 1, expect 2.
    After 2, expect 0.
    After 0, expect 2 again.
  If mismatch → stop this path.

4. Allow One Clockwise Turn
  While moving diagonally, you may continue straight or take one clockwise 90° turn:
    ↘ turns into ↙
    ↙ turns into ↖
    ↖ turns into ↗
    ↗ turns into ↘
  After turning once, you must keep going straight in the new direction.

5. Track Maximum Length
  For each valid path, record how many cells matched the sequence.
  Keep updating the global maximum length.

6. Return Answer
  If no segment is found, return 0.
  Otherwise, return the maximum length recorded.
  
*/

class Solution {
    private int n, m;
    private int[][] grid;
    private final int[][] dirs = {{1,1},{1,-1},{-1,-1},{-1,1}};
    
    public int lenOfVDiagonal(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;
        
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 1) {
                    for (int d=0; d<4; d++) {
                        ans = Math.max(ans, dfs(i, j, d, 1, false));
                    }
                }
            }
        }
        return ans;
    }
    
    private int dfs(int r, int c, int dir, int expected, boolean turned) {
        if (r < 0 || c < 0 || r >= n || c >= m) return 0;
        if (grid[r][c] != expected) return 0;
        
        int length = 1;
        int nextExpected = getNext(expected);
        
        int nr = r + dirs[dir][0];
        int nc = c + dirs[dir][1];
        length = Math.max(length, 1 + dfs(nr, nc, dir, nextExpected, turned));
        
        if (!turned) {
            int newDir = (dir + 1) % 4;
            int tr = r + dirs[newDir][0];
            int tc = c + dirs[newDir][1];
            length = Math.max(length, 1 + dfs(tr, tc, newDir, nextExpected, true));
        }
        
        return length;
    }
    
    private int getNext(int val) {
        if (val == 1) return 2;
        if (val == 2) return 0;
        return 2; 
    }
}
