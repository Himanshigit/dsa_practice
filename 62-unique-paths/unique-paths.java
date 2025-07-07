class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp= new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(0,0,m,n,dp);
    }
    int helper(int a, int b, int m, int n,int[][] dp){
        if(a==m-1 || b==n-1){
            return 1;
        }
        if(a>=m || b>=n) return 0;
        if(dp[a][b]!=-1) return dp[a][b];
        dp[a][b]= helper(a+1,b,m,n,dp)+helper(a,b+1,m,n,dp);
        return dp[a][b];
    }
}