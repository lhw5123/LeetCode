/*
 * @lc app=leetcode.cn id=191 lang=golang
 *
 * [191] 位1的个数
 */

// @lc code=start
func hammingWeight(num uint32) int {
	tmp := num
	res := 0
	for tmp != 0 {
		if tmp&1 == 1 {
			res++
		}
		tmp >>= 1
	}
	return res
}

// @lc code=end

