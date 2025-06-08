# https://leetcode.com/problems/find-closest-node-to-given-two-nodes/?envType=daily-question&envId=2025-05-30
class Solution:
    def closestMeetingNode(self, edges: List[int], node1: int, node2: int) -> int:
        # edges[i] 表示有从节点 i 到 edges[i] 的边。if no edge, edges[i] = -1
        # 这道题里每个节点最多只有一个出度
        n = len(edges)
