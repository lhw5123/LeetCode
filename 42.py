# https://leetcode.com/problems/trapping-rain-water/
class Solution:
    def trap(self, height: List[int]) -> int:
        l = 0
        r = len(height) - 1
        lMax = 0
        rMax = 0
        sum = 0
        while l < r:
            lMax = max(lMax, height[l])
            rMax = max(rMax, height[r])
            if lMax < rMax:
                sum += (lMax - height[l])
                l += 1
            else:
                sum += (rMax - height[r])
                r -= 1
        return sum
