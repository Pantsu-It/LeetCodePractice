package leetcode.editor.cn;

//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划


public class P96UniqueBinarySearchTrees {
    public static void main(String[] arg) {
        Solution solution = new P96UniqueBinarySearchTrees().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
        if (n < 0) {
            return 0;
        }
        if (n==0) {
            return 1;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int i = 1; i <= n; ++i) {
            int count = 0;
            for (int j=0; j<i; ++j) {
                count += res[j] * res[i-j - 1];
            }
            res[i] = count;
        }
        return res[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}