package leetcode.editor.cn;

//给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 
//
// 示例 1： 
//输入: 
//
//   5
// /  \
//2   -3
// 
//
// 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。 
//
// 示例 2： 
//输入： 
//
//   5
// /  \
//2   -5
// 
//
// 返回 [2]，只有 2 出现两次，-5 只出现 1 次。 
//
// 
//
// 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。 
// Related Topics 树 哈希表


import leetcode.editor.beans.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P508MostFrequentSubtreeSum {
    public static void main(String[] arg) {
        Solution solution = new P508MostFrequentSubtreeSum().new Solution();
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
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> frequent = new HashMap<>();
        findSum(root, frequent);

        int maxF = 0;
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequent.entrySet()) {
            if (entry.getValue() > maxF) {
                maxF = entry.getValue();
                res.clear();
                res.add(entry.getKey());
            } else if (entry.getValue() == maxF) {
                res.add(entry.getKey());
            }
        }
        int[] r = new int[res.size()];
        int i = 0;
        for (int num : res) {
            r[i++] = num;
        }
        return r;
    }

    public int findSum(TreeNode node, Map<Integer, Integer> frequent) {
        if (node == null) {
            return 0;
        }
        int sum = node.val;
        sum += findSum(node.left, frequent);
        sum += findSum(node.right, frequent);

        Integer f = frequent.get(sum);
        if (f == null) {
            frequent.put(sum, 1);
        } else {
            frequent.put(sum, f + 1);
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}