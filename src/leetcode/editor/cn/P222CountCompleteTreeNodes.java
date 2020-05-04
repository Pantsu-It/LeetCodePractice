package leetcode.editor.cn;

//给出一个完全二叉树，求出该树的节点个数。 
//
// 说明： 
//
// 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为
//第 h 层，则该层包含 1~ 2h 个节点。 
//
// 示例: 
//
// 输入: 
//    1
//   / \
//  2   3
// / \  /
//4  5 6
//
//输出: 6 
// Related Topics 树 二分查找


import leetcode.editor.beans.tree.TreeNode;

public class P222CountCompleteTreeNodes {
    public static void main(String[] arg) {
        Solution solution = new P222CountCompleteTreeNodes().new Solution();
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
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = countLevel(root.left);
            int right = countLevel(root.right);
            if (left == right) {
                // 左侧满二叉树+根节点 + 计算右侧
                return (1 << left) + countNodes(root.right);
            } else {
                // 计算左侧 + 右侧满二叉树+根节点
                return countNodes(root.left) + (1 << right);
            }
        }

        private int countLevel(TreeNode root) {
            int level = 0;
            while (root != null) {
                level++;
                root = root.left;
            }
            return level;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}