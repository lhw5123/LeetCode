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
	if len(s) == 0 {
		return 0
	}

	left, right := 0, 0 // 若都初始化为 0，则窗口部分为 [left, right)。如果是这样，那 window 的长度就是 right-left
	result := 0
	table := make([]int, 256)

	for left < len(s) {
		if right < len(s) && table[s[right]-'a'] == 0 {
			table[s[right]-'a']++
			right++
		} else {
			table[s[left]-'a']--
			left++
		}
		result = max(result, right-left)
	}

	return result
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// @lc code=end

