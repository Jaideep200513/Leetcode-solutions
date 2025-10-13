/*
3147. Taking Maximum Energy From the Mystic Dungeon

Approach:
1. Start from the end of the array and compute total energy for each starting index.

2. dp[i] = energy collected starting from index i.

3. If you can jump k ahead (i.e., i + k < n), then dp[i] = energy[i] + dp[i + k]

4. Track the maximum value of all dp[i].
*/

public class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int maxEnergy = Integer.MIN_VALUE;

        // Traverse from the end since jumps go forward by k
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = energy[i];
            if (i + k < n) {
                dp[i] += dp[i + k];
            }
            maxEnergy = Math.max(maxEnergy, dp[i]);
        }

        return maxEnergy;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] energy1 = {5, 2, -10, -5, 1};
        int k1 = 3;
        System.out.println(sol.maximumEnergy(energy1, k1)); // Output: 3

        int[] energy2 = {-2, -3, -1};
        int k2 = 2;
        System.out.println(sol.maximumEnergy(energy2, k2)); // Output: -1
    }
}
