package leetcode.editor.cn;

//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 108] 
// 
// Related Topics 数组 数学


public class P670MaximumSwap {
    public static void main(String[] arg) {
        Solution solution = new P670MaximumSwap().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

/*
19:21	info
    解答失败:
    测试用例:1993
    测试结果:9193
    期望结果:9913
    stdout:
*/
    class Solution {
        public int maximumSwap(int num) {
            String string = String.valueOf(num);
            char[] chars = string.toCharArray();
            boolean finished = false;
            for (int i = 0; i < chars.length - 1; ++i) {
                char a = chars[i];
                int largerIndex = i;
                for (int j = i + 1; j < chars.length; ++j) {
                    if (chars[largerIndex] < chars[j]) {
                        largerIndex = j;
                    }
                }
                if (largerIndex != i) {
                    chars[i] = chars[largerIndex];
                    chars[largerIndex] = a;
                    break;
                }
            }
            return Integer.valueOf(new String(chars));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}