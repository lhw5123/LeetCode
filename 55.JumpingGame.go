// 贪心算法
func canJump(nums []int) bool {
	rightMax := 0
	for i := 0; i < len(nums); i++ {
		if i <= rightMax {
			rightMax = max(rightMax, i+nums[i])
			if rightMax >= len(nums)-1 {
				return true
			}
		}
	}
	return false
}