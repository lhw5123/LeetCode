/*
 * @lc app=leetcode.cn id=429 lang=golang
 *
 * [429] N 叉树的层序遍历
 */

// @lc code=start
/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

func levelOrder(root *Node) [][]int {
	res := [][]int{}
	queue := []*Node{}
	if root != nil {
		queue = append(queue, root)
	}
	curLevelNum, nextLevelNum := 1, 0
	tmp := []int{}
	for len(queue) > 0 {
		if curLevelNum > 0 {
			node := queue[0]
			tmp = append(tmp, node.Val)
			queue = append(queue, node.Children...)
			nextLevelNum += len(node.Children)
			queue = queue[1:]
			curLevelNum--
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

