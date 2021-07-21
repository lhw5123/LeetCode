import java.util.ArrayList;
import java.util.List;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {
    private List<String> ans;
    private int[] segments;
    private final int SEG_COUNT = 4;

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) {
            return new ArrayList<>();
        }

        segments = new int[SEG_COUNT];
        ans = new ArrayList<>();
        dfs(s, 0, 0);
        return ans;
    }

    private void dfs(String s, int segIndex, int segStart) {
        if (segIndex == SEG_COUNT) {
            if (segStart == s.length()) {
                String ipAddr = segments[0] + "";
                for (int i = 1; i < SEG_COUNT; i++) {
                    ipAddr += ("." + segments[i]);
                }
                ans.add(ipAddr);
            }
            return;
        }

        if (segStart == s.length()) {
            return;
        }

        if (s.charAt(segStart) == '0') {
            segments[segIndex] = 0;
            dfs(s, segIndex + 1, segStart + 1);
        }

        // 表示当前这一部分的地址
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 255) {
                segments[segIndex] = addr;
                dfs(s, segIndex + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
// @lc code=end

