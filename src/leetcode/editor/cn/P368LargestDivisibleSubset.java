package leetcode.editor.cn;

//给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。 
//
//
// 如果有多个目标子集，返回其中任何一个均可。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2] (当然, [1,3] 也正确)
// 
//
// 示例 2: 
//
// 输入: [1,2,4,8]
//输出: [1,2,4,8]
// 
// Related Topics 数学 动态规划


import java.util.*;

public class P368LargestDivisibleSubset {
    public static void main(String[] arg) {
        Solution solution = new P368LargestDivisibleSubset().new Solution();
        int[] nums = {1,2,3};
        solution.largestDivisibleSubset(nums);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public List<Integer> largestDivisibleSubset(int[] nums) {
            List<Integer> result = Collections.EMPTY_LIST;
            Arrays.sort(nums);

            List[] listArray = new List[nums.length];
            for (int i = 0; i < nums.length; ++i) {
                List<Integer> maxList = null;
                for (int j = 0; j < i; ++j) {
                    if (nums[i] % nums[j] == 0) {
                        if (maxList == null || maxList.size() < listArray[j].size()) {
                            maxList = listArray[j];
                        }
                    }
                }
                List<Integer> list = maxList != null ? new LinkedList(maxList) : new ArrayList<>();
                list.add(nums[i]);
                listArray[i] = list;

                if (list.size() > result.size()) {
                    result = list;
                }
            }
            return result;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}