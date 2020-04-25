package leetcode.editor.cn;

//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P215KthLargestElementInAnArray {
    public static void main(String[] arg) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


        public int findKthLargest(int[] nums, int k) {
            return partition(nums, 0, nums.length - 1, k);
        }

        private int partition(int[] nums, int start, int end, int k) {
            int pivot = nums[start];
            int i = start;
            int j = end;
            while (i < j) {
                while (i < j && nums[j] <= pivot) {
                    j--;
                }
                nums[i] = nums[j];
                while (i < j && nums[i] >= pivot) {
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[i] = pivot;
            if (i == k - 1) return pivot;
            if (i > k - 1) return partition(nums, start, i - 1, k);
            return partition(nums, i +1, end, k);
        }

        public int findKthLargest0(int[] nums, int k) {
            // 思路0：调用库函数排序，最快
            // 思路1：快排的partition思想
            // 思路2：维护最大堆
            Arrays.sort(nums);
            return nums[nums.length - k];
        }




        public int findKthLargest1(int[] nums, int k) {
            // init heap 'the smallest element first'
            PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n));

            // keep k largest elements in the heap
            for (int n: nums) {
                heap.add(n);
                if (heap.size() > k)
                    heap.poll();
            }

            // output
            return heap.poll();
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}