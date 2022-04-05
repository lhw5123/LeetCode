import datastruct.ListNode;
/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode(0, head);
        ListNode pre = newHead;
        for (int i = 0; pre.next != null && i < left - 1; i++) {
            pre = pre.next;
        }
        if (pre.next == null) {
            return head;
        }

        ListNode cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = pre.next;
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = next;
        }
        return newHead.next;
    }
}
// @lc code=end

