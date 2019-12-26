import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现strStr()
 */

// @lc code=start
class Solution {
    /**
     * Sunday 解法。
     */
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        int len = needle.length();
        if (len > haystack.length()) {
            return -1;
        }
        // 计算偏移表（偏移表只和模式串，即本题里的 needle 有关）
        HashMap<String, Integer> dic = new HashMap<>();
        for (int i = len - 1; i >= 0; --i) {
            String key = String.valueOf(needle.charAt(i));
            if (!dic.containsKey(key)) {
                dic.put(key, len - i);
            }
        }
        dic.put("ot", len + 1);
        int idx = 0;
        while (idx + len <= haystack.length()) {
            String strCut = haystack.substring(idx, idx + len);
            if (strCut.equals(needle)) {
                return idx;
            } else {
                if (idx + len >= haystack.length()) {
                    return -1;
                }
                // 不匹配，移动 idx。
                String curC = String.valueOf(haystack.charAt(idx + len));
                if (dic.containsKey(String.valueOf(curC))) {
                    idx += dic.get(curC);
                } else {
                    idx += dic.get("ot");
                }
            }
        }
        return idx + len >= haystack.length() ? -1 : idx;
    }
}
// @lc code=end

