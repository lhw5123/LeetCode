# 525. Contiguous Array
# Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        sum_map = {0: -1}
        max_length = 0
        prefix_sum = 0

        for i, num in enumerate(nums):
            # 把 0 转化成 -1。那如果一段子数组中 0 和 1 的数量相同，那这段子数组的元素和就为 0。
            # 这样题目就变成了，求两个相同前缀和之差最大的情况。
            prefix_sum += 1 if num == 1 else -1

            if prefix_sum in sum_map:
                length = i - sum_map[prefix_sum]
                max_length = max(max_length, length)
            else:
                sum_map[prefix_sum] = i

        return max_length
