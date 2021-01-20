/*
 * @lc app=leetcode.cn id=70 lang=golang
 *
 * [70] 爬楼梯
 */

// @lc code=start
func climbStairs(n int) int {
	dp := make([]int, 2)
	dp[0], dp[1] = 1, 1

	for i := 1; i < n; i++ {
		tmp := dp[1]
		dp[1] = dp[0] + dp[1]
		dp[0] = tmp
	}

	return dp[1]
}

// @lc code=end

