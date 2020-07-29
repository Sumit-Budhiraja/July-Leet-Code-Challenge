class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
         
        int prevHold = -prices[0];
        int prevSold = 0;
        int prevRest = 0;
         
        for (int i = 1; i < prices.length; i++) {
            int currHold = Math.max(prevRest - prices[i], prevHold);
            int currSold = prevHold + prices[i];
            int currRest = Math.max(prevRest, prevSold);
             
            prevHold = currHold;
            prevSold = currSold;
            prevRest = currRest;
        }
         
        return Math.max(prevSold, prevRest);
    }
}