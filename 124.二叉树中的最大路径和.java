import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        oneSideMax(root);
        return maxSum;
    }

    private int oneSideMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = oneSideMax(root.left);
        int right = oneSideMax(root.right);

        int curMax = Math.max(Math.max(left + root.val, right + root.val), root.val);
        maxSum = Math.max(maxSum, Math.max(curMax, left + right + root.val));
        return curMax;
    }
}
// @lc code=end

