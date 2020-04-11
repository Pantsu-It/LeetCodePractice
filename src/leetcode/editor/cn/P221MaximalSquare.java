 package leetcode.editor.cn;

//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划


public class P221MaximalSquare {
    public static void main(String[] arg) {
        Solution solution = new P221MaximalSquare().new Solution();
        char[][] chars = {{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','1'}};
        solution.maximalSquare(chars);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxS = 0;
        // 在边界变量使用前一行，判断边界
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxS;
        }
        // matrix[0].length
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length; ++i) {
            for (int j=0; j<matrix[0].length; ++j) {
                dp[i][j] = matrix[i][j] - '0';
                if (dp[i][j] == 0) {
                    continue;
                }
                if (i == 0 || j==0) {
                    dp[i][j] = 1;
                } else {
                    int s = dp[i - 1][j - 1];
                    s = Math.min(s, dp[i][j - 1]);
                    s = Math.min(s, dp[i - 1][j]);
                    dp[i][j] = s + 1;
                }
                if (maxS < dp[i][j]) {
                    maxS = dp[i][j];
                }
            }
        }
        return maxS * maxS;
    }
    public int maximalSquare2(char[][] matrix) {
        int maxS = 0;
        for (int i=0; i<matrix.length; ++i) {
            //循环变量用错，不是++i
            for (int j=0; j<matrix[0].length; ++j) {
                matrix[i][j] -= '0';
                if (matrix[i][j] == 0) {
                    continue;
                }
                if (j == 0) {
                    matrix[i][j] = (char) 1;
                } else {
                    matrix[i][j] = (char) (matrix[i][j - 1] + 1);
                }

                int num;
                int m = 0, min = Integer.MAX_VALUE;
                //for循环代码块后，++k执行后才是判断，++k<min会对i-k>=0有影响！
                for (int k = 0; i - k >= 0 && k < min; ++k) {
                    num = matrix[i - k][j];
                    if (num >= k + 1) {
                        m = k + 1;
                        if (min > num) {
                            min = num;
                        }
                    } else {
                        break;
                    }
                }
                // 修改下面maxS=m*m，也要考虑maxS的相关比较！
                if (m * m > maxS) {
                    // 审题，不应该是m
                    maxS = m * m;
                }
            }
        }
        return maxS;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}