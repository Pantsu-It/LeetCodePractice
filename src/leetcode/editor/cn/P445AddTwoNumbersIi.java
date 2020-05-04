package leetcode.editor.cn;

//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表


import leetcode.editor.beans.linkedlist.ListNode;

import java.util.Stack;

public class P445AddTwoNumbersIi {
    public static void main(String[] arg) {
        Solution solution = new P445AddTwoNumbersIi().new Solution();
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode node = l1;
        while (node != null) {
            stack1.push(node.val);
            node = node.next;
        }
        node = l2;
        while (node != null) {
            stack2.push(node.val);
            node = node.next;
        }

        ListNode head = new ListNode(-1);
        boolean hasUpgrade = false;
        int val;
        while (!stack1.isEmpty() || !stack2.isEmpty() || hasUpgrade) {
            val = 0;
            if (!stack1.isEmpty()) {
               val += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                val += stack2.pop();
            }
            if (hasUpgrade) {
                val++;
            }
            hasUpgrade = val >= 10;

            ListNode newNode = new ListNode(val % 10);
            newNode.next = head.next;
            head.next = newNode;
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}