package leetcode.editor.cn;

//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表


import leetcode.editor.beans.linkedlist.ListNode;

public class P148SortList {
    public static void main(String[] arg) {
        Solution solution = new P148SortList().new Solution();
        int[] values = {4,2,1,3};
        solution.sortList(new ListNode(values));
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
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode middle = findMiddleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(middle);
        return mergeListNode(left, right);
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

    public ListNode mergeListNode(ListNode left, ListNode right) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (left != null || right != null) {
            while (left != null && (right == null || right.val > left.val)) {
                node.next = left;
                node = left;
                left = left.next;
            }
            while (right != null && (left == null || left.val >= right.val)) {
                node.next = right;
                node = right;
                right = right.next;
            }
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}