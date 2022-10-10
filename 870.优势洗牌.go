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
func advantageCount(nums1 []int, nums2 []int) []int {
    n := len(nums1)
    sort.Ints(nums1)
    sortedNums2 := make([]int, n)
    for i := range sortedNums2 {
        sortedNums2[i] = i
    }
    sort.Slice(sortedNums2, func(i, j int) bool {
        return nums2[sortedNums2[i]] < nums2[sortedNums2[j]]
    })
    useless, i, res := make([]int, 0), 0, make([]int, n)
    for _, index := range sortedNums2 {
        b := nums2[index]
        for i < n && nums1[i] <= b {
            useless = append(useless, nums1[i])
            i++
        }
        if i < n {
            res[index] = nums1[i]
            i++
        } else {
            res[index] = useless[0]
            useless = useless[1:]
        }
    }
    return res
}
// @lc code=end

