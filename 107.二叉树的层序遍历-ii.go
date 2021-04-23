/*
 * @lc app=leetcode.cn id=107 lang=golang
 *
 * [107] 二叉树的层序遍历 II
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
func levelOrderBottom(root *TreeNode) [][]int {
	res := make([][]int, 0)
	dfs(root, 0, &res)

	// reverse res
	for i := 0; i < len(res)/2; i++ {
		res[i], res[len(res)-i-1] = res[len(res)-i-1], res[i]
	}

	return res
}

func dfs(root *TreeNode, level int, list *[][]int) {
	if root == nil {
		return
	}

	if len(*list) < level+1 {
		*list = append(*list, make([]int, 0))
	}

	(*list)[level] = append((*list)[level], root.Val)
	dfs(root.Left, level+1, list)
	dfs(root.Right, level+1, list)
}

// @lc code=end

