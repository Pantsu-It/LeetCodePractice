package leetcode.editor.cn;

//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划


import java.util.*;

public class P139WordBreak {
    public static void main(String[] arg) {
        Solution solution = new P139WordBreak().new Solution();
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        solution.wordBreak(s, wordDict);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        LinkedList<Integer> foundList = new LinkedList<>();
        foundList.add(0);
        for (int i = 0; i < s.length(); ++i) {
            Iterator<Integer> iterator = foundList.descendingIterator();
            while (iterator.hasNext()) {
                int start = iterator.next();
                if (dict.contains(s.substring(start, i + 1))) {
                    foundList.add(i + 1);
                    break;
                }
            }
        }
        return foundList.getLast() == s.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}