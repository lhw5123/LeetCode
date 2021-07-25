/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointA = headA;
        ListNode pointB = headB;

        int lenA = 0, lenB = 0;
        while (pointA != null) {
            pointA = pointA.next;
            lenA++;
        }
        while (pointB != null) {
            pointB = pointB.next;
            lenB++;
        }

        pointA = headA;
        pointB = headB;
        int diff = Math.abs(lenA - lenB);
        while (diff-- > 0) {
            if (lenA > lenB) {
                pointA = pointA.next;
            } else {
                pointB = pointB.next;
            }
        }

        while (pointA != pointB) {
            pointA = pointA.next;
            pointB = pointB.next;
        }
        return pointA;
    }
}
// @lc code=end

