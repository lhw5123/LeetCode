/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        int len = getSize(head);
        if (len <= 1) {
            return head;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }

        ListNode cuttingPoint = findCuttingPoint(head, len - k - 1);

        ListNode newHead = cuttingPoint.next;
        cuttingPoint.next = null;

        ListNode tail = findTail(newHead);
        tail.next = head;
        return newHead;
    }

    private int getSize(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            ++size;
            cur = cur.next;
        }
        return size;
    }

    // 表示从第 k + 1 个节点之后断开链表
    private ListNode findCuttingPoint(ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private ListNode findTail(ListNode head) {
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }
}
// @lc code=end

