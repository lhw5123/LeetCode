import java.util.ArrayList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    ListNode mHead;

    public TreeNode sortedListToBST(ListNode head) {
        mHead = head;
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        return buildTree(0, len - 1);
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        // 先构建左子树，构建完成后 mHead 自然就指向了中间结点。
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = mHead.val;
        mHead = mHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }
}
// @lc code=end

