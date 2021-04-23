/*
 * @lc app=leetcode.cn id=101 lang=golang
 *
 * [101] 对称二叉树
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
// 将左子树翻转，再和又子树比较是否相同。
func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}

	return isSameTree(invertTree(root.Left), root.Right)
}

func isSameTree(p, q *TreeNode) bool {
	if p == nil && q == nil {
		return true
	}

	if p != nil && q != nil {
		if p.Val != q.Val {
			return false
		}
		return isSameTree(p.Left, q.Left) && isSameTree(p.Right, q.Right)
	}

	return false
}

func invertTree(root *TreeNode) *TreeNode {
	if root != nil {
		invertTree(root.Left)
		invertTree(root.Right)
		tmp := root.Left
		root.Left = root.Right
		root.Right = tmp
	}
	return root
}

// @lc code=end

