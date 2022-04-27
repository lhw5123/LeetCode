/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        int n1 = version1.length(), n2 = version2.length();
        int p1 = 0, p2 = 0;

        while (p1 < n1 || p2 < n2) {
            Pair<Integer, Integer> chunk1 = getNextChunk(version1, n1, p1);
            int i1 = chunk1.getKey();
            p1 = chunk1.getValue();

            Pair<Integer, Integer> chunk2 = getNextChunk(version2, n2, p2);
            int i2 = chunk2.getKey();
            p2 = chunk2.getValue();

            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        return 0;
    }

    // 获得 p 开始所在位置的值，以及下一个部分的起始位置
    private Pair<Integer, Integer> getNextChunk(String version, int n, int p) {
        if (p > n - 1) {
            return new Pair(0, p);
        }

        int i = 0, pEnd = p;
        while (pEnd < n && version.charAt(pEnd) != '.') {
            pEnd++;
        }
        i = Integer.parseInt(version.substring(p, pEnd));

        return new Pair(i, pEnd + 1);
    }
}
// @lc code=end

