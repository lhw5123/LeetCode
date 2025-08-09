# You have two soups, A and B, each starting with n mL. On every turn, one of the following four serving operations is chosen at random, each with probability 0.25 independent of all previous turns:
#
# pour 100 mL from type A and 0 mL from type B
# pour 75 mL from type A and 25 mL from type B
# pour 50 mL from type A and 50 mL from type B
# pour 25 mL from type A and 75 mL from type B
# Note:
#
# There is no operation that pours 0 mL from A and 100 mL from B.
# The amounts from A and B are poured simultaneously during the turn.
# If an operation asks you to pour more than you have left of a soup, pour all that remains of that soup.
# The process stops immediately after any turn in which one of the soups is used up.
#
# Return the probability that A is used up before B, plus half the probability that both soups are used up in the same turn. Answers within 10-5 of the actual answer will be accepted.
import math


class Solution:
    def soupServings(self, n: int) -> float:
        # The answer is P(A is empty before B) + 0.5 * P(A and B are empty at the same time)
        # For large n, the probability approaches 1.
        # This value is found empirically. For n >= 4800, the result is > 0.99999.
        if n >= 4800:
            return 1.0

        # Scale down the problem by using units of 25mL.
        m = math.ceil(n / 25)

        # memo[(i, j)] stores the answer for i units of A and j units of B.
        memo = {}

        def solve(a, b):
            # Base case: A and B empty simultaneously
            if a <= 0 and b <= 0:
                return 0.5
            # Base case: A empty first
            if a <= 0:
                return 1.0
            # Base case: B empty first
            if b <= 0:
                return 0.0

            if (a, b) in memo:
                return memo[(a, b)]

            # Recursive step
            prob = 0.25 * (
                solve(a - 4, b)  # 100mL A, 0mL B
                + solve(a - 3, b - 1)  # 75mL A, 25mL B
                + solve(a - 2, b - 2)  # 50mL A, 50mL B
                + solve(a - 1, b - 3)  # 25mL A, 75mL B
            )
            memo[(a, b)] = prob
            return prob

        return solve(m, m)
