/*
 * @lc app=leetcode.cn id=109 lang=golang
 *
 * [109] 有序链表转换二叉搜索树
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var gHead *ListNode

func sortedListToBST(head *ListNode) *TreeNode {
	gHead = head
	len := 0
	p := head
	for p != nil {
		len++
		p = p.Next
	}
	return buildTree(0, len-1)
}

func buildTree(left, right int) *TreeNode {
	if left > right {
		return nil
	}

	mid := left + (right-left)/2
	root := &TreeNode{}
	root.Left = buildTree(left, mid-1)
	root.Val = gHead.Val
	gHead = gHead.Next
	root.Right = buildTree(mid+1, right)
	return root
}

// @lc code=end

