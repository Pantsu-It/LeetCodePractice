package leetcode.editor.cn;

//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组. 
//
// 示例 1: 
//
// 输入:
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出: [3, 14.5, 11]
//解释:
//第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
// 
//
// 注意： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树


import leetcode.editor.beans.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P637AverageOfLevelsInBinaryTree {
    public static void main(String[] arg) {
        Solution solution = new P637AverageOfLevelsInBinaryTree().new Solution();
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>(), queueNext = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            double sum = 0;
            int count = 0;
            while (queue.size() > 0) {
                TreeNode treeNode = queue.remove();
                if (treeNode.right != null) {
                    queueNext.add(treeNode.right);
                }
                if (treeNode.left != null) {
                    queueNext.add(treeNode.left);
                }

                sum += treeNode.val;
                count++;
            }
            result.add(sum / count);

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