# Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
# A subarray is a contiguous part of the array.
class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        # Original solution using prefix sum
        count = {0: 1}  # Initialize with 0 sum having 1 occurrence
        presum = 0
        res = 0

        for v in nums:
            presum += v
            # If (presum - goal) exists in count, it means there are subarrays ending at current position with sum = goal
            if presum - goal in count:
                res += count[presum - goal]
            # Increment the count of current prefix sum
            count[presum] = count.get(presum, 0) + 1

        return res
    
    # Alternative solution using sliding window (optimized for binary arrays)
    def numSubarraysWithSum_slidingWindow(self, nums: List[int], goal: int) -> int:
        return self.atMost(nums, goal) - self.atMost(nums, goal - 1)
    
    def atMost(self, nums: List[int], goal: int) -> int:
        if goal < 0:
            return 0
        
        left = 0
        result = 0
        current_sum = 0
        
        for right in range(len(nums)):
            current_sum += nums[right]
            
            # Shrink window from left while sum exceeds goal
            while current_sum > goal and left <= right:
                current_sum -= nums[left]
                left += 1
            
            # Add count of valid subarrays ending at right
            # For each right position, we count all possible left positions
            result += right - left + 1
        
        return result
