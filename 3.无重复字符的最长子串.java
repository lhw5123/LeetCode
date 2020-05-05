import java.util.Map;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int res = 0;

        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                Character d = s.charAt(left);
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }

            res = Math.max(right - left, res);
        }

        return res;
    }
}
// @lc code=end

