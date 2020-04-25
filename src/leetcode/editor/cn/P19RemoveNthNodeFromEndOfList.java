package leetcode.editor.cn;

//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针


import leetcode.editor.beans.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P19RemoveNthNodeFromEndOfList {
    public static void main(String[] arg) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
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

    /**
     * 使用一遍遍历（双向链表 保持size=n）
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode _head = new ListNode(-1);
        _head.next = head;
        head = _head;

        int count = 0;
        LinkedList<ListNode> list = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
            count++;
            // 保存最后n+1个节点
            if (count > n + 1) {
                list.removeFirst();
            }
        }
        ListNode parent = list.getFirst();
        parent.next = parent.next.next;

        return head.next;
    }

    /**
     * 使用两遍遍历
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        int target = count - n;
        if (target == 0) {
            head = head.next;
            return head;
        }
        ListNode cur = head;
        int index = 1;
        while (cur.next != null) {
            if (index == target) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
            index++;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}