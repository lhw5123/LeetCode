/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
class Solution {
    // 递归
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        // 移动 k 次之后，p 就指向第 k+1 个节点
        for (int i = 0; i < k; i++) {
            if (p == null) {
                return head;
            }
            p = p.next;
        }
        ListNode newHead = reverse(head, p);
        head.next = reverseKGroup(p, k);
        return newHead;
    }

    // last 是不参与这次翻转的，可以理解为是下一段的头结点。
    public ListNode reverse(ListNode first, ListNode last) {
        ListNode prev = null;
        ListNode cur = first;
        while (cur != last) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
// @lc code=end

