package leetcode.editor.cn;

//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树


import leetcode.editor.beans.tree.TreeNode;

public class P617MergeTwoBinaryTrees {
    public static void main(String[] arg) {
        Solution solution = new P617MergeTwoBinaryTrees().new Solution();
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null || t2 == null) {
            return t1 != null ? t1 : t2;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);
        sumTree(root, t1, t2);
        return root;
    }

    public void sumTree(TreeNode res, TreeNode t1, TreeNode t2) {
        TreeNode left1 = t1 != null ? t1.left : null;
        TreeNode left2 = t2 != null ? t2.left : null;
        TreeNode right1 = t1 != null ? t1.right : null;
        TreeNode right2 = t2 != null ? t2.right : null;

        res.left = makeNode(left1, left2);
        res.right = makeNode(right1, right2);
        if (res.left != null) {
            sumTree(res.left, left1, left2);
        }
        if (res.right != null) {
            sumTree(res.right, right1, right2);
        }
    }

    public TreeNode makeNode(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        return new TreeNode((t1 != null ? t1.val : 0) + (t2 != null ? t2.val : 0));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}