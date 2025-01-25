// 和 55 题的区别：这道题是找到达最后位置的最少跳数，而 55 题是判断能否到达最后位置。
// Constraints:
// 1 <= nums.length <= 104
// 0 <= nums[i] <= 1000
// It's guaranteed that you can reach nums[n - 1].
func jump(nums []int) int {
	minStep := 0
	rightMax := 0
	end := 0 // 当前能到达的最远位置
	// 这道题保证了一定能到达最后一个位置，所以不需要判断是否到达最后一个位置
	for i := 0; i < len(nums)-1; i++ {
		rightMax = max(rightMax, i+nums[i])
		if i == end {
			end = rightMax
			minStep++
		}
	}
	return minStep
}