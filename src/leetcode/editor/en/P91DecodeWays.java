package leetcode.editor.en;

//A message containing letters from A-Z is being encoded to numbers using the fo
//llowing mapping: 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// Given a non-empty string containing only digits, determine the total number o
//f ways to decode it. 
//
// Example 1: 
//
// 
//Input: "12"
//Output: 2
//Explanation: It could be decoded as "AB" (1 2) or "L" (12).
// 
//
// Example 2: 
//
// 
//Input: "226"
//Output: 3
//Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6)
//. 
// Related Topics String Dynamic Programming


import practice.Utils;

public class P91DecodeWays {
    public static void main(String[] arg) {
        Solution solution = new P91DecodeWays().new Solution();
        Utils.println(solution.numDecodings("12"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int[] dp = new int[s.length()];
            char[] chars = s.toCharArray();
            int[] nums = new int[chars.length];
            for (int i = 0; i < chars.length; ++i) {
                nums[i] = chars[i] - '0';
            }
            for (int i = 0; i < nums.length; ++i) {
                int m1;
                if (nums[i] == 0) {
                    m1 = 0;
                } else {
                    m1 = i > 0 ? dp[i - 1] : 1;
                }
                int m2 = 0;
                if (i >0) {
                    if (nums[i - 1] == 0) {
                        m2 = 0;
                    } else {
                        int num = nums[i - 1] * 10 + nums[i];
                        if (num > 0 && num <= 26) {
                            m2 = i> 1 ? dp[i - 2] : 1;
                        }
                    }
                }
                if (m1 == 0 && m2 == 0) {
                    return 0;
                }
                dp[i] = m1 + m2;
            }
            return dp[dp.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}