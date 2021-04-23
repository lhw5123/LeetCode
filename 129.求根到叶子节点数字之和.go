/*
 * @lc app=leetcode.cn id=129 lang=golang
 *
 * [129] 求根到叶子节点数字之和
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
// 时间复杂度：O(N)
// 空间复杂度：O(N)
func sumNumbers(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return dfs(root, 0)
}

// 前序遍历
func dfs(node *TreeNode, cumsum int) int {
	if node == nil {
		return 0
	}

	cumsum = cumsum*10 + node.Val
	if node.Left == nil && node.Right == nil {
		return cumsum
	}
	return dfs(node.Left, cumsum) + dfs(node.Right, cumsum)
}
