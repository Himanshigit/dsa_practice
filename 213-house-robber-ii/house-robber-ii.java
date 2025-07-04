class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        int[] dp1= new int[n];
        int[] dp2= new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int case1=helper(nums,dp1,0,0,n-2);
        int case2=helper(nums,dp2,0,1,n-1);
        return Math.max(case1,case2);
    }
    public int helper(int[] nums, int[] dp,int i,int start,int end){
        if(i+start>end) return 0;
        if(dp[i]!=-1) return dp[i];
        int a=nums[i+start]+helper(nums,dp,i+2,start,end);
        int b=helper(nums,dp,i+1,start,end);
        dp[i]=Math.max(a,b);
        return dp[i];
    }
}