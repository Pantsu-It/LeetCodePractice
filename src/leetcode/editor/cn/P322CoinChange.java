package leetcode.editor.cn;

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划


public class P322CoinChange {
    public static void main(String[] arg) {
        Solution solution = new P322CoinChange().new Solution();
        int[] coints = {1,2,5};
        int amount = 11;
        solution.coinChange(coints, amount);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 初始化条件，dp[0]视情况特殊处理
        dp[0] = 0;
        // 因为转移方程用Math.min，所以dp初始化为Integer.MAX_VALUE
        for (int i = 1; i <= amount; ++i) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i<coins.length; ++i) {
            for (int j = coins[i]; j <= amount; ++j) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}