/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    // Note: 一个数和自己做异或，结果是 0；而一个数和 0 做异或，结果是自己。
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res = res ^ n;
        }
        return res;
    }
}
// @lc code=end

