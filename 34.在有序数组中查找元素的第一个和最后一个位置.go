func searchRange(nums []int, target int) []int {
	start := lowerBound(nums, target)
	if start == len(nums) || nums[start] != target {
		return [-1, -1]
	}
	end := lowerBound(nums, target+1)-1
	return [start, end]
}

// 找指定数字在数组中的下界
func lowerBound(nums []int, target int) int {
	// 基于闭区间实现 [left, right]
	var (
		left = 0
		right = len(nums)-1
	)

	for left <= right {	// 区间不为空
		mid := left + (right-left)>>1
		if nums[mid] < target {
			left = mid+1
		} else {
			right = mid-1
		}
	}
	return left	// 如果数组中不存在 target，最后 left 会等于数组长度
}
