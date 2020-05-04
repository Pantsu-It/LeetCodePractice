package leetcode.editor.cn;

//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
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
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索


import leetcode.editor.beans.tree.TreeNode;

import java.util.*;

public class P103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] arg) {
        Solution solution = new P103BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>(), queueChild = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        List<List<Integer>> res = new LinkedList<>();
        boolean normalOrder = true;
        while (!queue.isEmpty()) {
            // key code：By Iterator to avoid influence at next level
            List<Integer> list = new ArrayList<>(queue.size());
            Iterator<TreeNode> iterator = normalOrder ? queue.iterator() : queue.descendingIterator();
            while (iterator.hasNext()) {
                list.add(iterator.next().val);
            }
            res.add(list);

            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queueChild.add(node.left);
                }
                if (node.right != null) {
                    queueChild.add(node.right);
                }
            }
            // change order
            normalOrder = !normalOrder;
            // swap
            Deque temp = queue;
            queue = queueChild;
            queueChild = temp;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}