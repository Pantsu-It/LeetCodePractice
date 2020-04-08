package leetcode.editor.en;

//Given an array of integers, return indices of the two numbers such that they a
//dd up to a specific target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// Example: 
//
// 
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
// 
// Related Topics Array Hash Table


import java.util.*;

public class P1TwoSum {
    public static void main(String[] arg) {
        Solution solution = new P1TwoSum().new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
            int len = nums.length;
            for(int i = 0; i < len; i++){
                if(tracker.containsKey(nums[i])){
                    int left = tracker.get(nums[i]);
                    return new int[]{left, i};
                }else{
                    tracker.put(target - nums[i], i);
                }
            }
            return new int[2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}