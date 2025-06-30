# https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/description/?envType=daily-question&envId=2025-06-28
# 2099. Find Subsequence of Length K With the Largest Sum
# The items' order in the subsequence should be same with the input 'nums'.
# 题目内容：给定一组数字集合和数字 k，求集合中和最大的 k 个数字，返回的顺序和原数组中相同。
# 思路：排序
class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        vals = [[i, nums[i]] for i in range(n)]
        vals.sort(key=lambda x:-x[1])
        vals = sorted(vals[:k])
        return [v for _, v in vals]
#               │   │       │    │
#               │   │       │    └── 数据源（要遍历的列表）
#               │   │       └────── 解包：将每个子列表的第二个元素赋给 v
#               │   └────────────── 解包：将每个子列表的第一个元素赋给 vals
#               └────────────────── 表达式：返回 v 的值