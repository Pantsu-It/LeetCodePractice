package leetcode.editor.cn;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找


public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] arg) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                break;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left > right) {
            return new int[]{-1, -1};
        }
        int r = mid - 1;
        while (left <= r) {
            int m = (left + r) / 2;
            if (nums[m] == target) {
                r = m - 1;
            } else {
                left = m + 1;
            }
        }
        int l = mid + 1;
        while (l <= right) {
            int m = (l + right) / 2;
            if (nums[m] == target) {
                l = m + 1;
            } else {
                right = m - 1;
            }
        }
        return new int[]{r+1, l-1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}