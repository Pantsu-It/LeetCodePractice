package leetcode.editor.en;

//Given a string s, find the longest palindromic substring in s. You may assume 
//that the maximum length of s is 1000. 
//
// Example 1: 
//
// 
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: "cbbd"
//Output: "bb"
// 
// Related Topics String Dynamic Programming


public class P5LongestPalindromicSubstring {
    public static void main(String[] arg) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("cbbd");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if (s== null || s.length() == 0) {
            return "";
        }
        int x = 0, y=0;
        char[] chars = s.toCharArray();
        int[][] space = new int[s.length()][s.length()];
        for (int step = 0; step < chars.length; ++step) {
            for (int start = 0; start + step < chars.length; ++start) {
                if (step == 0) {
                    space[start][start] = 1;
                    continue;
                }
                if (step == 1 && chars[start] == chars[start + 1]) {
                    space[start][start + 1] = 2;
                    if (y - x < step) {
                        x = start;
                        y = start + step;
                    }
                    continue;
                }
                if (space[start + 1][start + step - 1] > 0 && chars[start] == chars[start + step]) {
                    space[start][start + step] = space[start + 1][start + step - 1] + 2;
                    if (y - x < step) {
                        x = start;
                        y = start + step;
                    }
                }
            }
        }
        return s.substring(x, y + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}