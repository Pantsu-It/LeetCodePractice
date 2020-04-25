package leetcode.editor.cn;

//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 深度优先搜索 链表


import leetcode.editor.beans.ListNode;
import leetcode.editor.beans.TreeNode;


public class P109ConvertSortedListToBinarySearchTree {
    public static void main(String[] arg) {
        Solution solution = new P109ConvertSortedListToBinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode middleNode = findMiddleNode(head);
        TreeNode parentNode = new TreeNode(middleNode.val);
        parentNode.left = sortedListToBST(head);
        parentNode.right = sortedListToBST(middleNode.next);
        return parentNode;
    }

    public ListNode findMiddleNode(ListNode head) {
        ListNode preNode = null;
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            preNode = slowNode;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        if (preNode != null) {
            preNode.next = null;
        }
        return slowNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}