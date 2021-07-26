import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为K的子数组
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int start = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int right = i;
            int sum = nums[right];
            if (sum == k) {
                res++;
            }
            while (++right < len) {
                sum += nums[right];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

