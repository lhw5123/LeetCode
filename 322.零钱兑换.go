/*
 * @lc app=leetcode.cn id=322 lang=golang
 *
 * [322] 零钱兑换
 */

// @lc code=start
// 动态规划。
// 思路：从 1 -> amount，用 dp table 依次记录下来凑成各个金额的可能数。
func coinChange(coins []int, amount int) int {
	dp := make([]int, amount+1)
	for i := 1; i < len(dp); i++ {
		dp[i] = amount + 1
	}

	for i := 1; i <= amount; i++ {
		for _, c := range coins {
			if c <= i {
				if dp[i] > dp[i-c]+1 {
					dp[i] = dp[i-c] + 1
				}
			}
		}
	}

	if dp[amount] == amount+1 {
		return -1
	}

	return dp[amount]
}
