/*
 * @lc app=leetcode.cn id=1171 lang=golang
 *
 * [1171] 从链表中删去总和值为零的连续节点
 *
 * https://leetcode.cn/problems/remove-zero-sum-consecutive-nodes-from-linked-list/description/
 *
 * algorithms
 * Medium (48.20%)
 * Likes:    177
 * Dislikes: 0
 * Total Accepted:    18K
 * Total Submissions: 37.3K
 * Testcase Example:  '[1,2,-3,3,1]'
 *
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 *
 * 删除完毕后，请你返回最终结果链表的头节点。
 *
 *
 *
 * 你可以返回任何满足题目要求的答案。
 *
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 *
 * 示例 1：
 *
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 *
 *
 * 示例 3：
 *
 * 输入：head = [1,2,3,-3,-2]
 * 输出：[1]
 *
 *
 *
 *
 * 提示：
 *
 *
 * 给你的链表中可能有 1 到 1000 个节点。
 * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
 *
 *
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeZeroSumSublists(head *ListNode) *ListNode {
	sum, sumMap, cur := 0, make(map[int]*ListNode), head
	sumMap[0] = nil
	for cur != nil {
		sum += cur.Val // 从 head 到当前元素值的和
		// 如果链表中间有一段总和为 0 的连续节点[start,end]，那 sum(list[:start]) 就会等于 sum(list[:end+1])
		if ptr, ok := sumMap[sum]; !ok {
			sumMap[sum] = cur
		} else {
			// [ptr, cur] 之间节点的和为零。
			if ptr == nil {
				// 意味着是从链表头到 cur 都是要被删除的部分
				head = cur.Next
				sumMap = make(map[int]*ListNode)
				sumMap[0] = nil
			} else {
				iter := ptr.Next
				tmpSum := sum + iter.Val
				for tmpSum != sum {
					delete(sumMap, tmpSum)
					iter = iter.Next
					tmpSum += iter.Val
				}
				ptr.Next = cur.Next
			}
		}

		// if ptr, ok := sumMap[sum]; ok {
		// 在字典中找到了重复的和，代表 [ptr, cur] 中间的是和为 0 的段，我们要删除的就是这段。
		// if ptr != nil {
		// 	iter := ptr.Next
		// 	tmpSum := sum + iter.Val
		// 	for tmpSum != sum {
		// 		delete(sumMap, tmpSum)
		// 		iter = iter.Next
		// 		tmpSum = tmpSum + iter.Val
		// 	}
		// 	ptr.Next = cur.Next
		// } else {
		// 	head = cur.Next
		// 	sumMap = make(map[int]*ListNode)
		// 	sumMap[0] = nil
		// }
		// } else {
		// 	sumMap[sum] = cur
		// }

		cur = cur.Next
	}
	return head
}

// @lc code=end

