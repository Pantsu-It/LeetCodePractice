package leetcode.editor.cn;

//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索


import leetcode.editor.beans.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P257BinaryTreePaths {
    public static void main(String[] arg) {
        Solution solution = new P257BinaryTreePaths().new Solution();
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
    private List<String> result;

    public List<String> binaryTreePaths(TreeNode root) {
        result = new LinkedList<>();

        binaryTreePaths(root, new ArrayList<>());
        return result;
    }

    private void binaryTreePaths(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.left == null && node.right == null) {
            result.add(getString(list));
        } else {
            binaryTreePaths(node.left, list);
            binaryTreePaths(node.right, list);
        }
        list.remove(list.size() - 1);
    }

    private static final String s = "->";

    private String getString(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(list.get(0));
        if (list.size() == 1) {
            return stringBuilder.toString();
        }
        for (int i=1; i< list.size(); ++i) {
            stringBuilder.append(s);
            stringBuilder.append(list.get(i));
        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}