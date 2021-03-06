package leetcode.editor.cn;

//给定一个二叉树 
//
// struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数小于 6000 
// -100 <= node.val <= 100 
// 
//
// 
//
// 
// 
// Related Topics 树 深度优先搜索


import java.util.LinkedList;
import java.util.Queue;

public class P117PopulatingNextRightPointersInEachNodeIi {
    public static void main(String[] arg) {
        Solution solution = new P117PopulatingNextRightPointersInEachNodeIi().new Solution();
    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public Node connect(Node root) {
            Queue<Node> queue = new LinkedList<>(), queueChild = new LinkedList<>();
            if (root != null) {
                queue.add(root);
            }
            while (!queue.isEmpty()) {
                Node lastNode = null;
                while (!queue.isEmpty()) {
                    Node node = queue.remove();
                    if (lastNode != null) {
                        lastNode.next = node;
                    }
                    lastNode = node;

                    if (node.left != null) {
                        queueChild.add(node.left);
                    }
                    if (node.right != null) {
                        queueChild.add(node.right);
                    }
                }
                // swap
                Queue temp = queue;
                queue = queueChild;
                queueChild = temp;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}