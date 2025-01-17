/*
 * @lc app=leetcode.cn id=26 lang=golang
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
func removeDuplicates(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	slow := 1
	for i := 1; i < len(nums); i++ {
		if nums[i] != nums[slow-1] {
			nums[slow] = nums[i]
			slow++
		}
	}

	return slow
}

// @lc code=end

