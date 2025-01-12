// 返回最长回文子串
func longestPalindrome(s string) string {
	if len(s) < 2 {
		return s
	}

	// 最长回文字串的位置
	start, maxLen := 0, 1

	// 考虑回文字串字符数可能是奇数或偶数，所以要分别定义 left 和 right，而不是单纯的一个开始位置。
	expandAroundCenter := func(left, right int) {
		for 0 <= left && right < len(s) && s[left] == s[right] {
			curLen := right - left + 1
			if curLen > maxLen {
				maxLen = curLen
				start = left
			}
			left--
			right++
		}
	}

	for i := 0; i < len(s); i++ {
		expandAroundCenter(i, i)
		expandAroundCenter(i, i+1)
	}

	return s[start : start+maxLen]
}
