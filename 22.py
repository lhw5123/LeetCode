# Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
from typing import List
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        # DP approach
        # dp[i] stores all valid parentheses strings with i pairs
        dp = [[] for _ in range(n + 1)]
        dp[0] = [""]  # Base case: empty string for 0 pairs
        
        for i in range(1, n + 1):
            # For each i, we need to consider all combinations of (j) and (i-j-1)
            for j in range(i):
                # Left part: j pairs
                # Right part: i-j-1 pairs
                # 每新增一对括号，这对新括号就可以依次把之前的所有结果都包裹一遍。
                for left in dp[j]:
                    for right in dp[i-j-1]:
                        dp[i].append("(" + left + ")" + right)
    
        return dp[n]

    # ()
    # ()(),(())
    # ()()(), ((())), (())(), ()(()), (()())
        
    # Original backtracking solution for reference
    def generateParenthesisBacktracking(self, n: int) -> List[str]:
        result = []
        
        def backtrack(s="", open_count=0, close_count=0):
            # Base case: if we have used all n pairs
            if len(s) == 2 * n:
                result.append(s)
                return
            
            # Add open parenthesis if we haven't used all n
            if open_count < n:
                backtrack(s + "(", open_count + 1, close_count)
            
            # Add closing parenthesis if valid (more open than closed)
            if close_count < open_count:
                backtrack(s + ")", open_count, close_count + 1)
        
        backtrack()
        return result
