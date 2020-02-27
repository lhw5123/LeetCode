/*
 * @lc app=leetcode.cn id=61 lang=kotlin
 *
 * [61] 旋转链表
 */

// @lc code=start
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 * 
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        // 思路：找到倒数第 k 个节点，然后将其后的链表链接到开头。
        if (head == null || head.next == null) {
            return head
        }

        // 将旧链表的尾部链接到头部，形成一个环。
        var oldTail = head!!  // 指向旧链表的尾部。
        var n = 1   // 链表长度
        while (oldTail.next != null) {
            oldTail = oldTail.next
            n++
        }
        oldTail.next = head

        // 找出新的尾节点：(n - k % n - 1)
        // 找出新的头节点：(n - k % n)
        var newTail = head!!
        for (i in 0 until (n - k % n - 1)) {
            newTail = newTail.next
        }
        var newHead = newTail.next

        // 断掉环
        newTail.next = null

        return newHead
    }
}
// @lc code=end

