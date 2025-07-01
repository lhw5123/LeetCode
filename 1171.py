# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeZeroSumSublists(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head
        prefix_sum = 0
        prefix_map = {}
        cur = dummy
        while cur:
            prefix_sum += cur.val
            prefix_map[prefix_sum] = cur
            cur = cur.next
        
        prefix_sum = 0
        cur = dummy
        while cur:
            prefix_sum += cur.val
            cur.next = prefix_map[prefix_sum].next
            cur = cur.next

        return dummy.next