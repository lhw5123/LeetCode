package com.hevin.List;

/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        int carry = 0;

        // carry != 0 用于判断最后一位数字相加是否大于 10 而增加一位。
        while (node1 != null || node2 != null || carry != 0) {
            int v1 = node1 == null ? 0 : node1.val;
            int v2 = node2 == null ? 0 : node2.val;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
        }

        return pre.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
