class Solution {
    public int maxProfit(int[] prices) {
       int b1=Integer.MIN_VALUE,sell1=0;
       int b2=Integer.MIN_VALUE,sell2=0;
       for(int price:prices){
        b1=Math.max(b1,-price);
        sell1=Math.max(sell1,b1+price);
        b2=Math.max(b2,sell1-price);
        sell2=Math.max(sell2,b2+price);
       }
       return sell2;
    }
}