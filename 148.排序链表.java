/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    // 自底向上归并
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }

        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }

        ListNode dummyHead = new ListNode(0, head);
        for (int subLen = 1; subLen < len; subLen *= 2) {
            ListNode pre = dummyHead, cur = dummyHead.next;
            while (cur != null) {
                // 构造第一个链表
                ListNode head1 = cur;
                for (int i = 1; i < subLen && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;

                // 构造第二个链表
                for (int i = 1; i < subLen && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }

                ListNode merged = merge(head1, head2);
                pre.next = merged;
                while (pre.next != null) {
                    pre = pre.next;
                }
                cur = next;
            }
        }
        return dummyHead.next;
    }

    // 21. 合并两个有序链表
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode p = l, temp1 = l1, temp2 = l2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                p.next = temp1;
                temp1 = temp1.next;
            } else {
                p.next = temp2;
                temp2 = temp2.next;
            }
            p = p.next;
        }
        p.next = temp1 == null ? temp2 : temp1;
        return l.next;
    }
}
// @lc code=end
