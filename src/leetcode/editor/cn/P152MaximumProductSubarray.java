package leetcode.editor.cn;

//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划


public class P152MaximumProductSubarray {
    public static void main(String[] arg) {
        Solution solution = new P152MaximumProductSubarray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 解题技巧：
        // （1）对0的处理，较为简单，直接分段
        // （2）对子数组内有奇数个负数的选择问题
        // 复杂度为O(n)的解法：
        // 1.从左侧dp一遍，再从右侧dp一遍
        // 2.记录max，min值，遇到负数交换max和min，
        public int maxProduct(int[] nums) {
            int a = 1;
            int max = nums[0];

            for (int num : nums) {
                a = a * num;
                if (max < a) {
                    max = a;
                }
                if (num == 0) {
                    a = 1;
                }
            }
            a = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                a = a * nums[i];
                if (max < a) {
                    max = a;
                }
                if (nums[i] == 0) {
                    a = 1;
                }
            }
            return max;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}