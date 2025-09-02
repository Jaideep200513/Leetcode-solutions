/*
3025. Find the Number of Ways to Place People

Approach:
1. Pick every pair of points (A, B).
  A should be on the upper-left of B.
  That means A.x <= B.x and A.y >= B.y, and A ≠ B.

2. Form the rectangle (or line) between A and B.
  The rectangle corners are (A.x, A.y) (top-left) and (B.x, B.y) (bottom-right).

3. Check if any other point lies inside or on the rectangle border.
  If yes → the pair is invalid.
  If no → the pair is valid.

4.Count all valid pairs.

Since n ≤ 50, a simple brute-force with 3 loops (O(n³)) works fine.
In short: Try all pairs (A, B), check rectangle, count if empty.

*/

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int[] A = points[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int[] B = points[j];
                
                // A is on the upper-left (allow same x or y line, but not identical points)
                if (A[0] <= B[0] && A[1] >= B[1] && (A[0] != B[0] || A[1] != B[1])) {
                    boolean valid = true;
                    
                    // Check if any point lies inside or on the rectangle border
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int[] P = points[k];
                        if (P[0] >= A[0] && P[0] <= B[0] &&
                            P[1] <= A[1] && P[1] >= B[1]) {
                            valid = false;
                            break;
                        }
                    }
                    
                    if (valid) count++;
                }
            }
        }
        
        return count;
    }
}
