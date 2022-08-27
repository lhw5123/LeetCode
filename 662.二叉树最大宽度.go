/*
 * @lc app=leetcode.cn id=662 lang=golang
 *
 * [662] 二叉树最大宽度
 *
 * https://leetcode.cn/problems/maximum-width-of-binary-tree/description/
 *
 * algorithms
 * Medium (41.27%)
 * Likes:    473
 * Dislikes: 0
 * Total Accepted:    68.1K
 * Total Submissions: 159.4K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 *
 * 树的 最大宽度 是所有层中最大的 宽度 。
 *
 *
 *
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的
 * null 节点，这些 null 节点也计入长度。
 *
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,3,2,5,3,null,9]
 * 输出：4
 * 解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
 *
 *
 * 示例 2：
 *
 *
 * 输入：root = [1,3,2,5,null,null,9,6,null,7]
 * 输出：7
 * 解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
 *
 *
 * 示例 3：
 *
 *
 * 输入：root = [1,3,2,5]
 * 输出：2
 * 解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
 *
 *
 *
 *
 * 提示：
 *
 *
 * 树中节点的数目范围是 [1, 3000]
 * -100 <= Node.val <= 100
 *
 *
 *
 *
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
func widthOfBinaryTree(root *TreeNode) int {
	if root == nil {
		return 0
	}
	if root.Left == nil && root.Right == nil {
		return 1
	}

	// BFS
	queue, res := []*TreeNode{}, 0
	queue = append(queue, &TreeNode{0, root.Left, root.Right})
	for len(queue) > 0 {
		var left, right *int
		qLen := len(queue)
		for i := 0; i < qLen; i++ {
			node := queue[0]
			queue = queue[1:]
			if node.Left != nil {
				newVal := node.Val * 2 // 根据满二叉树的性质，得到下一层节点在本层的编号
				queue = append(queue, &TreeNode{newVal, node.Left.Left, node.Left.Right})
				if left == nil || *left > newVal {
					left = &newVal
				}
				if right == nil || *right < newVal {
					right = &newVal
				}
			}
			if node.Right != nil {
				newVal := node.Val*2 + 1
				queue = append(queue, &TreeNode{newVal, node.Right.Left, node.Right.Right})
				if left == nil || *left > newVal {
					left = &newVal
				}
				if right == nil || *right < newVal {
					right = &newVal
				}
			}
		}
		switch {
		// 某层只有一个节点
		case left != nil && right == nil, left == nil && right != nil:
			res = max(res, 1)
		case left != nil && right != nil:
			res = max(res, *right-*left+1)
		}
	}

	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// @lc code=end

