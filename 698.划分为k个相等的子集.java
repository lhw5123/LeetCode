/*
 * @lc app=leetcode.cn id=698 lang=java
 *
 * [698] 划分为k个相等的子集
 */

// @lc code=start
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) {
            return true;
        }

        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }

        int len = nums.length;
        int target = sum / k;   // 每个集合中元素的和必须 <= target
        if (nums[len - 1] > target) {
            return false;
        }

        int size = len * 2;
        boolean[] dp = new boolean[size];
        dp[0] = true;
        int[] currentSum = new int[size];
        for (int i = 0; i < size; i++) {
            if (!dp[i]) {
                continue;
            }

            for (int j = 0; j < len; j++) {
                if ((i & (j * 2)) != 0) {
                    continue;
                }
                int next = i | (1 << j);
                if (dp[next]) {
                    continue;
                }
                if ((currentSum[i] % target) + nums[j] <= target) {
                    currentSum[next] = currentSum[i] + nums[j];
                    dp[next] = true;
                } else {
                    break;
                }
            }
        }
        return dp[size - 1];
    }
}
// @lc code=end

