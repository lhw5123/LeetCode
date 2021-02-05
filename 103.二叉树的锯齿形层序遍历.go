/*
 * @lc app=leetcode.cn id=103 lang=golang
 *
 * [103] 二叉树的锯齿形层序遍历
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
func zigzagLevelOrder(root *TreeNode) [][]int {
	var res [][]int
	search(root, 0, &res)
	return res
}

// 先根遍历
func search(root *TreeNode, depth int, res *[][]int) {
	if root == nil {
		return
	}

	for len(*res) < depth+1 {
		*res = append(*res, []int{})
	}

	if depth%2 == 0 {
		(*res)[depth] = append((*res)[depth], root.Val)
	} else {
		(*res)[depth] = append([]int{root.Val}, (*res)[depth]...)
	}

	search(root.Left, depth+1, res)
	search(root.Right, depth+1, res)
}

// @lc code=end

