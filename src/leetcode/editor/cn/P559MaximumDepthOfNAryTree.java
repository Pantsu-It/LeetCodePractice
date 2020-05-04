package leetcode.editor.cn;

//给定一个 N 叉树，找到其最大深度。 
//
// 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 我们应返回其最大深度，3。 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总不会超过 5000。 
// Related Topics 树 深度优先搜索 广度优先搜索


import leetcode.editor.beans.tree.Node;

import java.util.List;

public class P559MaximumDepthOfNAryTree {
    public static void main(String[] arg) {
        Solution solution = new P559MaximumDepthOfNAryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.size() == 0) {
            return 1;
        }
        int height = 0;
        for (Node node : root.children) {
            int cHeight = maxDepth(node);
            if (cHeight > height) {
                height = cHeight;
            }
        }
        return height + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}