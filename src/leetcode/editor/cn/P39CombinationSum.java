package leetcode.editor.cn;

//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
// Related Topics 数组 回溯算法


import java.util.*;

public class P39CombinationSum {
    public static void main(String[] arg) {
        Solution solution = new P39CombinationSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<List<Integer>> result;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            result = new HashSet<>();

            Arrays.sort(candidates);
            recurCombine(candidates, 0, new LinkedList<>(), 0, target);
            return new ArrayList<>(result);
        }

        public void recurCombine(int[] candidates, int start, LinkedList<Integer> list, int sum, int target) {
            if (sum > target) {
                return;
            }
            if (sum == target) {
                result.add(new ArrayList<>(list));
                return;
            }
            for (int i = start; i < candidates.length; ++i) {
                list.add(candidates[i]);
                recurCombine(candidates, i, list, sum + candidates[i], target);
                list.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}