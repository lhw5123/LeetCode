/*
 * @lc app=leetcode.cn id=3 lang=golang
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
// tag: 滑动窗口
// 返回的是最长字串的长度
// 思考路径：
// 首先想到滑动窗口，即定义 left, right 两个指针，[left, right) 即为 window。
// 再思考什么情况会使 window 扩大和缩小。
func lengthOfLongestSubstring(s string) int {
	if len(s) <= 1 {
		return len(s)
	}

	table := make([]int, 256)
	left, right := 0, 0 // 滑动窗口初始大小是 0
	res := 0
	for left < len(s) {
		if right < len(s) && table[s[right]-'a'] == 0 {
			table[s[right]-'a']++
			right++
		} else { // 出现了重复字符
			table[s[left]-'a']--
			left++
		}

		res = max(res, right-left)
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

