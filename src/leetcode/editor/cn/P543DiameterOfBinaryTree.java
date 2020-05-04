package leetcode.editor.cn;

//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树


import leetcode.editor.beans.tree.TreeNode;

public class P543DiameterOfBinaryTree {
    public static void main(String[] arg) {
        Solution solution = new P543DiameterOfBinaryTree().new Solution();
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
    int maxLen;

    public int diameterOfBinaryTree(TreeNode root) {
        maxLen = 0;
        maxHeight(root);
        return maxLen;
    }

    public int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }

        int left = maxHeight(root.left);
        int right = maxHeight(root.right);

        int len = left + right;
        if (root.left != null) {
            len++;
        }
        if (root.right != null) {
            len++;
        }

        if (maxLen < len) {
            maxLen = len;
        }
        return Math.max(left, right) + ((root.left != null || root.right != null) ? 1 : 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}