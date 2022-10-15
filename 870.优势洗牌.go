/*
 * @lc app=leetcode.cn id=870 lang=golang
 *
 * [870] 优势洗牌
 *
 * https://leetcode.cn/problems/advantage-shuffle/description/
 *
 * algorithms
 * Medium (48.92%)
 * Likes:    315
 * Dislikes: 0
 * Total Accepted:    49.6K
 * Total Submissions: 101.4K
 * Testcase Example:  '[2,7,11,15]\n[1,10,4,11]'
 *
 * 给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i
 * 的数目来描述。
 *
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 *
 *
 * 示例 2：
 *
 *
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1 <= nums1.length <= 10^5
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 10^9
 *
 *
 */

// @lc code=start
// 贪心算法
// 因为是相对于 B 的最大优势，所以 B 数组是不能变的。
func advantageCount(A []int, B []int) []int {
	n := len(A)
	sort.Ints(A)
	sortedB := make([]int, n) // 存储 B 中的元素下标
	for i := range sortedB {
		sortedB[i] = i
	}
	// 这样排序之后，sortedB 中存储的就是 B 中元素从小到大排列时的元素下标
	sort.Slice(sortedB, func(i, j int) bool {
		return B[sortedB[i]] < B[sortedB[j]]
	})

	useless, iA, res := make([]int, 0), 0, make([]int, n)
	for _, i := range sortedB {
		// 这里为什么是 <= ？
		// 因为这道题里对“优势”的定义是 A[i] > B[i]
		for iA < n && A[iA] <= B[i] {
			useless = append(useless, A[iA])
			iA++
		}
		if iA < n {
			res[i] = A[iA]
			iA++
		} else {
			res[i] = useless[0]
			useless = useless[1:]
		}
	}
	return res
}

// @lc code=end

