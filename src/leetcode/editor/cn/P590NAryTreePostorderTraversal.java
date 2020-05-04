package leetcode.editor.cn;

//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


import leetcode.editor.beans.tree.Node;

import java.util.LinkedList;
import java.util.List;

public class P590NAryTreePostorderTraversal {
    public static void main(String[] arg) {
        Solution solution = new P590NAryTreePostorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new LinkedList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.children == null) {
            return;
        }
        for(Node child : root.children) {
            postorder(child, result);
        }
        result.add(root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}