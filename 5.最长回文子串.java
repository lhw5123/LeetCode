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
        int curLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - curLen - 1, i)) {
                res = s.substring(i - curLen - 1, i + 1);
                curLen += 2;
            } else if (isPalindrome(s, i - curLen, i)) {
                res = s.substring(i - curLen, i+ 1);
                curLen += 1;
            }
        }
        return res;
    }

    private boolean isPalindrome(String s, int left, int right) {
        if (left < 0) {
            return false;
        }

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

