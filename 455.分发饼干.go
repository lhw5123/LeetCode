/*
 * @lc app=leetcode.cn id=455 lang=golang
 *
 * [455] 分发饼干
 */

// @lc code=start
// 背包问题
func findContentChildren(g []int, s []int) int {
	sort.Ints(g)
	sort.Ints(s)
	n, m := len(g), len(s) // n: 孩子的数量；m: 饼干的数量

	ans := 0
	// 为每个孩子找到刚好满足其胃口的饼干
	for i, j := 0, 0; i < n && j < m; i++ {
		for j < m && g[i] > s[j] {
			j++
		}
		if j < m {
			ans++
			j++
		}
	}
	return ans
}

// @lc code=end

