/*
 * @lc app=leetcode.cn id=102 lang=golang
 *
 * [102] 二叉树的层序遍历
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
func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}

	queue := []*TreeNode{}
	queue = append(queue, root)
	curLevelNum, nextLevelNum := 1, 0
	res, tmp := [][]int{}, []int{}
	for len(queue) > 0 {
		if curLevelNum > 0 {
			node := queue[0]
			if node.Left != nil {
				queue = append(queue, node.Left)
				nextLevelNum++
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
				nextLevelNum++
			}
			curLevelNum--
			tmp = append(tmp, node.Val)
			queue = queue[1:]
		}
		if curLevelNum == 0 {
			res = append(res, tmp)
			curLevelNum = nextLevelNum
			nextLevelNum = 0
			tmp = []int{}
		}
	}

	return res
}

// @lc code=end

