/*
 * @lc app=leetcode.cn id=652 lang=golang
 *
 * [652] 寻找重复的子树
 *
 * https://leetcode.cn/problems/find-duplicate-subtrees/description/
 *
 * algorithms
 * Medium (60.44%)
 * Likes:    580
 * Dislikes: 0
 * Total Accepted:    76.5K
 * Total Submissions: 126.6K
 * Testcase Example:  '[1,2,3,4,null,2,4,null,null,4]'
 *
 * 给定一棵二叉树 root，返回所有重复的子树。
 *
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 *
 * 输入：root = [1,2,3,4,null,2,4,null,null,4]
 * 输出：[[2,4],[4]]
 *
 * 示例 2：
 *
 *
 *
 *
 * 输入：root = [2,1,1]
 * 输出：[[1]]
 *
 * 示例 3：
 *
 *
 *
 *
 * 输入：root = [2,2,2,3,null,3,null]
 * 输出：[[2,3],[3]]
 *
 *
 *
 * 提示：
 *
 *
 * 树中的结点数在[1,10^4]范围内。
 * -200 <= Node.val <= 200
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
// 将二叉树序列化成字符串，然后进行比较
func findDuplicateSubtrees(root *TreeNode) []*TreeNode {
	repeat := map[*TreeNode]struct{}{}
	seen := map[string]*TreeNode{}

	var dfs func(*TreeNode) string // 序列化函数
	dfs = func(node *TreeNode) string {
		if node == nil {
			return ""
		}
		serial := fmt.Sprintf("%d(%s)(%s)", node.Val, dfs(node.Left), dfs(node.Right))
		if n, ok := seen[serial]; ok {
			repeat[n] = struct{}{}
		} else {
			seen[serial] = node
		}
		return serial
	}

	dfs(root)
	ans := make([]*TreeNode, 0, len(repeat))
	for node := range repeat {
		ans = append(ans, node)
	}
	return ans
}

// @lc code=end

