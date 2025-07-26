# Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
# Return the number of nice sub-arrays.
from typing import List

class Solution:
    def numberOfSubarrays(self, nums: List[int], k: int) -> int:
        res = 0
        count_map = {0: 1}
        curr_sum = 0    # odds count

        for v in nums:
            curr_sum += v % 2
            
            if curr_sum - k in count_map:
                res += count_map[curr_sum - k]
            
            count_map[curr_sum] = count_map.get(curr_sum, 0) + 1
        
        return res