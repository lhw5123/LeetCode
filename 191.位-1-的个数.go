/*
 * @lc app=leetcode.cn id=191 lang=golang
 *
 * [191] 位1的个数
 */

// @lc code=start
func hammingWeight(num uint32) int {
	res := 0
	for num != 0 {
		num = num & (num - 1) // 取并的结果是将这个数的二进制最后一位不为 0 的位给置 0。
		res++
	}
	return res
}

// @lc code=end

