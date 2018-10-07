package com.hevin.List;

/**
 * 从链表中删除一个节点。
 */
public class DeleteNode {

    /**
     * 基本思路，复制之后的一个节点到待删除节点。
     *
     * @param target 要删除的节点（不是尾节点）。
     */
    public static void deleteNode(ListNode target) {
        if (null == target) {
            return;
        }
        ListNode next = target.next;
        target.value = next.value;
        target.next = next.next;
    }
}
