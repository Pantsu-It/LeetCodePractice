package leetcode.editor.cn;

//给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节
//点值之和。 
//
// 
//
// 例如： 
//
// 输入: 原始二叉搜索树:
//              5
//            /   \
//           2     13
//
//输出: 转换为累加树:
//             18
//            /   \
//          20     13
// 
//
// 
//
// 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-s
//um-tree/ 相同 
// Related Topics 树


import leetcode.editor.beans.tree.TreeNode;

import java.util.*;

public class P538ConvertBstToGreaterTree {
    public static void main(String[] arg) {
        Solution solution = new P538ConvertBstToGreaterTree().new Solution();
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
    public TreeNode convertBST(TreeNode root) {
        Deque<TreeNode> linkedList = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        pushStack(root, stack);

        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            pushStack(node.right, stack);

            linkedList.add(node);
        }
        int sum = 0;
        Iterator<TreeNode> descIterator = linkedList.descendingIterator();
        while (descIterator.hasNext()) {
            TreeNode node = descIterator.next();
            sum += node.val;
            node.val = sum;
        }
        return root;
    }

    public void pushStack(TreeNode node, Stack<TreeNode> stack) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}