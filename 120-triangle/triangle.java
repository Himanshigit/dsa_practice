class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp = new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(triangle,0,0,n,dp);
    }
    public int helper(List<List<Integer>> triangle,int i,int j,int n,int[][] dp){
        if(i==n-1) return triangle.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];
        int down1 = helper(triangle,i+1,j,n,dp);
        int down2=helper(triangle,i+1,j+1,n,dp);
        return dp[i][j]=Math.min(down1,down2)+triangle.get(i).get(j);
    }
}