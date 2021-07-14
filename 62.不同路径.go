/*
 * @lc app=leetcode.cn id=62 lang=golang
 *
 * [62] 不同路径
 */

// @lc code=start
func uniquePaths(m int, n int) int {
	var dp [][]int

	for y := 0; y < m; y++ {
		arr := make([]int, n)
		arr[0] = 1
		dp = append(dp, arr)
	}

	for x := 0; x < n; x++ {
		dp[0][x] = 1
	}

	for x := 1; x < n; x++ {
		for y := 1; y < m; y++ {
			dp[y][x] = dp[y-1][x] + dp[y][x-1]
		}
	}

	return dp[m-1][n-1]
}

// @lc code=end

