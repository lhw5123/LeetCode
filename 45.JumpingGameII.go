// 和 55 题的区别：这道题是找到达最后位置的最少跳数，而 55 题是判断能否到达最后位置。
func jump(nums []int) int {
	minStep := 0
	rightMax := 0
	end := 0 // 当前能到达的最远位置
	for i := 0; i < len(nums)-1; i++ {
		rightMax = max(rightMax, i+nums[i])
		if i == end {
			end = rightMax
			minStep++
		}
	}
	return minStep
}