/*
 * @lc app=leetcode.cn id=14 lang=golang
 *
 * [14] 最长公共前缀
 */

// @lc code=start
func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {
		return ""
	}

	substr := strs[0]
	for i := 1; i < len(strs); i++ {
		for strings.Index(strs[i], substr) != 0 {
			substr = substr[:len(substr)-1]
			if substr == "" {
				break
			}
		}
	}

	return substr
}

// @lc code=end

