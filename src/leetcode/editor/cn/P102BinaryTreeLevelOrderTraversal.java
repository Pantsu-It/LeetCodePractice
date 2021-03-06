package leetcode.editor.cn;

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


import leetcode.editor.beans.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P102BinaryTreeLevelOrderTraversal {
    public static void main(String[] arg) {
        Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> levelOrder(TreeNode root) {
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
            res.add(list);
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