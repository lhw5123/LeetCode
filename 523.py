# https://leetcode.com/problems/continuous-subarray-sum/description/
class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        # Map to store the first occurrence of each remainder
        # Initialize with {0: -1} to handle subarray starting from index 0
        # key: remainder; value: last remainder index
        remainder_map = {0: -1}
        prefix_sum = 0
        
        # 我一直把握不好两个元素之间的距离问题。
        # 如果两个元素位置分别是 x 和 y，在两者的距离是 |y - x|。比如，下标 0, 2 的元素之间的距离是 2。
        # 如果一个子序列，第一个元素的位置是 x，最后一个元素的位置是 y，则子序列的长度是：y - x + 1。
        
        for i, num in enumerate(nums):
            prefix_sum += num
            remainder = prefix_sum % k  # 中文里的余数;difference:差(两数相减的差)
            
            # If we've seen this remainder before
            if remainder in remainder_map:
                # Check if the subarray length is at least 2
                if i - remainder_map[remainder] > 1:
                    return True
            else:
                # Store the first occurrence of this remainder
                remainder_map[remainder] = i
                
        return False