import "container/list"

/*
 * @lc app=leetcode.cn id=144 lang=golang
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preorderTraversal(root *TreeNode) []int {
	output := make([]int, 0)
	if root == nil {
		return output
	}

	stack := list.New()
	stack.PushFront(root)

	for stack.Len() > 0 {
		element := stack.Front()
		node := element.Value.(*TreeNode)
		stack.Remove(element)
		output = append(output, node.Val)
		if node.Right != nil {
			stack.PushFront(node.Right)
		}
		if node.Left != nil {
			stack.PushFront(node.Left)
		}
	}

	return output
}

// @lc code=end

