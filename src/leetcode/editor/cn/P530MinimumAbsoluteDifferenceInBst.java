package leetcode.editor.cn;

//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树


import leetcode.editor.beans.tree.TreeNode;

import java.util.Stack;

public class P530MinimumAbsoluteDifferenceInBst {
    public static void main(String[] arg) {
        Solution solution = new P530MinimumAbsoluteDifferenceInBst().new Solution();
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
    public int getMinimumDifference(TreeNode root) {
        int res = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        pushStack(root, stack);

        TreeNode lastNode = null;
        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            if (lastNode != null) {
                int diff = Math.abs(lastNode.val - node.val);
                if (diff < res) {
                    res = diff;
                }
            }
            pushStack(node.right, stack);
            lastNode = node;
        }
        return res;
    }

    public void pushStack(TreeNode node, Stack<TreeNode> stack) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}