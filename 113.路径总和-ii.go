/*
 * @lc app=leetcode.cn id=113 lang=golang
 *
 * [113] 路径总和 II
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
func pathSum(root *TreeNode, targetSum int) [][]int {
	var ans [][]int // 声明的是切片
	var path []int
	dfs(root, targetSum, path, &ans)
	return ans
}

func dfs(root *TreeNode, target int, path []int, ans *[][]int) {
	if root == nil {
		return
	}

	if root.Left == nil && root.Right == nil {
		// is leaf
		if root.Val == target {
			path = append(path, root.Val)
			*ans = append(*ans, append([]int{}, path...))
		}
		return
	}

	path = append(path, root.Val)
	newSum := target - root.Val
	dfs(root.Left, newSum, path, ans)
	dfs(root.Right, newSum, path, ans)
}

// @lc code=end

