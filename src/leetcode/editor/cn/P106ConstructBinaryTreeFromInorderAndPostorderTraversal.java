package leetcode.editor.cn;

//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组


import leetcode.editor.beans.tree.TreeNode;

public class P106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] arg) {
        Solution solution = new P106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int[] inorder, int postLeft, int postRight, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        // 在post右侧找到根节点
        TreeNode root = new TreeNode(postorder[postRight]);
        // 在in中找到根节点，用于划分左右子树
        int inRoot = inLeft;
        while (inRoot <= inRight && inorder[inRoot] != postorder[postRight]) {
            inRoot++;
        }
        int left = inRoot - inLeft;
        root.left = buildTree(postorder, inorder, postLeft, postLeft + left - 1, inLeft, inRoot - 1);
        root.right = buildTree(postorder, inorder, postLeft + left, postRight - 1, inRoot + 1, inRight);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}