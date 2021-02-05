/*
 * @lc app=leetcode.cn id=231 lang=golang
 *
 * [231] 2的幂
 */

// @lc code=start
func isPowerOfTwo(n int) bool {
	for n >= 2 {
		if n%2 == 0 {
			n = n / 2
		} else {
			return false
		}
	}
	return n == 1
}

// 位运算
func isPowerOfTwo2(n int) bool {
	return (n > 0 && ((n & (n - 1)) == 0))
}

// @lc code=end

