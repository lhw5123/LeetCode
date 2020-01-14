/*
 * @lc app=leetcode.cn id=83 lang=kotlin
 *
 * [83] 删除排序链表中的重复元素
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
 */
class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var cur = head
        var pre = cur
        val map = mutableMapOf<Int, Int>()
        while (cur != null) {
            if (!map.containsKey(cur.`val`)) {
                map.put(cur.`val`, 1)
                pre = cur
                cur = cur.next
            } else {
                // 删除当前结点
                pre!!.next = cur.next
                cur = cur.next
            }
        }
        return head
    }
}
// @lc code=end

