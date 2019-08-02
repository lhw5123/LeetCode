/*
 * @lc app=leetcode.cn id=445 lang=cpp
 *
 * [445] 两数相加 II
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
        ListNode *p = l1, *q = l2;
        ListNode* head = new ListNode(-1);
        stack<int> s1, s2;
        while (p != NULL)
        {
            s1.push(p -> val);
            p = p -> next;
        }
        while (q != NULL)
        {
            s2.push(q -> val);
            q = q -> next;
        }
        int sum;
        bool carry = false;
        while (!s1.empty() || !s2.empty())
        {
            sum = 0;
            if (!s1.empty())
            {
                sum += s1.top();
                s1.pop();
            }
            if (!s2.empty())
            {
                sum += s2.top();
                s2.pop();
            }
            if (carry)
            {
                sum++;
            }
            // 关键在这里的插入算法。
            // 和 2.两数相加不同。这里对新结点进行头插法。
            ListNode* newNode = new ListNode(sum % 10);
            newNode -> next = head -> next;
            head -> next = newNode;
            carry = sum >= 10 ? true : false;
        }
        if (carry)
        {
            ListNode* newNode = new ListNode(1);
            newNode -> next = head -> next;
            head -> next = newNode;
        }
        return head -> next;
    }
};

