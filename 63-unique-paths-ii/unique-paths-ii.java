class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
         return helper(obstacleGrid,0,0,dp);
    }
    public int helper(int[][] obstacleGrid,int a,int b,int[][] dp){
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(a>=m || b>=n) return 0;
        if(obstacleGrid[a][b]==1){
            return 0;
        }
        if(a==m-1 && b==n-1) return 1;
        if(dp[a][b]!=-1) return dp[a][b];
        int r=helper(obstacleGrid,a+1,b,dp);
        int d=helper(obstacleGrid,a,b+1,dp);
        dp[a][b]=r+d;
        return dp[a][b];
    }
}