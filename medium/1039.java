/*
1039. Minimum Score Triangulation of Polygon

Approach :
1. Pick any two vertices of the polygon.
2. To form a triangle with them, you must choose a third vertex that lies between them.
3. That triangle gives you a certain cost.
4. Now the polygon is split into two smaller sub-polygons.
5. Solve the problem recursively for both sub-polygons, add their costs, and keep track of the minimum.
6. Repeat this for every possible choice of the third vertex.
7. The minimum sum over all choices is the answer.

*/

class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        // length is the size of the polygon section we are considering
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                        dp[i][k] + dp[k][j] + values[i] * values[j] * values[k]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
