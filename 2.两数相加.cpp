/*
 * @lc app=leetcode.cn id=2 lang=cpp
 *
 * [2] 两数相加
 */
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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* head = new ListNode(-1);
        ListNode* h = head;
        ListNode *p = l1, *q = l2;
        int sum;
        bool carry = false;
        while (p != NULL || q != NULL)
        {
            sum = 0;
            if (p != NULL)
            {
                sum += p -> val;
                p = p -> next;
            }
            if (q != NULL)
            {
                sum += q -> val;
                q = q -> next;
            }
            if (carry)
            {
                sum++;
            }
            h -> next = new ListNode(sum % 10);
            h = h -> next;
            carry = sum >= 10 ? true : false;
        }
        if (carry)
        {
            h -> next = new ListNode(1);
        }
        return head -> next;
    }
};
