# https://leetcode.com/problems/house-robber/description/
class Solution:
    def rob(self, nums: List[int]) -> int:
        # 记忆化搜索的解法
        # n = len(nums)
        # cache = [-1] * n
        # def dfs(i: int):
        #     if i < 0:
        #         return 0
        #     if cache[i] != -1:
        #         return cache[i]
        #     res = max(dfs[i - 1], dfs[i - 2] + nums[i])
        #     cache[i] = res
        #     return res
        # return dfs(n - 1)

        f0 = f1 = 0
        for _, v in enumerate(nums):
            f_new = max(f1, f0 + v)
            f0 = f1
            f1 = f_new
        return f1
