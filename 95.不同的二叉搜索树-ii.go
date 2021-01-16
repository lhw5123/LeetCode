/*
 * @lc app=leetcode.cn id=95 lang=golang
 *
 * [95] 不同的二叉搜索树 II
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
func generateTrees(n int) []*TreeNode {
	if n == 0 {
		return []*TreeNode{}
	}
	return genBSTree(1, n)
}

func genBSTree(start, end int) []*TreeNode {
	tree := []*TreeNode{}
	if start > end {
		tree = append(tree, nil)
		return tree
	}

	for i := start; i <= end; i++ {
		left := genBSTree(start, i-1)
		right := genBSTree(i+1, end)
		for _, l := range left {
			for _, r := range right {
				root := &TreeNode{Val: i, Left: l, Right: r}
				tree = append(tree, root)
			}
		}
	}
	return tree
}

// @lc code=end

