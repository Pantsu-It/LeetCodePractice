package leetcode.editor.cn;

//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表


import leetcode.editor.beans.ListNode;

public class P83RemoveDuplicatesFromSortedList {
    public static void main(String[] arg) {
        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
        int[] values = {1,1,2};
        solution.deleteDuplicates(new ListNode(values));
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
        if (head == null || head.next == null) {
            return head;
        }
        // 先定循环，再根据第一次遍历，设定初始条件
        // 初始条件
        int lastVal = head.val;
        ListNode node = head;
        // 循环
        while (node.next != null) {
            if (node.next.val == lastVal) {
                node.next = node.next.next;
            } else {
                node = node.next;
                lastVal = node.val;
            }
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}