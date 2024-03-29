/*
 * @lc app=leetcode.cn id=57 lang=golang
 *
 * [57] 插入区间
 *
 * https://leetcode.cn/problems/insert-interval/description/
 *
 * algorithms
 * Medium (42.45%)
 * Likes:    782
 * Dislikes: 0
 * Total Accepted:    165.7K
 * Total Submissions: 390.3K
 * Testcase Example:  '[[1,3],[6,9]]\n[2,5]'
 *
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 *
 *
 * 示例 2：
 *
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * 示例 3：
 *
 *
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 *
 *
 * 示例 4：
 *
 *
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 *
 *
 * 示例 5：
 *
 *
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 *
 *
 *
 *
 * 提示：
 *
 *
 * 0
 * intervals[i].length == 2
 * 0
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0
 *
 *
 */

// @lc code=start
func insert(intervals [][]int, newInterval []int) [][]int {
	res := make([][]int, 0)
	if len(intervals) == 0 {
		res = append(res, newInterval)
		return res
	}

	curIndex := 0
	for curIndex < len(intervals) && intervals[curIndex][1] < newInterval[0] {
		res = append(res, intervals[curIndex])
		curIndex++
	}

	for curIndex < len(intervals) && intervals[curIndex][0] <= newInterval[1] {
		newInterval = []int{min(newInterval[0], intervals[curIndex][0]), max(newInterval[1], intervals[curIndex][1])}
		curIndex++
	}
	res = append(res, newInterval)

	for curIndex < len(intervals) {
		res = append(res, intervals[curIndex])
		curIndex++
	}

	return res
}

func min(a int, b int) int {
	if a < b {
		return a
	}
	return b
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

// @lc code=end

