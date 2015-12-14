package com.hevin.array;

import com.hevin.structure.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class ConstructBinaryTree2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }
        int pLen = preorder.length;
        int iLen = inorder.length;
        return myBuildTree(preorder, 0, pLen - 1, inorder, 0, iLen - 1);
    }

    private int findPosition(int[] order, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (order[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private TreeNode myBuildTree(int[] preorder, int pstart, int pend,
            int[] inorder, int instart, int inend) {
        if (instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);
        int position = findPosition(inorder, instart, inend, preorder[pstart]);

        root.left = myBuildTree(preorder, pstart + 1, pstart + position - instart,
                inorder, instart, position - 1);
        root.right = myBuildTree(preorder, pstart + position - instart + 1, pend,
                inorder, position + 1, inend);
        return root;
    }

}
