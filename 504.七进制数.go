/*
 * @lc app=leetcode.cn id=504 lang=golang
 *
 * [504] 七进制数
 */

// @lc code=start
func convertToBase7(num int) string {
	if num == 0 {
		return "0"
	}

	res := ""
	tmp := num
	negative := false
	if tmp < 0 {
		negative = true
		tmp = -tmp
	}

	for tmp != 0 {
		res = strconv.Itoa(tmp%7) + res
		tmp /= 7
	}
	if negative {
		res = "-" + res
	}
	return res
}

// @lc code=end

