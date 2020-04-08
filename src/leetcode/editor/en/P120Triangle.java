package leetcode.editor.en;

//Given a triangle, find the minimum path sum from top to bottom. Each step you 
//may move to adjacent numbers on the row below. 
//
// For example, given the following triangle 
//
// 
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
//
// Note: 
//
// Bonus point if you are able to do this using only O(n) extra space, where n i
//s the total number of rows in the triangle. 
// Related Topics Array Dynamic Programming


import java.util.List;

public class P120Triangle {
    public static void main(String[] arg) {
        Solution solution = new P120Triangle().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        int num = triangle.size();
        if (num ==0) {
            return 0;
        }
        for (int i=num-1; i>=0; --i) {
            if (i == num -1){
                continue;
            }
            for (int j=0; j<=i; ++j){
                int max = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                triangle.get(i).set(j, max + triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}