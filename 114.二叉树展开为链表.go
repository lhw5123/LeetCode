/*
 * @lc app=leetcode.cn id=114 lang=golang
 *
 * [114] 二叉树展开为链表
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
// 思路：倒序遍历：右左根。
// 把两边子树都变成单链的。
func flatten(root *TreeNode) {
	if root == nil {
		return
	}

	flatten(root.Right)
	flatten(root.Left)

	curRight := root.Right
	root.Right = root.Left
	root.Left = nil
	// 找到最右边的子结点
	for root.Right != nil {
		root = root.Right
	}
	root.Right = curRight
}

// @lc code=end

