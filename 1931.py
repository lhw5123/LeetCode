# https://leetcode.com/problems/painting-a-grid-with-three-different-colors/?envType=daily-question&envId=2025-05-18
# Hint: Dynamic Programming

class Solution:
    def colorTheGrid(self, m: int, n: int) -> int:
        MOD = 10**9 + 7

        # product: 组合迭代器，返回所有可能的组合
        from itertools import product
        
        # 枚举所有合法列组合(没有连续两行相同的元素)
        def is_valid(col):
            for i in range(1, m):
                if col[i] == col[i-1]:
                    return False
            return True
        
        colors = [0, 1, 2]
        all_states = [tuple(p) for p in product(colors, repeat=m) if is_valid(p)]

        # 判断两个状态能否兼容
        compatible_states = {}
        for a in all_states:
            compatible_states[a] = []
            for b in all_states:
                if all(x != y for x, y in zip(a, b)):
                    compatible_states[a].append(b)

        # 初始化 dp
        dp = {} # 定义一个空字典
        for state in all_states:
            dp[state] = 1

        for _ in range(1, n):
            new_dp = {}
            for curr in all_states:
                new_dp[curr] = 0
                for prev in compatible_states[curr]:
                    new_dp[curr] = (new_dp[curr] + dp[prev]) % MOD
            dp = new_dp

        return sum(dp.values()) % MOD
