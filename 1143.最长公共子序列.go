/*
 * @lc app=leetcode.cn id=1143 lang=golang
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
// 动态规划
func longestCommonSubsequence(text1 string, text2 string) int {
	len1 := len(text1)
	len2 := len(text2)
	dp := make([][]int, len1+1) // dp[i][j] 表示对于 text1[0..i-1] 和 text2[0..j-1] 的 LCS 长度
	for i := 0; i < len1+1; i++ {
		dp[i] = make([]int, len2+1)
	}

	for i := 1; i <= len1; i++ {
		for j := 1; j <= len2; j++ {
			if text1[i-1] == text2[j-1] {
				dp[i][j] = dp[i-1][j-1] + 1
			} else {
				dp[i][j] = max(dp[i-1][j], dp[i][j-1])
			}
		}
	}

	return dp[len1][len2]
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// @lc code=end

