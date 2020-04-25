package leetcode.editor.cn;

//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P119PascalsTriangleIi {
    public static void main(String[] arg) {
        Solution solution = new P119PascalsTriangleIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] nums = new int[rowIndex + 1];
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i; j >= 0; --j) {
                if (j == 0 || j == i) {
                    nums[j] = 1;
                } else {
                    nums[j] = nums[j - 1] + nums[j];
                }
            }
        }
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}