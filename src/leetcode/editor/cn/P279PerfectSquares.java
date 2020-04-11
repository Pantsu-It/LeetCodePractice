package leetcode.editor.cn;

//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 示例 1: 
//
// 输入: n = 12
//输出: 3 
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划


public class P279PerfectSquares {
    public static void main(String[] arg) {
        Solution solution = new P279PerfectSquares().new Solution();
        solution.numSquares(9);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        // 完全背包问题
        int k = (int) Math.floor(Math.sqrt(n));
        int[] coins = new int[k];
        for (int i = 1; i <= k; ++i) {
            coins[i - 1] = i * i;
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; ++i) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        dp[1] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= n; ++j) {
                dp[j] = Math.min(dp[j - coin] + 1, dp[j]);
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}