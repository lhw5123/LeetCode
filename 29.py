# 29. Divide two integers
# Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
# The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
# Return the quotient after dividing dividend by divisor.
# Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        # binary search
        # Time complexity: O(log N)
        INT_MAX = 2**31 - 1
        INT_MIN = -2**31

        if divisor == 0:
            return INT_MIN

        res = 0
        sign = -1
        if (dividend > 0 and divisor > 0) or (dividend < 0 and divisor < 0):
            sign = 1
        
        dvd, dvs = abs(dividend), abs(divisor)
        while dvd >= dvs:
            temp = dvs
            m = 1
            while temp << 1 <= dvd:
                temp <<= 1
                m <<= 1
            dvd -= temp
            res += m
        
        res = sign * res
        if res < INT_MIN:
            return INT_MIN
        if res > INT_MAX:
            return INT_MAX
        return res