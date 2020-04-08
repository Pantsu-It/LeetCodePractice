package leetcode.editor.en;

//Given a collection of intervals, merge all overlapping intervals. 
//
// Example 1: 
//
// 
//Input: [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping. 
//
// NOTE: input types have been changed on April 15, 2019. Please reset to defaul
//t code definition to get new method signature. 
// Related Topics Array Sort


import java.util.Arrays;
import java.util.Comparator;

public class P56MergeIntervals {
    public static void main(String[] arg) {
        Solution solution = new P56MergeIntervals().new Solution();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        solution.merge(intervals);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, 0, intervals.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]- o2[0];
            }
        });
        int[] cur = intervals[0];
        int mergedCount = 0;
        for (int i= 1; i < intervals.length; ++i) {
            if (cur[1] >= intervals[i][0]) {
                cur[0] = Math.min(cur[0], intervals[i][0]);
                cur[1] = Math.max(cur[1], intervals[i][1]);
                intervals[i] = null;
                mergedCount++;
            } else {
                cur = intervals[i];
            }
        }
        if (mergedCount == 0) {
            return intervals;
        }
        int[][] result = new int[intervals.length - mergedCount][2];
        int i = 0;
        int j = 0;
        while (i < intervals.length) {
            if (intervals[i] != null) {
                result[j++] = intervals[i];
            }
            i++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}