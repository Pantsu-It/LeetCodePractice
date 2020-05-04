package leetcode.editor.cn;

//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索


import leetcode.editor.beans.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P107BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] arg) {
        Solution solution = new P107BinaryTreeLevelOrderTraversalIi().new Solution();
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>(), queueChild = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        List<List<Integer>> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>(queue.size());
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                list.add(node.val);

                if (node.left != null) {
                    queueChild.add(node.left);
                }
                if (node.right != null) {
                    queueChild.add(node.right);
                }
            }
            res.add(0, list);
            // swap
            Queue temp = queue;
            queue = queueChild;
            queueChild = temp;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}