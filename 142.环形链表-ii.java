/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 * 给定一个链表，如果链表中存在环，则返回链表中环的起始节点，如果没有环，返回 null。
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // Floyd 算法的完整形式
    // 1. 用快慢指针判断是否有环
    // 2. 当快慢指针相遇，将慢指针放回到起点。然后快、慢指针每次都只走一步，当二者相遇时，即为环路的入口。
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
// @lc code=end

