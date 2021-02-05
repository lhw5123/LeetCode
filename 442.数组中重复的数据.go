/*
 * @lc app=leetcode.cn id=442 lang=golang
 *
 * [442] 数组中重复的数据
 */

// @lc code=start
func findDuplicates(nums []int) []int {
	// 原地标记
	var res []int
	for _, num := range nums {
		numAbs := abs(num)
		if nums[numAbs-1] > 0 {
			nums[numAbs-1] *= -1
		} else {
			res = append(res, numAbs)
		}
	}

	return res
}

func abs(num int) int {
	if num >= 0 {
		return num
	}
	return -1 * num
}

// @lc code=end

