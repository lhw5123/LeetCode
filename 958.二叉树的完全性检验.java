import java.util.Queue;
import java.util.LinkedList;
import datastruct.TreeNode;

/*
 * @lc app=leetcode.cn id=958 lang=java
 *
 * [958] 二叉树的完全性检验
 *
 * https://leetcode.cn/problems/check-completeness-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (54.29%)
 * Likes:    199
 * Dislikes: 0
 * Total Accepted:    36.7K
 * Total Submissions: 67.7K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * 给定一个二叉树的 root ，确定它是否是一个 完全二叉树 。
 * 
 * 在一个 完全二叉树 中，除了最后一个关卡外，所有关卡都是完全被填满的，并且最后一个关卡中的所有节点都是尽可能靠左的。它可以包含 1 到 2^h
 * 节点之间的最后一级 h 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：root = [1,2,3,4,5,6]
 * 输出：true
 * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：false
 * 解释：值为 7 的结点没有尽可能靠向左侧。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树的结点数在范围  [1, 100] 内。
 * 1 <= Node.val <= 1000
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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 是否遍历完二叉树中非空的节点
        boolean end = false;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    end = true;
                } else {
                    if (end) {
                        return false;
                    }
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
        }
        return true;
    }
}
// @lc code=end

