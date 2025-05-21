# https://leetcode.com/problems/set-matrix-zeroes/?envType=daily-question&envId=2025-05-21
class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        # 只要有一个元素为 0，就把对应行和列的所有元素都置为 0
        # 时间复杂度：O(m*n)
        # 空间复杂度：O(m+n)
        rows = len(matrix)
        cols = len(matrix[0])

        zero_rows = set()
        zero_cols = set()

        for y in range(rows):
            for x in range(cols):
                if matrix[y][x] == 0:
                    zero_rows.add(y)
                    zero_cols.add(x)

        for y in range(rows):
            for x in range(cols):
                if y in zero_rows or x in zero_cols:
                    matrix[y][x] = 0