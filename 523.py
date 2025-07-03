# https://leetcode.com/problems/continuous-subarray-sum/description/
class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        # Map to store the first occurrence of each remainder
        # Initialize with {0: -1} to handle subarray starting from index 0
        remainder_map = {0: -1}
        prefix_sum = 0
        
        for i, num in enumerate(nums):
            prefix_sum += num
            remainder = prefix_sum % k
            
            # If we've seen this remainder before
            if remainder in remainder_map:
                # Check if the subarray length is at least 2
                if i - remainder_map[remainder] > 1:
                    return True
            else:
                # Store the first occurrence of this remainder
                remainder_map[remainder] = i
                
        return False