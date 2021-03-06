package leetcode.editor.cn;

//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表


import leetcode.editor.beans.linkedlist.ListNode;

public class P82RemoveDuplicatesFromSortedListIi {
    public static void main(String[] arg) {
        Solution solution = new P82RemoveDuplicatesFromSortedListIi().new Solution();
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
    public ListNode deleteDuplicates(ListNode head) {
        // 构造虚假链表头
        ListNode _head = new ListNode(Integer.MAX_VALUE);
        _head.next = head;
        head = _head;

        ListNode pre = head;
        int val;
        boolean hasSame;
        while (pre.next != null) {
            ListNode node = pre.next;
            val = node.val;
            hasSame = false;
            while (node.next != null && node.next.val == val) {
                node = node.next;
                hasSame = true;
            }
            if (hasSame) {
                pre.next = node.next;
            } else {
                pre = node;
            }
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}