package leetcode.editor.cn;

//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针。。


import leetcode.editor.beans.ListNode;

public class P86PartitionList {
    public static void main(String[] arg) {
        Solution solution = new P86PartitionList().new Solution();
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
    public ListNode partition(ListNode head, int x) {
        ListNode _head = new ListNode(-1);
        _head.next = head;
        head = _head;

        ListNode newHead = new ListNode(-1);
        ListNode newPre = newHead;

        ListNode pre = head, cur = head.next;
        while (cur != null) {
            if (cur.val < x) {
                pre.next = cur.next;
                cur.next = null;

                newPre.next = cur;
                newPre = newPre.next;

                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        newPre.next = head.next;
        return newHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}