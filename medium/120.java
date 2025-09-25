/*
120. Triangle

Approach :
1. Start from the second-last row of the triangle.
2. For each element, add the minimum of the two adjacent numbers directly below it.
3. Keep moving upward until you reach the top.
4. The top element will contain the minimum path sum.

*/

import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        
        // initialize with last row
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        
        // bottom-up calculation
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }
        
        return dp[0];
    }
}
