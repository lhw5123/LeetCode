/*
 * @lc app=leetcode.cn id=19 lang=cpp
 *
 * [19] 删除链表的倒数第N个节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        // 利用哑结点，避免判断链表是不是只有一个结点。
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* first = dummy;
        ListNode* second = dummy;
        for (int i = 0; i < n + 1; i++)
        {
            first = first->next;
        }
        while (first != NULL)
        {
            first = first->next;
            second = second->next;
        }
        second->next = second->next->next;
        return dummy->next;
    }
};
// @lc code=end

