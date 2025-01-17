// 和 26 题不同在于，这道题允许保留最多两个相同元素。
func removeDuplicates(nums []int) int {
	if len(nums) <= 2 {
		return len(nums)
	}

	slow := 2
	for i := 2; i < len(nums); i++ {
		if nums[i] != nums[slow] {
			nums[slow] = nums[i]
			slow++
		}
	}

	return slow
}