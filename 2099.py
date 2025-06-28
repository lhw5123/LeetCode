# https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/description/?envType=daily-question&envId=2025-06-28
# 2099. Find Subsequence of Length K With the Largest Sum
# The items' order in the subsequence should be same with the input 'nums'.
# 思路：排序
class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        vals = [[i, nums[i]] for i in range(n)]
        # 对 vals 根据 key 的值降序排列
        vals.sort(key=lambda x: -x[1])
        vals = sorted(vals[:k])
        res = [val for idx, val in vals]
        return res