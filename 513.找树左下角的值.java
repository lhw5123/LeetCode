import datastruct.TreeNode;

/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
 *
 * https://leetcode.cn/problems/find-bottom-left-tree-value/description/
 *
 * algorithms
 * Medium (73.16%)
 * Likes:    334
 * Dislikes: 0
 * Total Accepted:    117.2K
 * Total Submissions: 157.8K
 * Testcase Example:  '[2,1,3]'
 *
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 
 * 假设二叉树中至少有一个节点。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 
 * 
 * 输入: root = [2,1,3]
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * ⁠
 * 
 * 
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 二叉树的节点个数的范围是 [1,10^4]
 * -2^31  
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int depth;
    private int maxDepth;
    private TreeNode res;

    public int findBottomLeftValue(TreeNode root) {
        traverse(root);
        return res.val;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        depth++;
        // 到达最大深度时第一次遇到的节点就是最底层、最左边节点。
        if (depth > maxDepth) {
            maxDepth = depth;
            res = root;
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
// @lc code=end

