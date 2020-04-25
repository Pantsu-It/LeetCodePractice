package leetcode.editor.cn;

//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法


public class P79WordSearch {
    public static void main(String[] arg) {
        Solution solution = new P79WordSearch().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; ++i) {
            for (int j=0; j< board[0].length; ++j) {
                int[][] path = new int[board.length][board[0].length];
                if (dfs(board, i, j, word, 0, path)) {
                    return true;
                }
            }
        }
        return false;
    }

        private boolean dfs(char[][] board, int i, int j, String word, int w, int[][] path) {
            if (w == word.length()) {
                return true;
            }
            if (i < 0 || j <0 || i>= board.length || j >= board[0].length) {
                return false;
            }
            if (path[i][j] == 1) {
                return false;
            }
            if (word.charAt(w) != board[i][j]) {
                return false;
            }
            path[i][j] = 1;
            w++;
            if (dfs(board, i - 1, j, word, w, path)
                    || dfs(board, i+1, j, word, w, path)
                    || dfs(board, i, j-1, word, w, path)
                    || dfs(board, i, j+1, word, w, path)) {
                return true;
            }
            path[i][j] = 0;
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}