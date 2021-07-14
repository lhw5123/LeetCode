/*
 * @lc app=leetcode.cn id=76 lang=golang
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
// 滑动窗口
func minWindow(s string, t string) string {
	// Go 里面的字符串其实就是 byte 数组。
	// 每一个 byte 对应一个字符 char。
	ori, cnt := map[byte]int{}, map[byte]int{}
	// 记录 t 中存在的各字符个数。
	for i := 0; i < len(t); i++ {
		ori[t[i]]++
	}

	sLen := len(s)
	minLen := math.MaxInt32
	ansL, ansR := -1, -1

	// 检查当前遍历的字符串是否完全包含了字符串 t。
	check := func() bool {
		for k, v := range ori {
			if cnt[k] < v {
				return false
			}
		}
		return true
	}

	// 这里遍历的是整个 s 字符串
	for l, r := 0, 0; r < sLen; r++ {
		if r < sLen && ori[s[r]] > 0 {
			cnt[s[r]]++
		}
		for check() && l <= r {
			if r-l+1 < minLen {
				minLen = r - l + 1
				ansL, ansR = l, l+minLen
			}
			if _, ok := ori[s[l]]; ok {
				cnt[s[l]] -= 1
			}
			l++
		}
	}
	if ansL == -1 {
		return ""
	}
	return s[ansL:ansR]
}

// @lc code=end

