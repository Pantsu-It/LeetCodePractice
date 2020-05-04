package leetcode.editor.cn;

//请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。 
//
// 
//
// 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。 
//
// 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。 
//
// 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。 
//
// 
//
// 提示： 
//
// 
// 给定的两颗树可能会有 1 到 200 个结点。 
// 给定的两颗树上的值介于 0 到 200 之间。 
// 
// Related Topics 树 深度优先搜索


import leetcode.editor.beans.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class P872LeafSimilarTrees {
    public static void main(String[] arg) {
        Solution solution = new P872LeafSimilarTrees().new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode2.left = new TreeNode(2);
        solution.leafSimilar(treeNode, treeNode2);
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves = new LinkedList<>();
        findLeaves(root1, leaves);
        boolean checkResult = checkLeaves(root2, leaves);
        return checkResult && leaves.size() == 0;
    }

    private boolean checkLeaves(TreeNode node, List<Integer> list) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            if (list.size() > 0 && list.get(0) == node.val) {
                list.remove(0);
                return true;
            }
            return false;
        }
        return checkLeaves(node.left, list) && checkLeaves(node.right, list);
    }

    public void findLeaves(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        findLeaves(node.left, list);
        findLeaves(node.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}