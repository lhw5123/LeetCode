/*
 * @lc app=leetcode.cn id=42 lang=golang
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (56.45%)
 * Likes:    2482
 * Dislikes: 0
 * Total Accepted:    272.9K
 * Total Submissions: 483.3K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 *
 * 示例 2：
 *
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 *
 *
 *
 * 提示：
 *
 *
 * n == height.length
 * 0
 * 0
 *
 *
 */

// @lc code=start
func trap(height []int) int {
	l, r := 0, len(height)-1
	lMax, rMax := height[l], height[r]
	res := 0
	for l < r {
		if height[l] > lMax {
			lMax = height[l]
		}
		if height[r] > rMax {
			rMax = height[r]
		}

		if rMax > lMax {
			res += (lMax - height[l])
			l++
		} else {
			res += (rMax - height[r])
			r--
		}
	}
	return res
}

// @lc code=end

