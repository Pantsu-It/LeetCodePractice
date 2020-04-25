package leetcode.editor.cn;

//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组


public class P189RotateArray {
    public static void main(String[] arg) {
        Solution solution = new P189RotateArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        rotate_2(nums, k);
    }

        /**
         * 双重循环
         * 时间复杂度：O(kn)
         * 空间复杂度：O(1)
         */
        public void rotate_1(int[] nums, int k) {
            int n = nums.length;
            k %= n;
            for (int i = 0; i < k; i++) {
                int temp = nums[n - 1];
                for (int j = n - 1; j > 0; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[0] = temp;
            }
        }

        /**
         * 翻转
         * 时间复杂度：O(n)
         * 空间复杂度：O(1)
         */
        public void rotate_2(int[] nums, int k) {
            int n = nums.length;
            k %= n;
            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                swap(nums, start++, end--);
            }
        }

        private void swap(int[] nums, int start, int end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}