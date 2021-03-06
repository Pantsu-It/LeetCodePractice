package leetcode.editor.cn;

//给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释:
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
// Related Topics 树 动态规划


import leetcode.editor.beans.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class P95UniqueBinarySearchTreesIi {
    public static void main(String[] arg) {
        Solution solution = new P95UniqueBinarySearchTreesIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return new LinkedList<TreeNode>();
            }
            return generateTrees(1, n);
        }

        public List<TreeNode> generateTrees(int start, int end) {
            List<TreeNode> res = new LinkedList<>();
            // key code
            if (start > end) {
                res.add(null);
                return res;
            }
            for (int i = start; i <= end; i++) {
                List<TreeNode> subLeftTree = generateTrees(start, i - 1);
                List<TreeNode> subRightTree = generateTrees(i + 1, end);
                for (TreeNode left : subLeftTree) {
                    for (TreeNode right : subRightTree) {
                        // key code
                        TreeNode node = new TreeNode(i);
                        node.left = left;
                        node.right = right;
                        res.add(node);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}