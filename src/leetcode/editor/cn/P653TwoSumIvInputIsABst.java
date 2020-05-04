package leetcode.editor.cn;

//给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。 
//
// 案例 1: 
//
// 
//输入: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 9
//
//输出: True
// 
//
// 
//
// 案例 2: 
//
// 
//输入: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 28
//
//输出: False
// 
//
// 
// Related Topics 树


import leetcode.editor.beans.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class P653TwoSumIvInputIsABst {
    public static void main(String[] arg) {
        Solution solution = new P653TwoSumIvInputIsABst().new Solution();
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
    private Set<Integer> set = new HashSet<>();

    // 方法1：利用HashSet，通过递归或BFS遍历
    // 方法2：利用inorder转换BFT为数组，再使用双指针逼近
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}