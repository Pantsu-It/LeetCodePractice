package leetcode.editor.en;

//Say you have an array for which the ith element is the price of a given stock 
//on day i. 
//
// If you were only permitted to complete at most one transaction (i.e., buy one
// and sell one share of the stock), design an algorithm to find the maximum profi
//t. 
//
// Note that you cannot sell a stock before you buy one. 
//
// Example 1: 
//
// 
//Input: [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//             Not 7-1 = 6, as selling price needs to be larger than buying pric
//e.
// 
//
// Example 2: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
// 
// Related Topics Array Dynamic Programming


public class P121BestTimeToBuyAndSellStock {
    public static void main(String[] arg) {
        Solution solution = new P121BestTimeToBuyAndSellStock().new Solution();
        int[] prices = {7,1,5,3,6,4};
        solution.maxProfit(prices);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for (int i=1; i< prices.length; ++i) {
            dp[i] = Math.min(dp[i - 1], prices[i]);
            profit = Math.max(profit, prices[i] - dp[i - 1]);
        }
        return profit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}