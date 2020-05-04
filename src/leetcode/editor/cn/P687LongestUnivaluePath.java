package leetcode.editor.cn;

//给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。 
//
// 注意：两个节点之间的路径长度由它们之间的边数表示。 
//
// 示例 1: 
//
// 输入: 
//
// 
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 示例 2: 
//
// 输入: 
//
// 
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。 
// Related Topics 树 递归


import leetcode.editor.beans.tree.TreeNode;

public class P687LongestUnivaluePath {
    public static void main(String[] arg) {
        Solution solution = new P687LongestUnivaluePath().new Solution();
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
    int maxLen = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxLen = 0;
        findNodes(root);
        return maxLen;
    }

    private int findNodes(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftSame = findNodes(root.left);
        int rightSame = findNodes(root.right);

        if (root.left == null || root.left.val != root.val) {
            leftSame = 0;
        } else {
            leftSame += 1;
        }
        if (root.right == null || root.right.val != root.val) {
            rightSame = 0;
        } else {
            rightSame += 1;
        }
        if (leftSame > 0 || rightSame > 0) {
            if (leftSame > 0 && rightSame > 0) {
                int len = leftSame + rightSame;
                if (len > maxLen) {
                    maxLen = len;
                }
            }
            int len = Math.max(leftSame, rightSame);
            if (len > maxLen) {
                maxLen = len;
            }
            return len;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}