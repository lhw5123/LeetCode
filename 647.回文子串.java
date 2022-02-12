/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            res += count(s, i, i);  // 回文子串长度是奇数
            res += count(s, i, i + 1);  // 回文子串长度是偶数
        }
        return res;
    }

    private int count(String s, int start, int end) {
        int len = s.length();
        int count = 0;
        while (start >= 0 && end < len && s.charAt(start) == s.charAt(end)) {
            count++;
            // 从中心扩展，因此是 start--，end++
            start--;
            end++;
        }
        return count;
    }
}
// @lc code=end

