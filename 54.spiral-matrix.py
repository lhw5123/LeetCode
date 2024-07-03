#
# @lc app=leetcode id=54 lang=python3
#
# [54] Spiral Matrix
#
# https://leetcode.com/problems/spiral-matrix/description/
#
# algorithms
# Medium (50.12%)
# Likes:    14705
# Dislikes: 1300
# Total Accepted:    1.5M
# Total Submissions: 2.9M
# Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
#
# Given an m x n matrix, return all elements of the matrix in spiral order.
# 
# 
# Example 1:
# 
# 
# Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
# Output: [1,2,3,6,9,8,7,4,5]
# 
# 
# Example 2:
# 
# 
# Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
# Output: [1,2,3,4,8,12,11,10,9,5,6,7]
# 
# 
# 
# Constraints:
# 
# 
# m == matrix.length
# n == matrix[i].length
# 1 <= m, n <= 10
# -100 <= matrix[i][j] <= 100
# 
# 
#

# @lc code=start
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        ans = []
        left, up, right, down = 0, 0, len(matrix[0])-1, len(matrix)-1

        while True:
            for i in range(left, right+1):
                ans.append(matrix[up][i])
            up += 1
            if up > down:
                break

            for i in range(up, down+1):
                ans.append(matrix[i][right])
            right -= 1
            if right < left:
                break

            for i in range(right, left-1, -1):
                ans.append(matrix[down][i])
            down -= 1
            if down < up:
                break

            for i in range(down, up-1, -1):
                ans.append(matrix[i][left])
            left += 1
            if left > right:
                break

        return ans
# @lc code=end

