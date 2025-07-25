# Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
# A subarray is a contiguous part of the array.
class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
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
