package leetcode.editor.cn;

//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组


import java.util.ArrayList;
import java.util.List;

public class P59SpiralMatrixIi {
    public static void main(String[] arg) {
        Solution solution = new P59SpiralMatrixIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int count = 1;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (true) {
            for (int i= left; i <= right; ++i) {
                matrix[top][i] = count++;
            }
            if (++top > bottom) {
                break;
            }
            for (int i=top; i<=bottom; ++i) {
                matrix[i][right] = count++;
            }
            if (--right < left) {
                break;
            }
            for (int i=right; i>= left; --i) {
                matrix[bottom][i] = count++;
            }
            if (--bottom < top) {
                break;
            }
            for (int i= bottom; i >= top; --i) {
                matrix[i][left] = count++;
            }
            if (++left > right) {
                break;
            }
        }
        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}