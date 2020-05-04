package leetcode.editor.cn;

//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索


import leetcode.editor.beans.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P199BinaryTreeRightSideView {
    public static void main(String[] arg) {
        Solution solution = new P199BinaryTreeRightSideView().new Solution();
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>(), queueNext = new LinkedList<>();
        queue.add(root);

        boolean addFirst = true;
        while (queue.size() > 0) {
            while (queue.size() > 0) {
                TreeNode treeNode = queue.remove();
                if (addFirst) {
                    addFirst = false;
                    result.add(treeNode.val);
                }
                if (treeNode.right != null) {
                    queueNext.add(treeNode.right);
                }
                if (treeNode.left != null) {
                    queueNext.add(treeNode.left);
                }
            }
            addFirst = true;

            // swap
            Queue<TreeNode> temp = queue;
            queue = queueNext;
            queueNext = temp;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}