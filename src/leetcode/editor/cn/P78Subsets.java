package leetcode.editor.cn;

//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P78Subsets {
    public static void main(String[] arg) {
        Solution solution = new P78Subsets().new Solution();
        int[] nums = {1, 2, 3};
        solution.subsets(nums);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res;

        public List<List<Integer>> subsets(int[] nums) {
            res = new ArrayList<>();
            subsets(nums, 0, new LinkedList<>());
            return res;
        }

        private void subsets(int[] nums, int i, LinkedList<Integer> list) {
            if (i == nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }

            subsets(nums, i + 1, list);

            list.add(nums[i]);
            subsets(nums, i + 1, list);
            list.removeLast();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}