/*
 * @lc app=leetcode.cn id=121 lang=golang
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
func maxProfit(prices []int) int {
	min := prices[0]
	maxProfit := 0
	for i := 1; i < len(prices); i++ {
		currentProfit := prices[i] - min
		if currentProfit > maxProfit {
			maxProfit = currentProfit
		}
		if prices[i] < min {
			min = prices[i]
		}
	}
	return maxProfit
}

