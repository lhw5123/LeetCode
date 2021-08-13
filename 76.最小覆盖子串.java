import java.util.HashMap;
import java.util.Map;

import org.graalvm.compiler.nodes.calc.RightShiftNode;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    private Map<Character, Integer> windowCharCount = new HashMap<>();
    private Map<Character, Integer> tCharCount = new HashMap<>();

    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            tCharCount.put(t.charAt(i), tCharCount.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0, r = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (r < s.length()) {
            char c = s.charAt(r);
            r++;
            windowCharCount.put(c, windowCharCount.getOrDefault(c, 0) + 1);
            while (check()) {
                if (r - l < len) {
                    start = l;
                    len = r - l;
                } 
                char lc = s.charAt(l);
                l++;
                windowCharCount.put(lc, windowCharCount.get(lc) - 1);
            }
        }

        if (len == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + len);
    }

    private boolean check() {
        for (Map.Entry<Character, Integer> entry : tCharCount.entrySet()) {
            if (entry.getValue() > windowCharCount.getOrDefault(entry.getKey(), 0)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
