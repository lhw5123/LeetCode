import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        TreeNode p = root;
        // 用 ArrayList 要比 LinkedList 快很多。
        List<TreeNode> queue = new ArrayList<>();
        queue.add(p);
        while (!queue.isEmpty()) {
            List<TreeNode> tempList = new ArrayList<>();
            int i = 0, n = queue.size();
            while (i < n) {
                TreeNode node = queue.remove(0);
                if (node.left != null) {
                    tempList.add(node.left);
                }
                if (node.right != null) {
                    tempList.add(node.right);
                }
                if (i == n - 1) {
                    res.add(node.val);
                }
                i++;
            }
            queue.addAll(tempList);
        }
        return res;
    }
}
// @lc code=end

