package leetcode.editor.cn;

//给定一个二叉树，原地将它展开为链表。 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索


import leetcode.editor.beans.tree.TreeNode;

public class P114FlattenBinaryTreeToLinkedList {
    public static void main(String[] arg) {
        Solution solution = new P114FlattenBinaryTreeToLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root != null) {
            flattenReturnTail(root);
        }
    }

    public TreeNode flattenReturnTail(TreeNode node) {
        TreeNode leftTail = null;
        if (node.left != null) {
            leftTail = flattenReturnTail(node.left);
        }
        TreeNode rightTail = null;
        if (node.right != null) {
            rightTail = flattenReturnTail(node.right);
        }

        if (leftTail == null) {
            return rightTail != null ? rightTail : node;
        } else if (rightTail == null) {
            node.right = node.left;
            node.left = null;
            return leftTail != null  ? leftTail : node;
        } else {
            TreeNode right = node.right;
            node.right = node.left;
            node.left = null;
            leftTail.right = right;
            return rightTail;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}