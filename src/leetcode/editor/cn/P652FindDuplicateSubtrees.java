package leetcode.editor.cn;

//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。 
//
// 示例 1： 
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// 下面是两个重复的子树： 
//
//       2
//     /
//    4
// 
//
// 和 
//
//     4
// 
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。 
// Related Topics 树


import leetcode.editor.beans.tree.TreeNode;

import java.util.*;

public class P652FindDuplicateSubtrees {
    public static void main(String[] arg) {
        Solution solution = new P652FindDuplicateSubtrees().new Solution();
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

    private Map<String, TreeNode> map;
    private Set<TreeNode> result;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        result = new HashSet<>();
        map = new HashMap<>();
        getSubTreeString(root);
        return new ArrayList<>(result);
    }

    private String getSubTreeString(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String string = root.val + "," + getSubTreeString(root.left) + "," + getSubTreeString(root.right);
        TreeNode listNode = map.get(string);
        if (listNode != null) {
            result.add(listNode);
        } else {
            map.put(string, root);
        }
        return string;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}