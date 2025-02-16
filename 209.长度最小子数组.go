func minSubArrayLen(target int, nums []int) int {
	n := len(nums)
	res := n + 1
	s := 0
	left := 0

	for right, v := range nums {
		s += v
		for s >= target {
			res = min(res, right-left+1)
			s -= nums[left]
			left++
		}
	}

	if res < n+1 {
		return res
	}
	return 0
}