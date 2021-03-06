package leetcode.editor.cn;

//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树


import leetcode.editor.beans.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P437PathSumIii {
    public static void main(String[] arg) {
        Solution solution = new P437PathSumIii().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int count;

    public int pathSum(TreeNode root, int sum) {
        count = 0;
        pathSumRecur(root, sum);
        return count;
    }

    public List<Integer> pathSumRecur(TreeNode root, int sum) {
        if (root == null) {
            return null;
        }
        List<Integer> rLeft = pathSumRecur(root.left, sum);
        List<Integer> rRight = pathSumRecur(root.right, sum);
        List<Integer> result = new ArrayList<>();
        if (rLeft != null) {
            for (int num : rLeft) {
                int s = num + root.val;
                result.add(s);
                if (s == sum) {
                    count++;
                }
            }
        }
        if (rRight != null) {
            for (int num : rRight) {
                int s = num + root.val;
                result.add(s);
                if (s == sum) {
                    count++;
                }
            }
        }
        result.add(root.val);
        if (root.val == sum) {
            count++;
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}