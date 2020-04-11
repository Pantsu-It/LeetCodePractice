package leetcode.editor.cn;

//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针


import leetcode.editor.beans.ListNode;

public class P234PalindromeLinkedList {
    public static void main(String[] arg) {
        Solution solution = new P234PalindromeLinkedList().new Solution();
        int[] values = {1, 2};
        solution.isPalindrome(new ListNode(values));
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
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

        // 从头尾同时遍历判断
        ListNode left = head;
        while (tail != null) {
            if (left.val != tail.val) {
                return false;
            }
            left = left.next;
            tail = tail.next;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}