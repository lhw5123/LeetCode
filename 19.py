# 19. Remove Nth node from end of list
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        slow = fast = dummy

        for i in range(n + 1):
            fast = fast.next
        
        while fast:
            fast = fast.next
            slow = slow.next
        
        slow.next = slow.next.next
        return dummy.next

    # This is my original solution.
    def removeNthFromEnd2(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        length = 0
        p = head
        while p != None:
            length += 1
            p = p.next

        if n > length:
            return None
        
        dumb = ListNode(val = 0, next = head)
        p = dumb
        for i in range(length-n):
            p = p.next
        if p != None and p.next != None:
            p.next = p.next.next

        return dumb.next