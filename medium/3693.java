        for(int jump=1; jump<=3; jump++){
            int nextStep=i+jump;
            if(nextStep<=n){
            int currCost=costs[nextStep-1]+(jump*jump);
            int totalPath=currCost+dfs(nextStep,n,dp,costs);
            minCost=Math.min(minCost,totalPath);
            }
        }
        return dp[i]=minCost;
    }
    public int climbStairs(int n, int[] costs) {
        int[]dp=new int[n+2];
        int minCost=1000000000;
        if(dp[i]!=-1) return dp[i];
        if(i>n) return 1000000000;
        if(i==n){
            return 0;
        }
class Solution {
    public int dfs(int i,int n,int[]dp,int []costs){