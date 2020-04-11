package leetcode.editor.cn;

//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是只包含质因数 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P264UglyNumberIi {
    public static void main(String[] arg) {
        Solution solution = new P264UglyNumberIi().new Solution();
        solution.nthUglyNumber(10);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int nthUglyNumber(int n) {
        // 1. 如果n有大小限制，可以用查表法
        // 2. 三指针法：指针移动一位（注意指针值都是最小时，都需要移动）
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int v2, v3, v5, min;
        for (int i = 1; i < n; ++i) {
            v2 = dp[index2] * 2;
            v3 = dp[index3] * 3;
            v5 = dp[index5] * 5;
            min = Math.min(v2, Math.min(v3, v5));
            dp[i] = min;
            if (v2 == min) {
                ++index2;
            }
            if (v3 == min) {
                ++index3;
            }
            if (v5 == min){
                ++index5;
            }
        }
        return dp[n-1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}