/*
 * @lc app=leetcode.cn id=202 lang=golang
 *
 * [202] 快乐数
 */

// @lc code=start
func isHappy(n int) bool {
	if n == 0 {
		return false
	}

	res := 0
	num := n
	record := map[int]int{}
	for {
		for num != 0 {
			res += (num % 10) * (num % 10)
			num /= 10
		}
		if res == 1 {
			return true
		}
		if _, ok := record[res]; ok {
			return false
		}
		record[res] = res
		num = res
		res = 0
	}
}

// @lc code=end

