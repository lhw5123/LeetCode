import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isMatch(String s, String p) {
        return dp(s, 0, p, 0);
    }

    private boolean dp(String s, int i, String p, int j) {
        int m = s.length(), n = p.length();

        if (j == n) {
            return i == m;
        }

        if (i == m) {
            // 字符串 s 已经匹配完了，但 p 还有剩余，则必须是 'a*a*...' 这样的格式。
            if ((n - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean res = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2);
            } else {
                res = false;
            }
        }
        memo.put(key, res);
        return res;
    }
}
// @lc code=end
