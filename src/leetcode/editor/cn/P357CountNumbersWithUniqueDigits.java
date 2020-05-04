package leetcode.editor.cn;

//给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。 
//
// 示例: 
//
// 输入: 2
//输出: 91 
//解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
// 
// Related Topics 数学 动态规划 回溯算法


public class P357CountNumbersWithUniqueDigits {
    public static void main(String[] arg) {
        Solution solution = new P357CountNumbersWithUniqueDigits().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 10;
        dp[2] = 91;
        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i - 1] + (dp[i - 1] - dp[i - 2]) * (10 - (i - 1));
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}