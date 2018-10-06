package com.hevin.List;

/**
 * 翻转单链表。
 */
public class ReverseList {

    /**
     * 翻转单链表。
     *
     * @param head 待翻转的单链表头结点。
     * @return 翻转后单链表的头结点。
     */
    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
