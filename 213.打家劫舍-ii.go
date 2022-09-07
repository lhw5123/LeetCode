/*
 * @lc app=leetcode.cn id=213 lang=golang
 *
 * [213] 打家劫舍 II
 *
 * https://leetcode.cn/problems/house-robber-ii/description/
 *
 * algorithms
 * Medium (43.92%)
 * Likes:    1159
 * Dislikes: 0
 * Total Accepted:    280.6K
 * Total Submissions: 638.9K
 * Testcase Example:  '[2,3,2]'
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈
 * ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 *
 * 示例 2：
 *
 *
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 3：
 *
 *
 * 输入：nums = [1,2,3]
 * 输出：3
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 *
 */

// @lc code=start
func rob(nums []int) int {
	n := len(nums)
	if n == 0 {
		return 0
	}
	if n == 1 {
		return nums[0]
	}
	if n == 2 {
		return max(nums[0], nums[1])
	}
	// 因为是一个环，所以要比较 [0, n-1], [1, n] 这两个区间的最大值
	return max(rob213(nums, 0, n-2), rob213(nums, 1, n-1))
}

func rob213(nums []int, start, end int) int {
	preMax := nums[start]
	curMax := max(preMax, nums[start+1])
	for i := start + 2; i <= end; i++ {
		tmp := curMax
		curMax = max(curMax, nums[i]+preMax)
		preMax = tmp
	}
	return curMax
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// @lc code=end

