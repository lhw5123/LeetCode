import datastruct.*;

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
    ListNode cur;

    // 二叉搜索树：节点值按照左中右有序。
    public TreeNode sortedListToBST(ListNode head) {
        cur = head;
        int len = listLength(head);
        return buildTree(0, len - 1);
    }

    // 中序遍历
    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode();
        // 先构建左子树，当构建完成时，cur 也就指向了中间结点。
        node.left = buildTree(left, mid - 1);
        node.val = cur.val;
        cur = cur.next;
        node.right = buildTree(mid + 1, right);
        return node;
    }

    private int listLength(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        return len;
    }
}
// @lc code=end

