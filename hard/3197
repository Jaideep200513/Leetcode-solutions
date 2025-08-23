/*
LeetCode Problem: 3197 Minimum Area to cover all ones II


Approach:
We need to cover all 1's in the grid with exactly 3 non-overlapping rectangles of minimum total area.

1. Helper function (getArea):
   - For a given subgrid, find the minimum bounding box that covers all 1's.
   - Return its area (0 if no 1's).

2. Partition Strategies:
   Since rectangles must be axis-aligned and disjoint, possible partitions are:
   - 3 Vertical Strips: Choose 2 vertical cuts, dividing grid into 3 parts.
   - 3 Horizontal Strips: Choose 2 horizontal cuts, dividing grid into 3 parts.
   - L-Shaped Partitions:
     * First vertical cut, then horizontal cut on one side.
     * First horizontal cut, then vertical cut on one side.

3. For each partition, calculate the sum of minimal bounding rectangles covering 1's inside those regions.

4. Answer is the minimum sum across all partitions.

This brute-force is feasible because grid size ≤ 30 × 30.
*/


class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = Integer.MAX_VALUE;

        // area of minimal bounding box covering all 1s in subgrid [r1..r2] x [c1..c2]
        java.util.function.IntSupplier dummy = () -> 0; // keeps imports unnecessary
        // helper as a normal method (below) is clearer, but keeping all in one class:
        class Helper {
            int area(int r1, int r2, int c1, int c2) {
                int minR = Integer.MAX_VALUE, maxR = -1, minC = Integer.MAX_VALUE, maxC = -1;
                for (int i = r1; i <= r2; i++) {
                    for (int j = c1; j <= c2; j++) {
                        if (grid[i][j] == 1) {
                            if (i < minR) minR = i;
                            if (i > maxR) maxR = i;
                            if (j < minC) minC = j;
                            if (j > maxC) maxC = j;
                        }
                    }
                }
                if (maxR == -1) return 0; // no ones
                return (maxR - minR + 1) * (maxC - minC + 1);
            }
        }
        Helper H = new Helper();

        // Case 1: vertical splits into 3 parts
        for (int c1 = 0; c1 < n - 2; c1++) {
            for (int c2 = c1 + 1; c2 < n - 1; c2++) {
                int a1 = H.area(0, m - 1, 0, c1);
                int a2 = H.area(0, m - 1, c1 + 1, c2);
                int a3 = H.area(0, m - 1, c2 + 1, n - 1);
                if (a1 > 0 && a2 > 0 && a3 > 0) ans = Math.min(ans, a1 + a2 + a3);
            }
        }

        // Case 2: horizontal splits into 3 parts
        for (int r1 = 0; r1 < m - 2; r1++) {
            for (int r2 = r1 + 1; r2 < m - 1; r2++) {
                int a1 = H.area(0, r1, 0, n - 1);
                int a2 = H.area(r1 + 1, r2, 0, n - 1);
                int a3 = H.area(r2 + 1, m - 1, 0, n - 1);
                if (a1 > 0 && a2 > 0 && a3 > 0) ans = Math.min(ans, a1 + a2 + a3);
            }
        }

        // Case 3: one horizontal + one vertical (four T/L-shaped partitions)
        for (int r = 0; r < m - 1; r++) {
            for (int c = 0; c < n - 1; c++) {
                // top-left + top-right + bottom
                int a1 = H.area(0, r, 0, c);
                int a2 = H.area(0, r, c + 1, n - 1);
                int a3 = H.area(r + 1, m - 1, 0, n - 1);
                if (a1 > 0 && a2 > 0 && a3 > 0) ans = Math.min(ans, a1 + a2 + a3);

                // top + bottom-left + bottom-right
                a1 = H.area(0, r, 0, n - 1);
                a2 = H.area(r + 1, m - 1, 0, c);
                a3 = H.area(r + 1, m - 1, c + 1, n - 1);
                if (a1 > 0 && a2 > 0 && a3 > 0) ans = Math.min(ans, a1 + a2 + a3);

                // left + top-right + bottom-right
                a1 = H.area(0, m - 1, 0, c);
                a2 = H.area(0, r, c + 1, n - 1);
                a3 = H.area(r + 1, m - 1, c + 1, n - 1);
                if (a1 > 0 && a2 > 0 && a3 > 0) ans = Math.min(ans, a1 + a2 + a3);

                // right + top-left + bottom-left
                a1 = H.area(0, m - 1, c + 1, n - 1);
                a2 = H.area(0, r, 0, c);
                a3 = H.area(r + 1, m - 1, 0, c);
                if (a1 > 0 && a2 > 0 && a3 > 0) ans = Math.min(ans, a1 + a2 + a3);
            }
        }

        return ans;
    }
}
