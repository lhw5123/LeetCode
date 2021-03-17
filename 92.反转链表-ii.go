/*
 * @lc app=leetcode.cn id=92 lang=golang
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
// 第 m 个结点，下标就是 m-1
func reverseBetween(head *ListNode, m int, n int) *ListNode {
	if head == nil || m >= n {
		return head
	}

	newHead := &ListNode{
		Val:  0,
		Next: head,
	}

	pre := newHead
	for i := 0; pre.Next != nil && i < m-1; i++ {
		pre = pre.Next
	}
	if pre.Next == nil {
		return head
	}

	// 难点 - start
	cur := pre.Next // cur = 待反转链表部分的第一个节点
	// pre 一直是不动的，不断向后移动的是 cur 节点
	for i := 0; i < n-m; i++ {
		next := pre.Next
		pre.Next = cur.Next
		cur.Next = cur.Next.Next
		pre.Next.Next = next
	}
	// 难点 - end

	return newHead.Next
}

// @lc code=end

