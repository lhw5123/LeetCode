func majorityElement(nums []int) int {
  // 摩尔投票法
	candidate := nums[0]
	count := 1

	for i := 1; i < len(nums); i++ {
    if count == 0 {
      candidate = nums[i]
    }
    if nums[i] == candidate {
      count++
    } else {
      count--
    }
	}

	return candidate
}
