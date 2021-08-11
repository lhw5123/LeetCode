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
        for (int i = 0; i < 2 * len - 1; i++) {
            int l = i / 2;
            int r = i / 2 + i % 2;
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }
        }
        return res;
    }
}
// @lc code=end

