package leetcode.editor.cn;

//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表


import leetcode.editor.beans.ListNode;

public class P21MergeTwoSortedLists {
    public static void main(String[] arg) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null || l2 != null) {
            while (l1 != null && (l2 == null || l1.val < l2.val)) {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            }
            while (l2 != null && (l1 == null || l1.val >= l2.val)) {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}