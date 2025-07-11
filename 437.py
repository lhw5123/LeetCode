# 437. Path Sum III
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        prefix_sum_map = {0: 1}
        self.count = 0

        def dfs(node: Optional[TreeNode], current_path_sum: int):
            if not node:
                return

            current_path_sum += node.val

            self.count += prefix_sum_map.get(current_path_sum - targetSum, 0)

            prefix_sum_map[current_path_sum] = prefix_sum_map.get(current_path_sum, 0) + 1

            dfs(node.left, current_path_sum)
            dfs(node.right, current_path_sum)

            prefix_sum_map[current_path_sum] -= 1
            if prefix_sum_map[current_path_sum] == 0:
                del prefix_sum_map[current_path_sum]

        dfs(root, 0)
        return self.count
