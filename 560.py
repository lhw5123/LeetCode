# Given an array of integers nums and an integer k, 
# return the total number of subarrays whose sum equals to k.
# A subarray is a contiguous non-empty sequence of elements within an array.
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:      
        res = 0
        prefix_sum = 0
        prefix_map = {0: 1}
    
        for num in nums:
            prefix_sum += num
            if prefix_sum - k in prefix_map:
                res += prefix_map[prefix_sum - k]  
            prefix_map[prefix_sum] = prefix_map.get(prefix_sum, 0) + 1
        
        return res
