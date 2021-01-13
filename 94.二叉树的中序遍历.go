/*
 * @lc app=leetcode.cn id=94 lang=golang
 *
 * [94] 二叉树的中序遍历
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
func inorderTraversal(root *TreeNode) []int {
	var result []int
	inorder(root, &result)
	return result
}

// 递归解法
func inorder(root *TreeNode, output *[]int) {
	if root != nil {
		inorder(root.Left, output)
		*output = append(*output, root.Val)
		inorder(root.Right, output)
	}
}

// @lc code=end

