func twoSum(numbers []int, target int) []int {
	var (
		left  = 0
		right = len(numbers) - 1
	)

	for left < right {
		tmp := numbers[left] + numbers[right]
		if tmp == target {
			break
		} else if tmp > target {
			right--
		} else {
			left++
		}
	}

	return []int{left + 1, right + 1}
}