import "math"

/*
 * @lc app=leetcode.cn id=53 lang=golang
 *
 * [53] 最大子序和
 */

// @lc code=start
func maxSubArray(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	dp := make([]int, len(nums))
	dp[0] = nums[0] // base case
	for i := 1; i < len(nums); i++ {
		if nums[i] < dp[i-1]+nums[i] {
			dp[i] = dp[i-1] + nums[i]
		} else {
			dp[i] = nums[i]
		}
	}

	res := math.MinInt64
	for _, v := range dp {
		if v > res {
			res = v
		}
	}
	return res
}

// @lc code=end

