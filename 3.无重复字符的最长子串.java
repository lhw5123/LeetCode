import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 * 
 * 子串是连续的。
 * 
 * Tips：滑动窗口。
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;

        while (right < s.length()) {
            Character c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.get(c) > 1) {
                Character d = s.charAt(left);
                map.put(d, map.get(d) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }
}
// @lc code=end

