package leetcode.editor.en;

//Given a m x n grid filled with non-negative numbers, find a path from top left
// to bottom right which minimizes the sum of all numbers along its path. 
//
// Note: You can only move either down or right at any point in time. 
//
// Example: 
//
// 
//Input:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//Output: 7
//Explanation: Because the path 1→3→1→1→1 minimizes the sum.
// 
// Related Topics Array Dynamic Programming


public class P64MinimumPathSum {
    public static void main(String[] arg) {
        Solution solution = new P64MinimumPathSum().new Solution();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        solution.minPathSum(grid);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                }
                grid[i][j] = Math.min(i > 0 ? grid[i - 1][j] : Integer.MAX_VALUE, j > 0 ? grid[i][j - 1] : Integer.MAX_VALUE) + grid[i][j];
            }
        }
        return grid[m - 1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}