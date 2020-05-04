package leetcode.editor.beans.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] vals) {
        this.val = vals[0];
        ListNode node = this;
        for (int i=1; i<vals.length; ++i) {
            node.next = new ListNode(vals[i]);
            node = node.next;
        }
    }
}
