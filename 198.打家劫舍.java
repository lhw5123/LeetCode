/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[2];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int temp = dp[1];
            dp[1] = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = temp;
        }

        return dp[1];
    }
}
// @lc code=end

