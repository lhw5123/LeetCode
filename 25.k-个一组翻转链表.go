/*
 * @lc app=leetcode.cn id=25 lang=golang
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
// 翻转 k 个结点，那被翻转的最后一个结点的索引就是 k - 1。
func reverseKGroup(head *ListNode, k int) *ListNode {
	node := head
	for i := 0; i < k; i++ {
		if node == nil {
			return head
		}
		node = node.Next
	}
	newHead := reverse(head, node)
	head.Next = reverseKGroup(node, k)
	return newHead
}

// 翻转从 first 到 last 部分的链表，如果 for 循环的终止条件是 cur != last，
// 那 last 是不会被翻转的。
func reverse(first *ListNode, last *ListNode) *ListNode {
	var prev *ListNode
	cur := first
	for cur != last {
		next := cur.Next
		cur.Next = prev
		prev = cur
		cur = next
	}
	return prev
}

// @lc code=end

