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
        ListNode node = null;
        int sum;
        int buf = 0;
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                if (node != null) {
                    node = new ListNode((node2.val + buf) % 10);
                } else {
                    node.next = new ListNode((node2.val + buf) % 10);
                }
                if (node2.val + buf > 10) {
                    buf = 1;
                }
                node2 = node2.next;
            } else if (node2 == null) {

                node1 = node1.next;
            } else {

                node1 = node1.next;
                node2 = node2.next;
            }
        }
        return node;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
