/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int dp_0 = nums[0]; // dp_0 代表以上一个数字结尾的最大子数组和
        int res = dp_0;
        for (int i = 1; i < nums.length; ++i) {
            dp_0 = Math.max(dp_0 + nums[i], nums[i]);
            res = Math.max(res, dp_0);
        }
        return res;
    }
}
// @lc code=end

