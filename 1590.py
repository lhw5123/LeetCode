# Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p. It is not allowed to remove the whole array.
# Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.
# A subarray is defined as a contiguous block of elements in the array.

class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        total_sum = sum(nums)      
        target = total_sum % p
        if target == 0:
            return 0

        pre_sum = 0
        pre_sum_map = {0: -1} # the value is 1 if it is count; is -1 if it is index.
        res = len(nums)
        
        for i, v in enumerate(nums):
            pre_sum = (pre_sum + v) % p
            # Not to find a subarray sum equal to target, but rather remainder equal to target.
            to_find = (pre_sum - target) % p
            
            if to_find in pre_sum_map:
                res = min(res, i - pre_sum_map[to_find])
                
            pre_sum_map[pre_sum] = i

        return res if res < len(nums) else -1