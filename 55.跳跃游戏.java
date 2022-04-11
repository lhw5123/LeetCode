/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMax = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightMax) {
                rightMax = Math.max(rightMax, nums[i] + i);
                if (rightMax >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

