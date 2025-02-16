/*
 * @lc app=leetcode.cn id=3 lang=golang
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
func lengthOfLongestSubstring(s string) int {
	var (
		res     = 0
		left    = 0
		counter = make(map[rune]uint)
	)

	for right, v := range s {
		counter[v]++
		for counter[v] > 1 {
			counter[rune(s[left])]--
			left++
		}
		res = max(res, right-left+1)
	}

	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// @lc code=end

