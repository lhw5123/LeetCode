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
        for (int i = 0; i < k; i++) {
            if (p == null) {
                return head;
            }
            p = p.next;
        }
        ListNode newHead = reverse(head, p);
        // 为什么这里是 head.next?
        // reverse(head, p) 之后，实际 head 就到了尾部，p.prev 则变成了 newHead
        head.next = reverseKGroup(p, k);
        return newHead;
    }

    // last 是不参与这次翻转的，可以理解为是下一段的头结点。
    public ListNode reverse(ListNode first, ListNode last) {
        ListNode prev = null, cur = first;
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

