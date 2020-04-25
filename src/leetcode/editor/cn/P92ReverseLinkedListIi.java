package leetcode.editor.cn;

//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表


import leetcode.editor.beans.ListNode;

public class P92ReverseLinkedListIi {
    public static void main(String[] arg) {
        Solution solution = new P92ReverseLinkedListIi().new Solution();
        int[] values = {1,2,3,4,5};
        solution.reverseBetween(new ListNode(values), 2, 4);
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
           return head;
        }

        ListNode _head = new ListNode(-1);
        _head.next = head;
        head = _head;

        int index = 0;
        ListNode node = head;
        while (index < m - 1) {
            node = node.next;
            index++;
        }
        ListNode mHead = node;
        ListNode sTail = node.next;

        ListNode pre = sTail;
        ListNode cur = sTail.next;
        index++;
        while (index < n) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            index++;
        }
        sTail.next = cur;
        mHead.next = pre;
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}