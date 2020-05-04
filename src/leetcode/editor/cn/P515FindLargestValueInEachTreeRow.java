package leetcode.editor.cn;

//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索


import leetcode.editor.beans.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P515FindLargestValueInEachTreeRow {
    public static void main(String[] arg) {
        Solution solution = new P515FindLargestValueInEachTreeRow().new Solution();
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>(), queueChild = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Integer max = null;
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (max == null || max < node.val) {
                    max = node.val;
                }

                if (node.left != null) {
                    queueChild.add(node.left);
                }
                if (node.right != null) {
                    queueChild.add(node.right);
                }
            }
            if (max != null) {
                res.add(max);
            }
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