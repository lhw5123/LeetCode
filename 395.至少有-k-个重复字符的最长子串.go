/*
 * @lc app=leetcode.cn id=395 lang=golang
 *
 * [395] 至少有 K 个重复字符的最长子串
 *
 * https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/description/
 *
 * algorithms
 * Medium (52.65%)
 * Likes:    758
 * Dislikes: 0
 * Total Accepted:    76.4K
 * Total Submissions: 145.1K
 * Testcase Example:  '"aaabb"\n3'
 *
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 *
 *
 * 示例 2：
 *
 *
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 *
 *
 * 提示：
 *
 *
 * 1
 * s 仅由小写英文字母组成
 * 1
 *
 *
 */

// @lc code=start
// 递归
func longestSubstring(s string, k int) int {
	if len(s) == 0 {
		return 0
	}

	freq, split, res := [26]int{}, byte(0), 0
	for _, c := range s {
		freq[c-'a']++
	}

	for i, c := range freq {
		if 0 < c && c < k {
			split = 'a' + byte(i)
			break
		}
	}
	if split == 0 {
		return len(s)
	}

	for _, subStr := range strings.Split(s, string(split)) {
		res = max(res, longestSubstring(subStr, k))
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

