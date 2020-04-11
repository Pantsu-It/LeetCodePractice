package leetcode.editor.cn;

//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表


import leetcode.editor.beans.ListNode;

public class P143ReorderList {
    public static void main(String[] arg) {
        Solution solution = new P143ReorderList().new Solution();
        int[] values = {1,2,3,4, 5};
        solution.reorderList(new ListNode(values));
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode node = head;
        ListNode tail = null;
        int count = 0;
        while (node != null) {
            // 找到尾巴
            if (node.next == null) {
                tail = node;
            }
            ++count;
            node = node.next;
        }
        if (count < 2) {
            return;
        }
        int half = (count +1) / 2;

        // 从中点开始反转链表，找到尾部
        ListNode last = null, cur = head;
        while (cur != null) {
            if (count >= half) {
                last = cur;
                cur = cur.next;
            } else {
                // 防止中点产生环形
                if (last.next == cur) {
                    last.next = null;
                }
                ListNode next = cur.next;
                cur.next = last;
                last = cur;
                cur = next;
            }
            --count;
        }

        // 从头尾同时遍历合并
        ListNode left = head;
        while (tail.next != null) {
            ListNode leftNext = left.next;
            ListNode tailNext = tail.next;
            left.next = tail;
            tail.next = leftNext;
            left = tail;
            tail = tailNext;

            left = left.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}