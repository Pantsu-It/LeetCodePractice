package leetcode.editor.cn;

//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针


import leetcode.editor.beans.linkedlist.ListNode;

public class P61RotateList {
    public static void main(String[] arg) {
        Solution solution = new P61RotateList().new Solution();
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int count = 0;
        ListNode node = head;
        ListNode tail = null;
        while (node != null) {
            if (node.next == null) {
                tail = node;
            }
            node = node.next;
            count++;
        }
        k %= count;
        if (k == 0) {
            return head;
        }
        tail.next = head;

        int target = count - k;
        int index = 1;
        ListNode cur = head;
        while (index < target) {
            cur = cur.next;
            index++;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}