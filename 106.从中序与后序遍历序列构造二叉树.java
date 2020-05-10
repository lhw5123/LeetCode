import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }

        if (postorder.length == 1) {
            return new TreeNode(postorder[postorder.length - 1]);
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int rootIdx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                rootIdx = i;
                break;
            }
        }

        int[] lin = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] rin = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);

        int[] lpost = Arrays.copyOfRange(postorder, 0, lin.length);
        int[] rpost = Arrays.copyOfRange(postorder, lpost.length, postorder.length - 1);

        root.left = buildTree(lin, lpost);
        root.right = buildTree(rin, rpost);

        return root;
    }
}
// @lc code=end

