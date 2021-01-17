import "math"

/*
 * @lc app=leetcode.cn id=98 lang=golang
 *
 * [98] 验证二叉搜索树
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
func isValidBST(root *TreeNode) bool {
	return isValidBstHelper(root, math.Inf(-1), math.Inf(1))
}

func isValidBstHelper(root *TreeNode, min, max float64) bool {
	if root == nil {
		return true
	}
	v := float64(root.Val)
	return v > min && v < max && isValidBstHelper(root.Left, min, v) && isValidBstHelper(root.Right, v, max)
}

// @lc code=end

