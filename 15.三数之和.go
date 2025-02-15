import "sort"

/*
 * @lc app=leetcode.cn id=15 lang=golang
 *
 * [15] 三数之和
 */

// @lc code=start
// 思路：双指针。排序之后遍历 nums，对于其中的每个元素，再用类似两数之和的思路去找有没有和是 -index 的。
func threeSum(nums []int) [][]int {
	sort.Ints(nums)

	var (
		res = make([][]int, 0)
		n   = len(nums)
	)

	for i := 0; i < n-2; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		if nums[i]+nums[i+1]+nums[i+2] > 0 {
			break
		}
		if nums[i]+nums[n-2]+nums[n-1] < 0 {
			continue
		}

		left, right := i+1, n-1
		for left < right {
			s := nums[i] + nums[left] + nums[right]
			if s > 0 {
				right--
			} else if s < 0 {
				left++
			} else {
				res = append(res, []int{nums[i], nums[left], nums[right]})
				left++
				for left < right && nums[left] == nums[left-1] {
					left++
				}
				right--
				for left < right && nums[right] == nums[right+1] {
					right--
				}
			}
		}
	}

	return res
}

// @lc code=end

