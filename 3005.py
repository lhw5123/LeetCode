from typing import Counter


class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        if not nums:
            return 0

        freq = Counter(nums)
        max_freq = max(freq.values())
        return sum(cnt for cnt in freq.values() if cnt == max_freq)

