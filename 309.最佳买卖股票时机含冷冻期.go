import "math"

/*
 * @lc app=leetcode.cn id=309 lang=golang
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
func maxProfit(prices []int) int {
	n := len(prices)
	dp_i_0 := 0 // 结尾的 0 和 1 表示当前有没有持有股票
	dp_i_1 := math.MinInt8
	dp_pre_0 := 0 // 代表 dp[i-2][0]

	for i := 0; i < n; i++ {
		temp := dp_i_0
		dp_i_0 = max(dp_i_0, dp_i_1+prices[i])
		dp_i_1 = max(dp_i_1, dp_pre_0-prices[i])
		dp_pre_0 = temp
	}

	return dp_i_0
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// @lc code=end

