            }
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) <= Math.abs(target)) {
                continue;
                    dp[j] = Math.max(dp[j], dp[i] + 1);
            if (i > 0 && dp[i] <= 0) {
        for (int i = 0; i < nums.length; i++) {
        dp[0] = 0;
        Arrays.fill(dp, -1);
        int[] dp = new int[nums.length];
    public int maximumJumps(int[] nums, int target) {
class Solution {