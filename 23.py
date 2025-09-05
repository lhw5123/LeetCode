# 23.Merge k Sorted Lists
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        # heapq 提供的是小顶堆的实现
        import heapq

        if not lists:
            return None

        heap = []

        for i, lst in enumerate(lists):
            if lst:
                # 把元组全部保存。原因是 heap 比较大小时，会比较元组里的所有值。
                # 先比较 val，再比较 index。而因为 index 肯定不一样，所以最后的 node 对象根本不会参与比较。
                heapq.heappush(heap, (lst.val, i, lst))

        dummy = ListNode(0)
        curr = dummy

        while heap:
            val, i, node = heapq.heappop(heap)
            curr.next = node
            curr = curr.next

            if node.next:
                heapq.heappush(heap, (node.next.val, i, node.next))

        return dummy.next
