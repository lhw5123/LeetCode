/*
 * @lc app=leetcode.cn id=23 lang=cpp
 *
 * [23] 合并K个排序链表
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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        int amount = lists.size();
        if (amount == 0)
            return nullptr;

        int interval = 1;
        while (interval < amount)
        {
            for (int i = 0; i < amount - interval; i += interval * 2)
            {
                ListNode* head = mergeTwoLists(lists[i], lists[i + interval]);
                lists[i] = head;
            }
            interval *= 2;
        }
        return lists[0];
    }

    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (l1 == nullptr)
            return l2;

        if (l2 == nullptr)
            return l1;

        ListNode* head = new ListNode(0);
        ListNode* curPtr = head;
        while (l1 != nullptr && l2 != nullptr)
        {
            if (l1->val <= l2->val)
            {
                curPtr->next = l1;
                curPtr = curPtr->next;
                l1 = l1->next;
            }
            else
            {
                curPtr->next = l2;
                curPtr = curPtr->next;
                l2 = l2->next;
            }
        }
        if (l1 == nullptr)
        {
            curPtr->next = l2;
        }
        if (l2 == nullptr)
        {
            curPtr->next = l1;
        }
        return head->next;
    }
};
// @lc code=end

