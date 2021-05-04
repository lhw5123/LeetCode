/*
 * @lc app=leetcode.cn id=543 lang=golang
 *
 * [543] 二叉树的直径
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
// DFS
func diameterOfBinaryTree(root *TreeNode) int {
	ans := 0
	dfs(root, &ans)
	return ans
}

func dfs(node *TreeNode, ans *int) int {
	if node == nil {
		return 0
	}

	l := dfs(node.Left, ans)
	r := dfs(node.Right, ans)
	*ans = max(*ans, l+r)
	return max(l, r) + 1
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// @lc code=end

