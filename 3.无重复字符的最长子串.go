/*
 * @lc app=leetcode.cn id=3 lang=golang
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
// tag: 滑动窗口
func lengthOfLongestSubstring(s string) int {
	if len(s) == 0 {
		return 0
	}

	var freq [256]int // 用来统计字符的出现次数
	res, left, right := 0, 0, -1
	for left < len(s) {
		if right+1 < len(s) && freq[s[right+1]-'a'] == 0 {
			freq[s[right+1]-'a']++
			right++
		} else {
			freq[s[left]-'a']--
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

