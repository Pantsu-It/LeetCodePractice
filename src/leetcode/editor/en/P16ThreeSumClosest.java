package leetcode.editor.en;

//Given an array nums of n integers and an integer target, find three integers i
//n nums such that the sum is closest to target. Return the sum of the three integ
//ers. You may assume that each input would have exactly one solution. 
//
// Example: 
//
// 
//Given array nums = [-1, 2, 1, -4], and target = 1.
//
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
// Related Topics Array Two Pointers


import java.util.Arrays;

public class P16ThreeSumClosest {
    public static void main(String[] arg) {
        Solution solution = new P16ThreeSumClosest().new Solution();
        int[] nums = {-1, 2, 1, -4};
        solution.threeSumClosest(nums, 1);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int minDiff = Integer.MAX_VALUE;
            int absMinDiff = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 2; ++i) {
                int begin = i + 1, end = nums.length - 1;
                int temp = nums[i] - target;
                while (begin < end) {
                    int diff = nums[begin] + nums[end] + temp;
                    int absDiff = Math.abs(diff);
                    if (absDiff < absMinDiff) {
                        minDiff = diff;
                        absMinDiff = absDiff;
                    }
                    if (diff == 0) {
                        return target + minDiff;
                    }
                    if (diff < 0) {
                        ++begin;
                    } else {
                        --end;
                    }
                }
            }
            return target + minDiff;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}