package leetcode.editor.cn;

//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索


import leetcode.editor.beans.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P113PathSumIi {
    public static void main(String[] arg) {
        Solution solution = new P113PathSumIi().new Solution();
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
    private List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        findResult(root, sum, new LinkedList<>());
        return result;
    }

    public void findResult(TreeNode node, int sum, List<Integer> res) {
        if (node == null) {
            return;
        }

        res.add(node.val);

        if (node.left == null && node.right == null) {
            if (node.val == sum) {
                result.add(new ArrayList<>(res));
            }
        } else {
            findResult(node.left, sum - node.val, res);
            findResult(node.right, sum - node.val, res);
        }

        res.remove(res.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}