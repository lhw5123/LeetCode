# https://leetcode.com/problems/target-sum/description/
class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        # p: 所有添加 + 数的和
        # s-p: 所有添加 - 数的和的绝对值
        # p-(s-p) = target
        # 2p-s = target
        # p = (s + target) / 2
        # 问题就转化成了从 nums 里找到一些数，使得其和等于 (s + target) / 2
        target += sum(nums)
        target //= 2

        # return 的是什么？当目标为 c 时，包含数字 nums[i] 的最多可选方案数量
        def dfs(i: int, c: int):
            if i < 0:
                return 1 if c == 0 else 0
            if c < nums[i]:
                # 不选
                return dfs(i - 1, c)
            # 返回选或者不选两种情况的最大值
            return max(dfs(i - 1, c), dfs(i - 1, c - nums[i]))

        return dfs(len(nums) - 1, target)
