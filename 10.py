# https://leetcode.com/problems/regular-expression-matching/description/
class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        memo = {}

        def dp(i: int, j: int) -> bool:
            if (i, j) not in memo:
                if j == len(p):
                    ans = i == len(s)
                else:
                    # "*" 表示要和 s[i-1] 相同，所以不算在 first_match 里
                    first_match = i < len(s) and p[j] in {s[i], "."}
                    if j + 1 < len(p) and p[j + 1] == "*":
                        # "*" 可以匹配 0 次，也可以匹配多次。
                        ans = dp(i, j + 2) or first_match and dp(i + 1, j)
                    else:
                        ans = first_match and dp(i + 1, j + 1)
                
                memo[i, j] = ans
            return memo[i, j]

        return dp(0, 0)