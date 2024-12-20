/*
 * @lc app=leetcode.cn id=11 lang=golang
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
func maxArea(height []int) int {
  var (
    left = 0
    right = len(height) - 1
    res = 0
  )

  for left < right {
    width := right - left
    high := 0
    if height[left] < height[right] {
      high = height[left]
      left++
    } else {
      high = height[right]
      right--
    }
    res = max(res, width * high)
  }

  return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// @lc code=end

