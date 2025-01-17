// 原地删除 nums 中所有等于 val 的值，并返回不等于 val 值的数量。
func removeElement(nums []int, val int) int {
	slow := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != val {
			nums[slow] = nums[i]
		}
	}
	return slow
}
