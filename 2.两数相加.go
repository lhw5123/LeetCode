/*
 * @lc app=leetcode.cn id=2 lang=golang
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	res := &ListNode{}
	cur := res
	carry := 0
	list1 := l1
	list2 := l2
	for list1 != nil || list2 != nil {
		sum := carry
		if list1 != nil {
			sum += list1.Val
			list1 = list1.Next
		}
		if list2 != nil {
			sum += list2.Val
			list2 = list2.Next
		}
		cur.Next = &ListNode{
			Val: sum % 10,
		}
		cur = cur.Next
		carry = sum / 10
	}

	if carry != 0 {
		cur.Next = &ListNode{
			Val: carry,
		}
	}

	return res.Next
}

// @lc code=end

