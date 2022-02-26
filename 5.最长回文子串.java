/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);    // 回文子串长度是奇数（aba）
            String s2 = palindrome(s, i, i + 1);    // 回文子串长度是偶数（abba）
            res = res.length() < s1.length() ? s1 : res;
            res = res.length() < s2.length() ? s2 : res;
        }
        return res;
    }

    private String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
// @lc code=end

