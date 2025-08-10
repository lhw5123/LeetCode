from typing import List

# Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
# The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
# You must write an algorithm that runs in O(n) time and without using the division operation.
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result: List[int] = [1] * n

        prefix_product = 1
        for index in range(n):
            result[index] = prefix_product
            prefix_product *= nums[index]

        suffix_product = 1
        for index in range(n - 1, -1, -1):  # start:
            result[index] *= suffix_product
            suffix_product *= nums[index]

        return result