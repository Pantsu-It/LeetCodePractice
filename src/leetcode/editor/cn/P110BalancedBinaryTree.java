package leetcode.editor.cn;

//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
// Related Topics 树 深度优先搜索


import leetcode.editor.beans.tree.TreeNode;

public class P110BalancedBinaryTree {
    public static void main(String[] arg) {
        Solution solution = new P110BalancedBinaryTree().new Solution();
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getHeight(root, 0) != -1;
    }

    public int getHeight(TreeNode node, int height) {
        if (node == null) {
            return height;
        }
        int hl = node.left != null ? getHeight(node.left, height + 1) : height;
        if (hl == -1) {
            return -1;
        }
        int hr = node.right != null ? getHeight(node.right, height + 1) : height;
        if (hr == -1) {
            return -1;
        }
        if (Math.abs(hl - hr) > 1) {
            return -1;
        }
        return Math.max(hl, hr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}