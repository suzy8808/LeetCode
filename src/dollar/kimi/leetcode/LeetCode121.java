package dollar.kimi.leetcode;

public class LeetCode121 {
    public int maxProfit(int[] prices) {
       int min=Integer.MAX_VALUE;
       int maxPro=0;
       for(int i=0;i<prices.length;i++){
           if(min>prices[i])min=prices[i];
           maxPro=Math.max(maxPro,prices[i]-min);
       }
       return maxPro;
    }
}
