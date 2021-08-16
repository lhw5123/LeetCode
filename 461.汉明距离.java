/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
    // 通过亦或运算符将问题转化为「求位 1 的个数」。
    public int hammingDistance(int x, int y) {
        int res = 0;
        int s = x ^ y;  // 异或操作：相同的位置为 0，不同的位置为 1
        while (s != 0) {
            res += s & 1;
            s >>= 1;
        }
        return res;
    }
}
// @lc code=end

