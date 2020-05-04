package leetcode.editor.cn;

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表


import leetcode.editor.beans.linkedlist.ListNode;

public class P24SwapNodesInPairs {
    public static void main(String[] arg) {
        Solution solution = new P24SwapNodesInPairs().new Solution();
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
    public ListNode swapPairs(ListNode head) {
        ListNode _head = new ListNode(-1);
        _head.next = head;
        head = _head;

        ListNode cur = head;
        while (cur.next != null && cur.next.next != null) {
            ListNode node = cur.next.next.next;
            cur.next.next.next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next.next;
            cur.next = node;
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}