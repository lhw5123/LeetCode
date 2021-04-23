/*
 * @lc app=leetcode.cn id=22 lang=golang
 *
 * [22] 括号生成
 */

// @lc code=start
func generateParenthesis(n int) []string {
	var res []string
	if n == 0 {
		return res
	}
	dfs(n, n, "", &res)
	return res
}

// lindex: 左括号剩余个数
// rindex: 右括号剩余个数
func dfs(lcount, rcount int, str string, res *[]string) {
	// 同时等于 0 才表示括号完全匹配了
	if lcount == 0 && rcount == 0 {
		*res = append(*res, str)
		return
	}
	if lcount > 0 {
		dfs(lcount-1, rcount, str+"(", res)
	}
	// 左括号个数小于右括号了，这时就只能用右括号了。
	if rcount > 0 && lcount < rcount {
		dfs(lindex, rindex-1, str+")", res)
	}
}

// @lc code=end

