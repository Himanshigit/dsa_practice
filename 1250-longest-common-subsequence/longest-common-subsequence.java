class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m= text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return lcs(n,m,text1,text2,dp);
    }
    private int lcs(int i,int j, String a, String b, int[][] dp){
        if(i==0 || j==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i-1)==b.charAt(j-1)){
            dp[i][j]=1+lcs(i-1,j-1,a,b,dp);
        }else{
            dp[i][j]=Math.max(lcs(i-1,j,a,b,dp),lcs(i,j-1,a,b,dp));
        }
        return dp[i][j];
    }
}