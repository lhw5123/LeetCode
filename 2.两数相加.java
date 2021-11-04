/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        int carry = 0;
        ListNode head = new ListNode();
        ListNode p = head;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 != null) {
            int val1 = 0, val2 = 0;
            if (p1 != null) {
                val1 = p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                val2 = p2.val;
                p2 = p2.next;
            }
            int sum = val1 + val2 + carry;
            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum / 10;
        }
        if (carry != 0) {
            p.next = new ListNode(carry);
        }

        return head.next;
    }
}
// @lc code=end

