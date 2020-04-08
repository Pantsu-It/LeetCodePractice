package leetcode.editor.en;

//A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
//he diagram below). 
//
// The robot can only move either down or right at any point in time. The robot 
//is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
//iagram below). 
//
// How many possible unique paths are there? 
//
// 
//Above is a 7 x 3 grid. How many possible unique paths are there? 
//
// 
// Example 1: 
//
// 
//Input: m = 3, n = 2
//Output: 3
//Explanation:
//From the top-left corner, there are a total of 3 ways to reach the bottom-righ
//t corner:
//1. Right -> Right -> Down
//2. Right -> Down -> Right
//3. Down -> Right -> Right
// 
//
// Example 2: 
//
// 
//Input: m = 7, n = 3
//Output: 28
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 100 
// It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9. 
// 
// Related Topics Array Dynamic Programming


public class P62UniquePaths {
    public static void main(String[] arg) {
        Solution solution = new P62UniquePaths().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePaths(int m, int n) {
        int min = Math.min(m, n);
        int max = Math.max(m, n);

        int[] dp = new int[Math.min(m, n)];

        for (int i = 0; i < max; ++i) {
            for (int j = 0; j < min; ++j) {
                if (i == 0 && j == 0) {
                    dp[j] = 1;
                    continue;
                }
                int temp = (j == 0 ? 0 : dp[j - 1]) + (i == 0 ? 0 : dp[j]);
                dp[j] = temp;
            }
        }
        return dp[dp.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}