class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return n-lps(0,n-1,s,dp);
    }
    int lps(int i, int j, String s,int[][] dp){
        if(i>j) return 0;
        if(i==j) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            dp[i][j]=2+lps(i+1,j-1,s,dp);
            return dp[i][j];
        }
        dp[i][j]=Math.max(lps(i,j-1,s,dp),lps(i+1,j,s,dp));
        return dp[i][j];
    }
}