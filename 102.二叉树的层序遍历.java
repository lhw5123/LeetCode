import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs(root, 0, res);

        return res;
    }

    // @param level: root 所在的深度。
    private void dfs(TreeNode root, int level, List<List<Integer>> list) {
        if (root == null) {
            return;
        }

        // Q: 为什么这里是 < level + 1。
        // A: 因为 level 是从 0 开始，所以 level 代表的是第 level + 1 个 list。
        if (list.size() < level + 1) {
            list.add(new ArrayList<Integer>());
        }

        list.get(level).add(root.val);
        dfs(root.left, level + 1, list);
        dfs(root.right, level + 1, list);
    }
}
// @lc code=end

