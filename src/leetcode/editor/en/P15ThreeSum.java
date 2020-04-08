package leetcode.editor.en;

//Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro. 
//
// Note: 
//
// The solution set must not contain duplicate triplets. 
//
// Example: 
//
// 
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// Related Topics Array Two Pointers


import java.util.*;

public class P15ThreeSum {
    public static void main(String[] arg) {
        Solution solution = new P15ThreeSum().new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        solution.threeSum(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            Set<List<Integer>> set = new HashSet<>();
            // Transform to TwoSum-Problem
            for (int i = 0; i < nums.length; ++i) {
                // TwoSum-solve
                int begin = i + 1, end = nums.length - 1;
                while (begin < end) {
                    int sum = nums[begin] + nums[end];
                    if (sum + nums[i] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[begin]);
                        list.add(nums[end]);
                        set.add(list);
                        ++begin;
                        --end;
                    } else if (sum + nums[i] < 0) {
                        ++begin;
                    } else {
                        --end;
                    }
                }
            }
            return new ArrayList<>(set);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}


