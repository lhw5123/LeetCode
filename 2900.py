# https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/?envType=daily-question&envId=2025-05-21
class Solution:
    def getLongestSubsequence(self, words: List[str], groups: List[int]) -> List[str]:
        # 贪心算法。
        # 因为 groups 只有 0,1 两种元素。所有一定可以构造一个包含第一个单词的最优解。
        return [words[0]] + [words[i] for i in range(1, len(groups)) if groups[i] != groups[i-1]]
