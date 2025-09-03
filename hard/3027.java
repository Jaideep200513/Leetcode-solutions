/*
3027. Find the Number of Ways to Place People II

Approach :
For every ordered pair of points (A, B):
  Check if A can be the upper-left corner and B the lower-right corner:
    A.x ≤ B.x and A.y ≥ B.y.
  Then check if any other point lies inside or on the rectangle defined by A and B.
  If no other point lies inside/on, count this pair.
*/

import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;

        // collect x and y coords
        int[] xs = new int[n];
        int[] ys = new int[n];
        for (int i = 0; i < n; i++) {
            xs[i] = points[i][0];
            ys[i] = points[i][1];
        }

        // sort & unique
        Arrays.sort(xs);
        Arrays.sort(ys);
        int nx = unique(xs);
        int ny = unique(ys);

        // compress
        int[] cx = new int[n];
        int[] cy = new int[n];
        for (int i = 0; i < n; i++) {
            cx[i] = Arrays.binarySearch(xs, 0, nx, points[i][0]) + 1; // 1-based
            cy[i] = Arrays.binarySearch(ys, 0, ny, points[i][1]) + 1;
        }

        // grid & prefix sum
        int[][] grid = new int[nx+1][ny+1];
        for (int i = 0; i < n; i++) {
            grid[cx[i]][cy[i]] = 1;
        }

        int[][] ps = new int[nx+1][ny+1];
        for (int i = 1; i <= nx; i++) {
            int row = 0;
            for (int j = 1; j <= ny; j++) {
                row += grid[i][j];
                ps[i][j] = ps[i-1][j] + row;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int ax = points[i][0], ay = points[i][1];
                int bx = points[j][0], by = points[j][1];
                if (ax <= bx && ay >= by) {
                    int x1 = cx[i], x2 = cx[j];
                    int y1 = cy[j], y2 = cy[i];
                    int cnt = ps[x2][y2] - ps[x1-1][y2] - ps[x2][y1-1] + ps[x1-1][y1-1];
                    if (cnt == 2) ans++;
                }
            }
        }
        return ans;
    }

    // remove duplicates in sorted array, return new length
    private int unique(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (k == 0 || arr[i] != arr[k-1]) {
                arr[k++] = arr[i];
            }
        }
        return k;
    }
}
