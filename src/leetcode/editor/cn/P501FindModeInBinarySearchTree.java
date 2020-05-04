package leetcode.editor.cn;

//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树


import leetcode.editor.beans.tree.TreeNode;

import java.util.*;

public class P501FindModeInBinarySearchTree {
    public static void main(String[] arg) {
        Solution solution = new P501FindModeInBinarySearchTree().new Solution();
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
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        Stack<TreeNode> stack = new Stack<>();
        pushNode(root, stack);

        Map<Integer, Integer> map = new HashMap<>();
        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            pushNode(node.right, stack);

            Integer count = map.get(node.val);
            if (count == null) {
                map.put(node.val, 1);
            } else {
                map.put(node.val, count + 1);
            }
        }
        int maxCount = 0;
        List<Integer> list = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                list.clear();
                list.add(entry.getKey());
            } else if (entry.getValue() == maxCount) {
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int num : list) {
            res[i++] = num;
        }
        return res;
    }

    public void pushNode(TreeNode root, Stack<TreeNode> stack) {
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}