class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        //dp[0][0]=grid[0][0];
        return helper(grid,0,0,dp);
    }
    public int helper(int[][] grid,int a,int b, int[][] dp){
        int n=grid.length;
        int m=grid[0].length;
        if(a>=n || b>=m) return 10000000;
        if(a==n-1 && b==m-1) return grid[a][b];
        if(dp[a][b]!=-1) return dp[a][b];
        int l=helper(grid,a+1,b,dp);
        int r=helper(grid,a,b+1,dp);
        dp[a][b]=grid[a][b]+Math.min(r,l);
        return dp[a][b];
    }
}