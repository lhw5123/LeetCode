import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    // DP
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;   // dp[i] 表示 0 - (i-1) 的字符是 wordDict 中的单词。
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {   // j:单词的分割点。
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) { // substring 的范围 [j, i)
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
// @lc code=end

