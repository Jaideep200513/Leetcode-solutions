    }
    public static int func(int[] a, int[] dp, int i, int n){
        if (i >= n){
            return 0;
        }
        if (dp[i] != -1){
            return dp[i];
        }
        return Math.max(ans1, ans2);
        int ans2 = func(nums, dp, 1, n);
        Arrays.fill(dp, -1);
        int ans1 = func(nums, dp, 0, n - 1);
        }
        Arrays.fill(dp, -1);
            return nums[0];
        int[] dp = new int[n];
        if (n == 1){
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;