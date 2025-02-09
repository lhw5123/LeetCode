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
func reverseKGroup(head *ListNode, k int) *ListNode {
	dummy := &ListNode{Next: head}
	prev := dummy

	for {
		node := prev.Next
		for i := 0; i < k; i++ {
			if node == nil {
				return dummy.Next
			}
			node = node.Next
		}

		curr := prev.Next
		next := curr.Next
		for i := 0; i < k-1; i++ {
			temp := next.Next
			next.Next = curr
			curr = next
			next = temp
		}

		// set `prev` to next section starter
		temp := prev.Next
		prev.Next.Next = next
		prev.Next = curr
		prev = temp
	}
}

// @lc code=end

// 如果不足 k 个的部分也要反转呢？
func reverseKGroup2(head *ListNode, k int) *ListNode {
	dummy := &ListNode{Next: head}
	prev := dummy

	for {
		node := prev.Next
		reverseCount := k - 1
		for i := 0; i < k; i++ {
			if node == nil {
				reverseCount = i
				break
			}
			node = node.Next
		}

		curr := prev.Next
		next := curr.Next
		for i := 0; i < reverseCount; i++ {
			temp := next.Next
			next.Next = curr
			curr = next
			next = temp
		}

		// set `prev` to next section starter
		temp := prev.Next
		prev.Next.Next = next
		prev.Next = curr
		prev = temp
		if prev == nil {
			return dummy.Next
		}
	}
}

