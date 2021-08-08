/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        // 因为 nums 中同时存在正、负数，所以需要同时记录下最小值。
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = max, mn = min;
            max = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            min = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            res = Math.max(max, res);
        }
        return res;
    }
}
// @lc code=end

