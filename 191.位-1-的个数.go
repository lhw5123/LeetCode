/*
 * @lc app=leetcode.cn id=191 lang=golang
 *
 * [191] 位1的个数
 */

// @lc code=start
func hammingWeight(num uint32) int {
	count := 0
	tmp := num
	for tmp != 0 {
		if tmp&1 == 1 {
			count++
		}
		tmp >>= 1
	}
	return count
}

// @lc code=end

