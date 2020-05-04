package leetcode.editor.cn;

//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组


import leetcode.editor.beans.tree.TreeNode;

public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] arg) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        private TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
            if (preLeft > preRight || inLeft > inRight) {
                return null;
            }
            // 在pre左侧找到根节点
            TreeNode root = new TreeNode(preorder[preLeft]);
            // 在in中找到根节点，用于划分左右子树
            int inRoot = inLeft;
            while (inRoot <= inRight && inorder[inRoot] != preorder[preLeft]) {
                inRoot++;
            }
            int left = inRoot - inLeft;
            root.left = buildTree(preorder, inorder, preLeft + 1, preLeft + left, inLeft, inRoot - 1);
            root.right = buildTree(preorder, inorder, preLeft + left + 1, preRight, inRoot + 1, inRight);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}