# Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
# A subarray is a contiguous part of an array.
class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        pre_sum = 0
        pre_sum_map = {0: 1}    # key: remainder; value: count of occurrences.
        res = 0

        for v in nums:
            pre_sum += v
            remainder = pre_sum % k
            if remainder in pre_sum_map:
                # Because every item found before can combined with the new item as a subarray.
                res += pre_sum_map[remainder]
                pre_sum_map[remainder] += 1
            else:
                # We can not add 1 directly if the target key not exist.
                pre_sum_map[remainder] = 1

        return res
