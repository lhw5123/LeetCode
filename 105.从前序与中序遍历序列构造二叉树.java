import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        TreeNode root = new TreeNode(preorder[0]);
        int rootIdx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                rootIdx = i;
                break;
            }
        }

        int lTreeLength = rootIdx;
        int rTreeLength = inorder.length - lTreeLength - 1;

        int[] lin = Arrays.copyOfRange(inorder, 0, rootIdx);    // Note: 区间左闭右开
        int[] rin = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);

        int[] lpre = Arrays.copyOfRange(preorder, 1, lTreeLength + 1);
        int[] rpre = Arrays.copyOfRange(preorder, lpre.length + 1, preorder.length);

        root.left = buildTree(lpre, lin);
        root.right = buildTree(rpre, rin);

        return root;
    }
}
// @lc code=end

