/*
 * @lc app=leetcode.cn id=217 lang=golang
 *
 * [217] 存在重复元素
 */

// @lc code=start
func containsDuplicate(nums []int) bool {
	record := make(map[int]bool, len(nums))
	for _, v := range nums {
		if _, ok := record[v]; ok {
			return true
		}
		record[v] = true
	}
	return false
}

// @lc code=end

