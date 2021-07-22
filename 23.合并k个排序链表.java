import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     *  基于优先级队列完成。 
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // min-heap
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));

        for (ListNode head : lists) {
            if (head != null) {
                heap.offer(head);
            }
        }
        
        ListNode dumb = new ListNode(0);
        ListNode cur = dumb;
        while (!heap.isEmpty()) {
            ListNode p = heap.poll();
            cur.next = p;
            cur = cur.next;
            if (p.next != null) {
                heap.offer(p.next);
            }
        }

        return dumb.next;
    }
}
// @lc code=end

