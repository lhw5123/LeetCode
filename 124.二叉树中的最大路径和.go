import "math"

/*
 * @lc app=leetcode.cn id=124 lang=golang
 *
 * [124] 二叉树中的最大路径和
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
func maxPathSum(root *TreeNode) int {
	if root == nil {
		return 0
	}

	max := math.MinInt32
	_ = oneSideMax(root, &max)
	return max
}

func oneSideMax(root *TreeNode, maxSum *int) int {
	if root == nil {
		return 0
	}

	left := oneSideMax(root.Left, maxSum)
	right := oneSideMax(root.Right, maxSum)

	curMax := max(max(left+root.Val, right+root.Val), root.Val)
	*maxSum = max(*maxSum, max(curMax, left+right+root.Val))
	return curMax
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// @lc code=end

